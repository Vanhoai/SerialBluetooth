import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    /// Init Koin Function
    ///
    /// This function call for init app share module in kotlin want to
    /// be use in swift code. This call must in first run application
    ///
    /// @see KoinModulesKt
    init() {
        KoinModulesKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
