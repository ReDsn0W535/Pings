// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlinVersion = "1.4.30"
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.0-beta04")
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath("com.google.gms:google-services:4.3.5")
        classpath(Navigation.navSafeArgsPlugin)
        classpath(DI.hiltPlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.buildDir)
 }