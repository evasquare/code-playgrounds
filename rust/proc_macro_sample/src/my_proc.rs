use proc_macro2::TokenStream;
use quote::quote;

// Source: https://petanode.com/posts/rust-proc-macro/

pub fn my_proc_impl(input: TokenStream) -> TokenStream {
    quote!(println!("Answer: {}", #input))
}
