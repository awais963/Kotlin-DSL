// Top-level build file where you can add configuration options common to all sub-projects/modules.
/*plugins {
    id ("com.android.application") version "7.4.0" apply false
    id ("com.android.library") version "7.4.0" apply false
    id ("org.jetbrains.kotlin.android") version "1.7.21" apply false
}*/
buildscript {
    val kotlinVersion = "1.7.21"
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.4.0")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.43.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}