plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.sam.friendlens"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.sam.friendlens"
        minSdk = 28
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        viewBinding = true
    }
    sourceSets {
        getByName("main") {
            res {
                srcDirs(
                    "src\\main\\res",
                    "src\\main\\java\\com\\sam\\friendlens\\ui\\welcome\\res",
                    "src\\main\\res",
                    "src\\main\\java\\sam\\friendlens\\ui\\dashboard",
                    "src\\main\\res",
                    "src\\main\\java\\com\\sam\\friendlens\\ui\\dashboard\\res",
                    "src\\main\\res",
                    "src\\main\\java\\sam\\com\\friendlens\\ui\\dashboard\\home\\res",
                    "src\\main\\res",
                    "src\\main\\java\\com\\sam\\friendlens\\ui\\dashboard\\home\\res",
                    "src\\main\\res",
                    "src\\main\\java\\sam\\com\\friendlens\\ui\\dashboard\\profile\\res",
                    "src\\main\\res",
                    "src\\main\\java\\sam\\com\\friendlens\\ui\\dashboard\\activity\\res",
                    "src\\main\\res",
                    "src\\main\\java\\com\\sam\\friendlens\\ui\\dashboard\\profile\\res",
                    "src\\main\\res",
                    "src\\main\\java\\com\\sam\\friendlens\\ui\\dashboard\\activity\\res",
                    "src\\main\\res",
                    "src\\main\\java\\com\\sam\\friendlens\\ui\\dashboard\\search\\res",
                    "src\\main\\res",
                    "src\\main\\java\\com\\sam\\friendlens\\ui\\dashboard\\add_new\\res",
                    "src\\main\\res",
                    "src\\main\\java\\com\\sam\\friendlens\\ui\\dashboard\\new_feed\\res"
                )
            }
        }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.legacy.support.v4)
    implementation(libs.recyclerview)
    implementation(libs.annotation)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.fragment)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.shimmer)
    implementation(platform(libs.firebase.bom))
    implementation(libs.google.firebase.auth)
    implementation(libs.credentials.v130)
    implementation(libs.credentials.play.services.auth.v130)
    implementation(libs.googleid.v111)
    implementation(libs.firebase.firestore)
    // Camera
    implementation(libs.camera.core)
    implementation(libs.camera.camera2)
    implementation(libs.camera.lifecycle)
    implementation(libs.camera.view)
    implementation(libs.camera.video)
    implementation(libs.guava)

    implementation(libs.glide)
    annotationProcessor(libs.compiler)
}