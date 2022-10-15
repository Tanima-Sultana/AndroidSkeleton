import AppDependencies.kaptTestLibraries

val kotlin_version: String by extra
plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin ("android")
    kotlin ("android.extensions")
    kotlin("kapt")
}
apply {
    plugin("kotlin-android")
}
//id 'org.jetbrains.kotlin.android'


android {
    //compileSdk 32
    compileSdkVersion(32)
    buildToolsVersion("30.0.3")



    defaultConfig {
        applicationId = "com.example.androidskeleton"
        //minSdk 21
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        //targetSdk 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        testInstrumentationRunner = AppConfig.androidTestInstrumentation

//        org.jetbrains.kotlin.kapt3.base.Kapt.kapt {
//            org.jetbrains.kotlin.kapt3.base.Kapt.kapt.correctErrorTypes = true
//        }

        kapt {
            correctErrorTypes = true
        }

    }

//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

//        getByName("debug") {
//            isMinifyEnabled = false
//        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding {
        android.buildFeatures.viewBinding = true
    }

    buildFeatures {
        dataBinding = true
    }


    flavorDimensions("environment")

}

dependencies {


    //std lib
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //app libs
    implementation(AppDependencies.appLibraries)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")

    //implementation("androidx.appcompat:appcompat:1.4.1")
    //implementation("com.google.android.material:material:1.6.0")
    //implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    //implementation("com.android.support:preference-v7:27.1.1")
    //test libs
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
    kapt(AppDependencies.kaptLibraries)
    kaptTest(kaptTestLibraries)
    kaptTestAndroid(AppDependencies.kaptAndroidTestLibraries)


//    implementation ("androidx.core:core-ktx:1.7.0")
//    implementation ("androidx.appcompat:appcompat:1.4.1")
//    implementation ("com.google.android.material:material:1.6.0")
//    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
//    testImplementation ("junit:junit:4.13.2")
//    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
//    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
 //   implementation("androidx.core:core-ktx:+")
//    implementation(kotlinModule("stdlib-jdk7", kotlin_version))
}
repositories {
    mavenCentral()
}