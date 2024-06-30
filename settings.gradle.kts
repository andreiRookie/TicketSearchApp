pluginManagement {
    repositories {
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
        google()
        mavenCentral()
    }
}

rootProject.name = "TicketSearch"
include(":app")
include(":core")
include(":core:api")
include(":core:impl")
include(":activity")
include(":core:bridge")
include(":uikit")
include(":navigation")
include(":feat-search")
include(":feat-search:impl")
include(":feat-hotels")
include(":feat-shorter-way")
include(":feat-subscriptions")
include(":feat-profile")
include(":base-cyrillic-validation")
include(":base-decimal-formatter")
