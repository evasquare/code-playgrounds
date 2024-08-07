import SwiftUI

struct ContentView: View {
    
    @ObservedObject var networkManager = NetworkManager()
    
    var body: some View {
        NavigationView {
            List(networkManager.posts) { post in
                NavigationLink(
                    destination: DetailView(url: post.url)) {
                        HStack {
                            Text(String(post.points))
                            Text(post.title)
                        }
                    }
            }
            .navigationTitle("H4X0R News")
        }
        .onAppear(
            perform: {
                self.networkManager.fetchData()
            }
        )
    }
}

#Preview {
    ContentView()
}

//struct Post: Identifiable {
//    let id: String
//    let title: String
//}
//
//let posts = [
//    Post(id: "1", title: "Hello"),
//    Post(id: "2", title: "Guten Morgen!"),
//    Post(id: "3", title: "Hola!"),
//]
