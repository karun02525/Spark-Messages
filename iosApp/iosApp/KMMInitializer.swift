//
//  KMMInitializer.swift
//  iosApp
//
//  Created by KARUN KUMAR on 02/05/26.
//


import Shared
import UIKit

final class KMMInitializer {
    static let shared = KMMInitializer()
    
    private init() {}

    func start() {
        let toastManager = IOSToastManager()

        // Handle the callback logic here
        toastManager.onShowToast = { message in
            DispatchQueue.main.async {
                ToastPresenter.show(message: message)
            }
        }

        toastManager.onShowDialog = { title, message, buttonText  in
            DispatchQueue.main.async {
                DialogPresenter.show(title: title, message: message, buttonText: buttonText)
            }
        }
    

        // Initialize the KMM Shared module
        KmmUtils.shared.doInit(manager: toastManager)
    }
}
