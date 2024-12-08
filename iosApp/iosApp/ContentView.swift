import SwiftUI
import Shared

struct ContentView: View {

    var body: some View {
        VStack (alignment: .center) {
            
            Button(action: {}) {
                Text("Add Message To Queue")
            }
            
            Button(action: {}) {
                Text("Remove Message To Queue")
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .center)
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
