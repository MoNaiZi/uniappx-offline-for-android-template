import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.guodong.uniappx.offline"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.guodong.uniappx.offline"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "UTSRegisterComponents", "\"[{\\\"name\\\":\\\"video\\\",\\\"class\\\":\\\"uts.sdk.modules.DCloudUniVideo.VideoComponent\\\"}]\"")

        // 💡 显式指定 uni-app 推荐的主流 CPU 架构，防止其他不完整的 SDK 导致打包失败
        ndk {
            abiFilters.addAll(setOf("armeabi-v7a", "arm64-v8a"))
        }

        // ➕ 核心修复：在这里显式注入个推/个验所需的所有占位符参数
        // 如果你不打算用推送，直接留着下面的 "123456" 即可骗过编译器顺利通过编译。
        manifestPlaceholders.putAll(
            mapOf(
                "GETUI_APPID"        to "123456",
                "PUSH_APPID"         to "123456",
                "GY_APP_ID"          to "123456",
                "GETUI_APPKEY"       to "123456",
                "GETUI_APPSECRET"    to "123456",
                "GT_INSTALL_CHANNEL" to "io.dcloud" // 个推渠道占位符
            )
        )
    }

    buildFeatures {
        buildConfig = true
    }

    // 💡 解决 SO 库同名冲突问题
    packaging {
        jniLibs {
            pickFirsts.add("**/*.so")
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"

            // 💡 如果想在日常 Debug 调试时彻底消除最开始那个 D8 警告，可以取消下面三行的注释
            // isMinifyEnabled = true
            // proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        release {
            // 💡 将其改为 true 开启混淆，这样线上打包时 proguard-rules.pro 里的规则才会真正生效
            isMinifyEnabled = true
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

    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_1_8
        }
    }

    aaptOptions {
        additionalParameters += "--auto-add-overlay"
        ignoreAssetsPattern = "!.svn:!.git:.*:!CVS:!thumbs.db:!picasa.ini:!*.scc:*~"
    }

    androidResources {
        additionalParameters += "--auto-add-overlay"
        ignoreAssetsPattern = "!.svn:!.git:.*:!CVS:!thumbs.db:!picasa.ini:!*.scc:*~"
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(fileTree(mapOf("include" to listOf("*.aar", "*.jar"), "dir" to "../libs")))
    implementation(project(":uniappx"))
    implementation(project(":scan"))
    implementation(project(":ysapi"))
    implementation(project(":x-qrcode"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
