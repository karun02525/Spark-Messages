import Shared
import SwiftUI

struct ContentView: View {
    var body: some View {
        ZStack {
            Text("Main App Content")

            Button("Show Toast") {
                KmmUtils.shared.show(message: "Hello from KMM Toast! 🎉")
                KmmUtils.shared.showDialog(
                    title: "Dialog Title",
                    message: "Dialog Message",
                    buttonText: "OKay",
                )
                
            }
        }
    }
}
