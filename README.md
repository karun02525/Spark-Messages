### Summary of the "Clean" Architecture:
* **iOS**: Uses a single `initialize(bridge:)` call that handles both the `NativeBridge` assignment and the Koin startup internally.
* **Android**: Uses `start(this)` in the `Application` class, which correctly provides the `androidContext` to Koin, preventing the `NoDefinitionFoundException` you encountered.
* **Shared**: The logic is hidden inside the `actual object ToastSdk`, meaning the client-side developers don't need to worry about the internal global variables or Koin configuration.