import Shared
import SwiftUI
import UIKit

@main
struct iOSApp: App {
    
    init() {
        KMMInitializer.shared.start()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

//Global Toast Helper
