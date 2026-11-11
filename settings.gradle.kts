rootProject.name = "IFW Enhance"

include(":module", ":hideapi")

pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
    versionCatalogs {
        create("libs") {
            val magic = "1.9"

            library("magic-library", "com.github.kr328.magic", "library").version(magic)
        }
    }
}
