import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    compileSdkVersion(30)

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.production.pings"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            setProguardFiles(listOf(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(platform("com.google.firebase:firebase-bom:26.5.0"))
    implementation(project(":framework"))
    implementation(project(":navigation"))
    implementation(project(":commonui"))
    implementation(project(":settings"))
    implementation(project(":overview"))
    implementation(project(":alarmsetup"))

    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation(kotlin("stdlib", KotlinCompilerVersion.VERSION))
    implementation(Core.core)
    implementation(Design.appCompat)
    implementation(Design.material)
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation(Timber)
    implementation(DI.hilt)
    testImplementation(Test.junit)
    androidTestImplementation(Test.junitExt)
    androidTestImplementation(Test.espresso)

    kapt(DI.hiltKapt)
}