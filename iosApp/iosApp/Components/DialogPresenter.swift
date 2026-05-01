//
//  DialogPresenter.swift
//  iosApp
//
//  Created by KARUN KUMAR on 02/05/26.
//


import UIKit

class DialogPresenter {
    static func show(title: String, message: String, buttonText: String = "OK") {
        // 1. Find the active Window
        guard let windowScene = UIApplication.shared.connectedScenes.first as? UIWindowScene,
              let window = windowScene.windows.first(where: { $0.isKeyWindow }) else { return }

        // 2. Create the Dimmed Background Overlay
        let overlay = UIView(frame: window.bounds)
        overlay.backgroundColor = UIColor.black.withAlphaComponent(0.0) // Start transparent for animation
        overlay.tag = 999 // Tag to identify and remove later
        
        // 3. Create Dialog Container
        let container = UIView()
        container.backgroundColor = .white
        container.layer.cornerRadius = 16
        container.clipsToBounds = true
        container.translatesAutoresizingMaskIntoConstraints = false
        
        // 4. Create UI Elements
        let titleLabel = UILabel()
        titleLabel.text = title
        titleLabel.font = .systemFont(ofSize: 18, weight: .bold)
        titleLabel.textAlignment = .center
        
        let messageLabel = UILabel()
        messageLabel.text = message
        messageLabel.font = .systemFont(ofSize: 15)
        messageLabel.textColor = .darkGray
        messageLabel.numberOfLines = 0
        messageLabel.textAlignment = .center
        
        let actionButton = UIButton(type: .system)
        actionButton.setTitle(buttonText, for: .normal)
        actionButton.titleLabel?.font = .systemFont(ofSize: 16, weight: .semibold)
        actionButton.backgroundColor = .systemBlue
        actionButton.setTitleColor(.white, for: .normal)
        actionButton.layer.cornerRadius = 8
        
        // 5. Build Hierarchy
        let stackView = UIStackView(arrangedSubviews: [titleLabel, messageLabel, actionButton])
        stackView.axis = .vertical
        stackView.spacing = 20
        stackView.translatesAutoresizingMaskIntoConstraints = false
        
        container.addSubview(stackView)
        overlay.addSubview(container)
        window.addSubview(overlay)
        
        // 6. Setup Constraints
        NSLayoutConstraint.activate([
            container.centerXAnchor.constraint(equalTo: overlay.centerXAnchor),
            container.centerYAnchor.constraint(equalTo: overlay.centerYAnchor),
            container.widthAnchor.constraint(equalToConstant: 280),
            
            stackView.topAnchor.constraint(equalTo: container.topAnchor, constant: 24),
            stackView.leadingAnchor.constraint(equalTo: container.leadingAnchor, constant: 20),
            stackView.trailingAnchor.constraint(equalTo: container.trailingAnchor, constant: -20),
            stackView.bottomAnchor.constraint(equalTo: container.bottomAnchor, constant: -20),
            
            actionButton.heightAnchor.constraint(equalToConstant: 44)
        ])
        
        // 7. Button Action (Dismissal)
        let action = UIAction { _ in
            UIView.animate(withDuration: 0.3, animations: {
                overlay.alpha = 0
            }) { _ in
                overlay.removeFromSuperview()
            }
        }
        actionButton.addAction(action, for: .touchUpInside)
        
        // 8. Appearance Animation
        container.transform = CGAffineTransform(scaleX: 0.8, y: 0.8)
        UIView.animate(withDuration: 0.3) {
            overlay.backgroundColor = UIColor.black.withAlphaComponent(0.4)
            container.transform = .identity
        }
    }
}