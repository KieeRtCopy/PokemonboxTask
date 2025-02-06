plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("plugin.serialization") version "2.0.21"
}

android {
    namespace = "com.example.pokemonbox"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.pokemonbox"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":pokemonList"))
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