# BNP Test — Full KMM / KMP Interview Project

This repository is a Kotlin Multiplatform (KMM / KMP).
This is a *full* KMM project where the majority of the code is shared across platforms (not just a subset).
The shared code contains the business logic, data sources and core viewmodel/state logic.

This README explains how to build and run the project, what each module contains, which architecture patterns are used, and what tools/libraries are used.

---

## Prerequisites

- macOS (for iOS builds)
- JDK 11+ (or the JDK version required by the Gradle wrapper)
- Android Studio
- Xcode
- Use the provided Gradle wrapper: `./gradlew`


## Build (all platforms)

From the project root run:

```bash
./gradlew build
```

This compiles common code and platform targets. For a focused build you can target a single module, e.g. `:domain:assemble` or `:composeApp:assemble`.


## Run Android app

1. Open the project in Android Studio and let it sync.
2. Run the `composeApp` module on an emulator/device.


## Run iOS app

This project ships an `iosApp` Xcode project that consumes the Kotlin Multiplatform framework(s) produced by Gradle. Typical steps:

1. Build the KMM frameworks for the iOS target with Gradle. Example:

```bash
# Build frameworks and other artifacts (this builds the KMM frameworks used by Xcode)
./gradlew assemble
# If your project uses XCFramework tasks, you may also have a task like:
# ./gradlew :composeApp:assembleXCFramework
```

2. Open the Xcode project:

- Open `iosApp/iosApp.xcodeproj` (or workspace if present).
- In Xcode select the simulator or a connected device you want to run on.

3. Ensure Xcode finds the KMM frameworks:

- Gradle places the produced frameworks under the module `build/xcode-frameworks/` directories (for example: `composeApp/build/xcode-frameworks/`).
- If Xcode reports a missing framework, run the Gradle assemble task again and confirm the framework files exist under the build directory. Then re-open the Xcode project or update the framework search paths to the generated location.

4. Code signing and devices:

- For simulator runs you normally don't need code signing.
- For running on a physical device, configure a valid signing identity and provisioning profile in Xcode.

5. Run the app:

- Press Run in Xcode (or Product > Run). The app should build and launch on the selected simulator or device.

Troubleshooting tips:

- Missing framework / link errors: ensure you built the frameworks for the correct target (simulator vs device). For device builds Gradle must produce `iosArm64` or XCFramework including device slices; for simulator, build `iosSimulatorArm64` or x64 depending on your machine.
- Apple Silicon Macs (M1/M2): prefer building `iosSimulatorArm64` frameworks for simulator testing on Apple Silicon.
- If you change Kotlin code in `commonMain`, re-run the Gradle assemble step to update the frameworks before re-building in Xcode.


## Project structure (high-level)

- `domain` — business logic (game rules, use-cases)
- `data` — repositories and data sources (includes a memory datasource demonstrating a MutableSharedFlow as in-memory reactive source)
- `composeApp` — UI module written with Compose. Uses MVI on UI side.
- `designSystem` — shared UI theme and components for Compose.
- `iosApp` — Xcode project that consumes the produced KMM framework(s). The iOS app uses the same shared code via the KMM framework.


## Architecture used
- Clean Architecture principles with clear separation of concerns between layers (domain, data, UI).
- Repository pattern for data access abstraction.
- MVI (Model-View-Intent) pattern for UI state management in the Compose app

## Tools used
- Kotlin Multiplatform Mobile (KMM)
- Koin for dependency injection
- MockK for unit test mocking
- Kotlinx Coroutines and Flow for async/reactive programming
- Jetpack Compose for Android UI
- Material 3 Design System


## Left to do

- Add more unit tests to cover all classes and edge cases.
- Add Espresso / UI automation tests for Android.
- Optionally move the TicTacToe feature into a separate feature module for clearer encapsulation.







---
