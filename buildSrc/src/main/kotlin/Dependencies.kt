object Versions {
    // Versioni principali
    const val androidxCore = "1.9.0"
    const val androidxAppCompat = "1.7.0"
    const val material = "1.11.0"
    const val constraintLayout = "2.1.4"

    // Navigation
    const val navigation = "2.8.6"

    // Testing
    const val junit = "4.13.2"
    const val testExtJunit = "1.2.1"
    const val espressoCore = "3.6.1"
    const val coroutinesTest = "1.3.2"

    // Dagger-Hilt
    const val daggerHilt = "2.51.1"

    // Kotlin Serialization
    const val kotlinxSerializationJson = "1.7.3"

    // Retrofit e OkHttp
    const val retrofit = "2.11.0"
    const val gson = "2.11.0"
    const val retrofitConverterGson = "2.7.2"
    const val okhttp = "4.9.3"
    const val retrofitConverterScalars = "2.7.2"
    const val loggingInterceptor = "4.9.3"

    // Coil
    const val coil = "2.6.0"
}

object Libs {
    // Core & AppCompat
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"

    // Material & ConstraintLayout
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // Navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigation}"
    const val navigationDynamicFeaturesFragment = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
    const val navigationTesting = "androidx.navigation:navigation-testing:${Versions.navigation}"

    // Testing dependencies
    const val junit = "junit:junit:${Versions.junit}"
    const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"

    // Dagger Hilt
    const val daggerHiltAndroid = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"

    // Kotlin Serialization
    const val kotlinxSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerializationJson}"

    // Retrofit & OkHttp
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitConverterGson}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val retrofitConverterScalars = "com.squareup.retrofit2:converter-scalars:${Versions.retrofitConverterScalars}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    // Coil
    const val coil = "io.coil-kt:coil:${Versions.coil}"
}