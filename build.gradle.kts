// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  id("org.jetbrains.kotlin.android") version "1.7.21" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false

    /*  id ("com.android.application") version "7.4.0" apply false
       id ("com.android.library") version "7.4.0" apply false
       id ("org.jetbrains.kotlin.android") version "1.7.21" apply false*/

}
buildscript {
    val kotlinVersion = "1.7.21"
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.4.0")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.google.gms:google-services:4.3.10")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.8.1")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
        maven (url  = uri("https://maven.google.com"))
        maven ( url  = uri("https://jitpack.io") )
    }
}
tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}