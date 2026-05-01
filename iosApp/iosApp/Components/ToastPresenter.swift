//
//  ToastPresenter.swift
//  iosApp
//
//  Created by KARUN KUMAR on 02/05/26.
//

import UIKit


class ToastPresenter {
    static func show(message: String, seconds: Double = 2.0) {
        // 1. Find the active Window
        guard let windowScene = UIApplication.shared.connectedScenes.first as? UIWindowScene,
              let window = windowScene.windows.first(where: { $0.isKeyWindow }) else { return }

        // 2. Create the label
        let toastLabel = UILabel()
        toastLabel.backgroundColor = UIColor.black.withAlphaComponent(0.8)
        toastLabel.textColor = .white
        toastLabel.font = .systemFont(ofSize: 14, weight: .medium)
        toastLabel.textAlignment = .center
        toastLabel.text = message
        toastLabel.alpha = 0.0
        toastLabel.layer.cornerRadius = 20
        toastLabel.clipsToBounds = true
        
        // 3. Size and Position (Relative to the Window)
        let maxSize = CGSize(width: window.frame.size.width - 40, height: 40)
        let expectedSize = toastLabel.sizeThatFits(maxSize)
        toastLabel.frame = CGRect(
            x: window.frame.size.width/2 - (expectedSize.width + 20)/2,
            y: window.frame.size.height - 100, // Bottom padding
            width: expectedSize.width + 20,
            height: 40
        )
        
        window.addSubview(toastLabel)
        
        // 4. Animation
        UIView.animate(withDuration: 0.5, animations: {
            toastLabel.alpha = 1.0
        }) { _ in
            UIView.animate(withDuration: 0.5, delay: seconds, options: .curveEaseOut, animations: {
                toastLabel.alpha = 0.0
            }, completion: { _ in
                toastLabel.removeFromSuperview()
            })
        }
    }
}
