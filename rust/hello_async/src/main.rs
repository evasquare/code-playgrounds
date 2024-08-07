// Source: https://rust-lang.github.io/async-book/09_example/00_intro.html

use std::{fs, time::Duration};

use async_std::{
    io::{Read, Write},
    net::TcpListener,
    prelude::*,
    task::{self, spawn},
};
use futures::stream::StreamExt;

mod mock_tcp_stream;

#[async_std::main]
async fn main() {
    // let listener = TcpListener::bind("127.0.0.1:7878").await.unwrap();
    // listener
    //     .incoming()
    //     .for_each_concurrent(/* limit */ None, |tcpstream| async move {
    //         let tcpstream = tcpstream.unwrap();
    //         handle_connection(tcpstream).await;
    //     })
    //     .await;
    let listener = TcpListener::bind("127.0.0.1:7878").await.unwrap();
    listener
        .incoming()
        .for_each_concurrent(/* limit */ None, |stream| async move {
            let stream = stream.unwrap();
            spawn(handle_connection(stream));
        })
        .await;
}

#[allow(clippy::unused_io_amount)]
// async fn handle_connection(mut stream: TcpStream) {
async fn handle_connection(mut stream: impl Read + Write + Unpin) {
    // Creates an array of 1024 elements, all initialized to the value 0.
    let mut buffer = [0; 1024];

    stream.read(&mut buffer).await.unwrap();
    // let bytes_read = stream.read(&mut buffer).unwrap();
    // let buffer = &buffer[..bytes_read];

    let get = b"GET / HTTP/1.1\r\n";
    let sleep = b"GET /sleep HTTP/1.1\r\n";

    let (status_line, filename) = if buffer.starts_with(get) {
        ("HTTP/1.1 200 OK\r\n\r\n", "hello.html")
    } else if buffer.starts_with(sleep) {
        task::sleep(Duration::from_secs(5)).await;
        ("HTTP/1.1 200 OK\r\n\r\n", "hello.html")
    } else {
        ("HTTP/1.1 404 NOT FOUND\r\n\r\n", "404.html")
    };
    let contents = fs::read_to_string(filename).unwrap();

    let response = format!("{status_line}{contents}");
    stream.write(response.as_bytes()).await.unwrap();
    stream.flush().await.unwrap();
}
