fn main() {
    let mut vs = Vec::with_capacity(4);
    let start = std::time::Instant::now();
    for i in 0..4 {
        vs.push(i);
    }
    let a = vs[3];
    println!("{}", a);
    println!("took {:?}", start.elapsed());
}
