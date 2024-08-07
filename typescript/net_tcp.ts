import net from "net";

/*
Original code source:
https://www.udemy.com/course/fundamentals-of-networking-for-effective-backend-design

Use the following command to try it yourself.
nc 127.0.0.1 8800
*/

const server = net.createServer((socket) => {
    console.log(
        "TCP handshake successful with " +
            socket.remoteAddress +
            " : " +
            socket.remotePort
    );
    socket.write("Hello client!");

    socket.on("data", (data) => {
        console.log("Received data " + data.toString());
    });
});

server.listen(8800, "127.0.0.1");
