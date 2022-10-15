import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
    private val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val theme = "com.google.android.material:material:1.6.0"

    const val hiltAndroid= "com.google.dagger:hilt-android:2.37"
    // kapt 'com.google.dagger:hilt-compiler:2.37'
    const val hiltkapt = "com.google.dagger:hilt-compiler:2.37"

    // For instrumentation tests
    //  kaptAndroidTest 'com.google.dagger:hilt-compiler:2.37'
    const val hiltkaptAndroidTest = "com.google.dagger:hilt-compiler:2.37"


    // For local unit tests
    // kaptTest 'com.google.dagger:hilt-compiler:2.37'
    const val kaptTest = "com.google.dagger:hilt-compiler:2.37"

    ///room

    const val room = "androidx.room:room-ktx:${Versions.room_version}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room_version}"
    const val kaptRoom = "androidx.room:room-compiler:${Versions.room_version}"


    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    private val hiltTest=  "com.google.dagger:hilt-android-testing:2.37"



    // navigation components
    const val navFragment = "androidx.navigation:navigation-fragment:${Versions.nav_version}"
    const val navUi = "androidx.navigation:navigation-ui:${Versions.nav_version}"
    const val navKotlin = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    const val navUIKotlin = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"

    const val viewBinding = "androidx.databinding:viewbinding:7.2.1"


    //retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    const val gson =  "com.squareup.retrofit2:converter-gson:2.9.0"


    //dagger

    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
    const val circleImage = "de.hdodenhof:circleimageview:3.1.0"
    //rx java
    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:2.1.1"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(theme)
        add(hiltAndroid)
        add(room)
        add(roomRuntime)
        add(navFragment)
        add(navUi)
        add(navKotlin)
        add(navUIKotlin)
        add(retrofit)
        add(gson)
        add(viewBinding)
        add(dagger)
        add(daggerAndroid)
        add(daggerAndroidSupport)
        add(circleImage)
        add(rxkotlin)
        add(rxandroid)
    }

    val kaptLibraries = arrayListOf<String>().apply {
         add(hiltkapt)
         add(kaptRoom)
        add(daggerAndroidProcessor)
        add(daggerCompiler)
    }

    val kaptTestLibraries = arrayListOf<String>().apply {
        add(kaptTest)
    }

    val kaptAndroidTestLibraries = arrayListOf<String>().apply {
         add(hiltkaptAndroidTest)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
        add(hiltTest)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.kaptTest(list: List<String>) {
    list.forEach { dependency ->
        add("kaptTest", dependency)
    }
}

fun DependencyHandler.kaptTestAndroid(list: List<String>) {
    list.forEach { dependency ->
        add("kaptAndroidTest", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}