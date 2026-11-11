import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension

plugins {
    val agp = "8.1.2"
    val zygote = "3.1"

    id("com.android.library") version agp apply false
    id("com.android.application") version agp apply false
    id("com.github.kr328.gradle.zygote") version zygote apply false
}

subprojects {
    plugins.withId("com.android.base") {
        extensions.configure<BaseExtension> {
            val isApp = this is AppExtension

            compileSdkVersion(34)

            defaultConfig {
                if (isApp) {
                    applicationId = "com.github.kr328.ifw"
                }

                minSdk = 26
                targetSdk = 34

                versionName = "v22TIW-20251111"
                versionCode = 22011

                if (!isApp) {
                    consumerProguardFiles("consumer-rules.pro")
                }
            }

            buildTypes {
                named("release") {
                    isMinifyEnabled = isApp
                    isShrinkResources = isApp
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }
    }
}

task("clean", type = Delete::class) {
    delete(layout.buildDirectory)
}
