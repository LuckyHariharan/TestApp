// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val hiltVersion = "2.38.1"
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
        // Other classpath dependencies
    }
}

plugins {
    id("com.android.application") version "7.3.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

// Add other configurations if needed
