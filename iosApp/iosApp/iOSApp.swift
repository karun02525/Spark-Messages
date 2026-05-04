import Shared
import SwiftUI
import UIKit

@main
struct iOSApp: App {

    init() {
        ToastSdk.shared.setup()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

