
import Foundation
import SwiftUI
import Shared


// Library - IOSBridgeImpl.swift

public class IOSBridgeImpl: IOSBridge {

    public init() {}

    // ✅ Add `public` to all methods
    public func showToast(message: String) {
        DispatchQueue.main.async {
            ToastPresenter.show(message: message)
        }
    }

    public func share(message: String) {
        DispatchQueue.main.async {
            let vc = UIActivityViewController(activityItems: [message], applicationActivities: nil)
            guard
                let scene = UIApplication.shared.connectedScenes.first as? UIWindowScene,
                let root = scene.windows.first(where: { $0.isKeyWindow })?.rootViewController
            else { return }

            var top = root
            while let presented = top.presentedViewController { top = presented }
            top.present(vc, animated: true)
        }
    }
}