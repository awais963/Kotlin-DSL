plugins {
    id ("com.android.application")
    //  id ("org.jetbrains.kotlin.android")
    kotlin("android")

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

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.8.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
}
