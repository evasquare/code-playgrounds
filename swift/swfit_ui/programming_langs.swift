import SwiftUI

let items = [
    "Rust",
    "TypeScript",
    "Python",
    "Go",
    "Swift",
    "C",
    "C++",
    "Java",
    "C#"
]

struct ContentView: View {
    var body: some View {
        NavigationView {
            VStack {
                List(items, id: \.self) {
                    Text($0)
                }
                .navigationTitle(
                    Text("💻 Programming Languages")
                )
                
                HStack {
                    Spacer()
                    Text(
                        "Built by Some People Writing Programs Working Group"
                    )
                    .foregroundColor(.accentColor)
                    Spacer()
                }
                .padding(.bottom, 25)
            }
            
        }
    }
}
