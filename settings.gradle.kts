pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//    }
//}
//rootProject.name = "AndroidSkeleton"
//include ':app'

rootProject.name = "AndroidSkeleton"
include (":repository", ":core",":app")
