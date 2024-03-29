// Top-level build file where you can add configuration options common to all sub-projects/modules.
//plugins {
//    id 'com.android.application' version '7.2.1' apply false
//    id 'com.android.library' version '7.2.1' apply false
//    id 'org.jetbrains.kotlin.android' version '1.6.21' apply false
//}

buildscript {
    repositories {

        google()
        mavenCentral()
        //maven { url "https://jitpack.io" }
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:4.1.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.nav_version}")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt_version}")
    }
}

//task clean(type: Delete) {
//    delete rootProject.buildDir
//}

tasks.register(name = "type", type = Delete::class){
    delete(rootProject.buildDir)
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}