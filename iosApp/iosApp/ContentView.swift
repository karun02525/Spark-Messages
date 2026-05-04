import Shared
import SwiftUI

struct ContentView: View {
    var body: some View {
        ZStack {
            VStack {
                Text("Your Main UI")
                
                Button("Trigger Test") {
                    // 1. Get the instance from Koin
                    let msgService = ToastSdk.shared.getNativeBridge()
                    
                    // 2. Call the function (Ensure 'msg:' label is present if Kotlin used 'msg')
                    msgService.share(message: "Testing iOS Toast Connection!")
                }
            }
        }
    }
}
