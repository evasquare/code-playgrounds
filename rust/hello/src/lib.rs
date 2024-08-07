use std::{
    sync::{mpsc, Arc, Mutex},
    thread,
};

/*
mpsc:
Multi-producer, single-consumer
FIFO queue communication primitives.
*/

/*
arc:
A thread-safe reference-counting pointer.
'Arc' stands for 'Atomically Reference Counted'.
*/

pub struct ThreadPool {
    workers: Vec<Worker>,
    sender: Option<mpsc::Sender<Job>>,
}

type Job = Box<dyn FnOnce() + Send + 'static>;

impl ThreadPool {
    /// Create a new ThreadPool.
    ///
    /// The size is the number of threads in the pool.
    ///
    /// # Panics
    ///
    /// The `new` function will panic if the size is zero.
    pub fn new(size: usize) -> ThreadPool {
        assert!(size > 0);

        let (sender, receiver) = mpsc::channel();

        let receiver = Arc::new(Mutex::new(receiver));

        let mut workers = Vec::with_capacity(size);

        for id in 0..size {
            workers.push(Worker::new(id, Arc::clone(&receiver)));
        }

        ThreadPool {
            workers,
            sender: Some(sender),
        }
    }

    /*
        - fnOnce(): This means the closure takes no parameters and returns no value.
          The Once part means that the closure can be called exactly once.
        - Send: This means the closure can be sent between threads safely.
        - 'static: This means the closure does not capture any non-static (i.e., stack-allocated) variables.
    */
    pub fn execute<F>(&self, f: F)
    where
        F: FnOnce() + Send + 'static,
    {
        let job = Box::new(f);

        self.sender.as_ref().unwrap().send(job).unwrap();
    }
}

impl Drop for ThreadPool {
    fn drop(&mut self) {
        /*
        This line is calling the drop function on the sender field of the ThreadPool instance.
        The take method replaces the sender with None and returns the original value.
        This is done to ensure that all messages that are currently in the channel are dropped,
        which will cause the workers to stop waiting for new jobs.
        */
        drop(self.sender.take());

        for worker in &mut self.workers {
            println!("Shutting down worker {}", worker.id);

            if let Some(thread) = worker.thread.take() {
                // This ensures that all workers finish their current job before the ThreadPool is dropped.
                thread.join().unwrap();
            }
        }
    }
}

struct Worker {
    id: usize,
    thread: Option<thread::JoinHandle<()>>,
}

impl Worker {
    fn new(id: usize, receiver: Arc<Mutex<mpsc::Receiver<Job>>>) -> Worker {
        /*
        `move || {}``
        Capture a closure's environment by value.
        move converts any variables captured by reference or
        mutable reference to variables captured by value. */

        /*
        `JoinHandle<T>`
        In Rust, when you spawn a new thread using thread::spawn,
        it returns a JoinHandle. You can call the join method on a JoinHandle
        to make the current thread wait until the spawned thread finishes.
        */

        let thread = thread::spawn(move || loop {
            let message = receiver.lock().unwrap().recv();

            match message {
                Ok(job) => {
                    println!("Worker {id} got a job; executing.");

                    job();
                }
                Err(_) => {
                    println!("Worker {id} disconnected; shutting down.");
                    break;
                }
            }
        });

        Worker {
            id,
            thread: Some(thread),
        }
    }
}
