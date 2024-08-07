fn main() {
    let mut vs = Vec::with_capacity(4);
    let start = std::time::Instant::now();
    for i in 0..4 {
        vs.push(i);
    }
    println!("took {:?}", start.elapsed());
}
