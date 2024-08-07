import SwiftUI

struct ContentView: View {
    var body: some View {
        ZStack {
            Color(red: 0.09, green: 0.63, blue: 0.52).edgesIgnoringSafeArea(/*@START_MENU_TOKEN@*/.all/*@END_MENU_TOKEN@*/)
            
            VStack {
                Image("rust-cover")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 150.0, height: 150.0)
                    .clipShape(/*@START_MENU_TOKEN@*/Circle()/*@END_MENU_TOKEN@*/)
                    .overlay(
                        Circle().stroke(Color.white, lineWidth: 5)
                    )
                
                Text("Ferris Rusta")
                    .font(Font.custom("Poppins-Regular", size: 40))
                // .fontWeight(.black)
                    .foregroundColor(.white)
                
                Text("Professional Mascot")
                    .foregroundColor(.white)
                    .font(.system(size: 18))
                
                Divider()
                InfoView(text: "+00 12 12345 67890", imageName: "phone.fill")
                InfoView(text: "ferris@rust-lang.org", imageName: "envelope.fill")
            }
        }
    }
}

#Preview {
    ContentView()
}
