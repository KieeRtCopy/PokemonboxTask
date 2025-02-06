plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("plugin.serialization") version "2.0.21"
}

android {
    namespace = "com.example.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(mapOf("path" to ":domain")))
    implementation(Libs.androidxCore)
    implementation(Libs.androidxAppCompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)

    testImplementation(Libs.junit)
    androidTestImplementation(Libs.testExtJunit)
    androidTestImplementation(Libs.espressoCore)
    testImplementation(Libs.coroutinesTest)

    implementation(Libs.daggerHiltAndroid)
    kapt(Libs.daggerHiltCompiler)

    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)
    implementation(Libs.navigationDynamicFeaturesFragment)
    androidTestImplementation(Libs.navigationTesting)

    implementation(Libs.kotlinxSerializationJson)

    implementation(Libs.retrofit)
    implementation(Libs.gson)
    implementation(Libs.retrofitConverterGson)
    implementation(Libs.okhttp)
    implementation(Libs.retrofitConverterScalars)
    implementation(Libs.loggingInterceptor)

    implementation(Libs.coil)
}

kapt {
    correctErrorTypes = true
}