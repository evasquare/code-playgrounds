use std::io::{self, stdin, Write};

fn main() {
    let mut input_vec: Vec<String> = Vec::new();

    println!("Welcome to OneShot robot text generator!");
    println!("Write each line and enter \"/br\" when you're done!");

    loop {
        print!("> ");
        io::stdout().flush().unwrap();
        let mut temp_input = String::new();

        match stdin().read_line(&mut temp_input) {
            Ok(_) => {
                temp_input = temp_input.trim().to_string();

                if temp_input.to_lowercase() == "/br" {
                    break;
                }

                if temp_input.is_empty() {
                    println!("Input cannot be empty!");
                    continue;
                }

                input_vec.push(temp_input);
            }
            Err(_) => {
                println!("Input reading failed. Please try again.");
                continue;
            }
        }
    }

    println!();

    for item in input_vec.iter() {
        println!("[ {} ]", item.to_uppercase());
    }
}
