//
// Created by KARUN KUMAR on 04/05/26.
//

import Foundation
import Shared

public extension ToastSdk {
    func setup() {
        setup(bridge: IOSBridgeImpl())
    }
}
