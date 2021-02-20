object Versions {
    const val navigation = "2.3.3"
    const val material = "1.3.0"
    const val coreVersion = "1.3.2"
    const val hilt = "2.32-alpha"
    const val hiltAndroidx = "1.0.0-alpha03"
    const val appCompat = "1.2.0"
    const val junit = "4.13.2"
    const val junitExt = "1.1.2"
    const val espresso = "3.3.0"
    const val viewBinding = "4.1.2"
    const val retrofit = "2.5.0"
    const val coroutines = "1.4.2"
    const val timber = "4.7.1"
}

object Navigation {
    const val navSafeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navKtx = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"

    // Feature module Support
    const val navDynamicFeature = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
}

object Design {
    const val material = "com.google.android.material:material:${Versions.material}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
}

object Core {
    const val core = "androidx.core:core-ktx:${Versions.coreVersion}"
    const val viewBinding = "androidx.databinding:viewbinding:${Versions.viewBinding}"
}

object Coroutines {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}

object DI {
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltKapt = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hiltAndroidKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltAndroidx}"
}

object Retrofit {
    const val lib = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val rxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
}

val Timber = "com.jakewharton.timber:timber:${Versions.timber}"

object Test {
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

