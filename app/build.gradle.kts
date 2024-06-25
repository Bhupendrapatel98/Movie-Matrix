plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.daggerhilt)
    alias(libs.plugins.google.services)
    alias(libs.plugins.ktlint)
    kotlin("kapt")
}

android {
    namespace = "com.app.moviematrix"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.app.moviematrix"
        minSdk = 24
        targetSdk = 34
        versionCode = 8
        versionName = "8.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        // Build configuration fields for API key
        buildConfigField("String", "API_KEY", "\"${property("API_KEY")}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

// ktlint {
//    android = true
//    debug = true
//    verbose = true
//    outputToConsole = true
//    outputColorName = "RED"
//    ignoreFailures = false
//    enableExperimentalRules = true
//    reporters {
//        reporter(ReporterType.PLAIN)
//        reporter(ReporterType.CHECKSTYLE)
//        reporter(ReporterType.SARIF)
//    }
//    filter {
//        exclude("**/style-violations.kt")
//        exclude("**/generated/**")
//        include("**/kotlin/**")
//    }
// }

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // unit testing
    testImplementation(libs.junit)
    testImplementation(libs.mockito)
    testImplementation(libs.kotlinx.coroutines.test)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // for slider
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    // navigation
    implementation(libs.navigation.compose)
    implementation(libs.navigation.hilt.compose)

    // retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson.converter)
    implementation(libs.interceptor)

    // hilt
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)

    // coil
    implementation(libs.coil.compose)

    // paging3
    implementation(libs.paging.compose)
    implementation (libs.androidx.lifecycle.runtime.compose)
    implementation (libs.androidx.paging.runtime.ktx)

    // gson
    implementation(libs.gson)

    // room
    implementation(libs.room)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)
    implementation(libs.room.paging)

    implementation(libs.firebase.bom)
    implementation(libs.firebase.analytics)
}
