plugins {
    id ("com.android.application")
    //  id ("org.jetbrains.kotlin.android")
    kotlin("android")
    kotlin("kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")

    //  id("dagger.hilt.android.plugin")

}
/*apply{
  //  plugin("androidx.navigation.safeargs")
}*/

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
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()

    }
    /*kotlinOptions {
           jvmTarget = "1.8"
       }*/
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {

    implementation ("androidx.core:core-ktx:1.9.0")
   implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.8.0")
    
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation("com.github.bumptech.glide:glide:4.14.2")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11")
    // Import the BoM for the Firebase platform
    implementation ("com.google.firebase:firebase-bom:31.2.2")
    implementation("com.google.firebase:firebase-crashlytics-ktx:18.3.5")
    implementation("com.google.firebase:firebase-analytics-ktx:21.2.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.14.2")
    //  implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.6.0-alpha05")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")


}
kapt {
    correctErrorTypes = true
}
