

plugins {
    id ("com.android.application")
   // id ("org.jetbrains.kotlin.android")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")

}

android {
    namespace= ("com.matech.kotlindsl")

    // compileSdk 33
    compileSdk =(33)


    defaultConfig {
        //  applicationId "com.matech.kotlindsl"
        applicationId = "com.matech.kotlindsl"
        //  minSdk 24
        minSdk=(24)
        //  targetSdk 33
        targetSdk=(33)
        // versionCode 1
        versionCode = (1)
        //  versionName "1.0"
        versionName = "1.0"
        testInstrumentationRunner= ("androidx.test.runner.AndroidJUnitRunner")
      /*  val TEST_STRING: String by project
        val testString:String= findProperty("TEST_STRING").toString()*/

        buildTypes.forEach {
            it.buildConfigField("String","TEST_STRING",project.property("TEST_STRING")as String)
        }


    }

    buildTypes {
        //  release
        getByName("release") {
            //  minifyEnabled true
            isMinifyEnabled = false

            //   proguardFiles getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
        }

    }
    compileOptions {
        /*  sourceCompatibility JavaVersion.VERSION_1_8
          targetCompatibility JavaVersion.VERSION_1_8*/
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    /*kotlinOptions {
           jvmTarget = "1.8"
       }*/
    buildFeatures {
        viewBinding = true
    }
    /* tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
           kotlinOptions {
               jvmTarget = "1.8"
           }
       }*/
}

dependencies {
    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }
    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.8.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11")
    implementation("com.google.dagger:hilt-android:2.45")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

    kapt ("com.google.dagger:hilt-android-compiler:2.45")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0-rc01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0-rc01")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
}
kapt {
    correctErrorTypes = true
}
