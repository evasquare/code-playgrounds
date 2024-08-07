import SwiftUI

struct InfoView: View {
    let text: String
    let imageName: String
    
    var body: some View {
        RoundedRectangle(cornerRadius: 25)
            .fill(Color.white)
            .frame(height: 50)
        // .foregroundColor(.white)
            .overlay(
                HStack {
                    Image(systemName: imageName)
                        .foregroundColor(.black)
                    Text(text)
                        .foregroundColor(.black)
                }
                
            )
            .padding(.horizontal)
    }
}

#Preview(traits: .sizeThatFitsLayout) {
    InfoView(text: "Hello", imageName: "phone.fill")
}
