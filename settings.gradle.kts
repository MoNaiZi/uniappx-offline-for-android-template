pluginManagement {
    repositories {
        // 阿里云镜像（Kotlin DSL 用双引号）
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/central")
        maven("https://maven.aliyun.com/repository/gradle-plugin")

        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/public")

        google()
        mavenCentral()

        // uni-app x 必须保留 jitpack
        maven("https://jitpack.io")

        flatDir {
            dirs("./plugins/")
        }
    }
}

rootProject.name = "方鼎医疗平板终端"
include(":app")
include(":uniappx")
include(":kux-request")
include(":scan")
include(":ysapi")
