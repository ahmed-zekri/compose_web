// Add compose gradle plugin
plugins {
    kotlin("multiplatform") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.0"
}

// Add maven repositories
repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

// Enable JS(IR) target and add dependencies
kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)
            }
        }
    }
}
// Fixes webpack-cli incompatibility by pinning the newest version.
rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
    versions.webpackCli.version = "4.10.0"
}
tasks.register("stage") {

    dependsOn("build")
    doLast {
        exec {

            executable("kotlinNpmCachesSetup")

        }
        exec {

            executable("jsPackageJson")

        }
        exec {

            executable("kotlinNodeJsSetup")

        }
        exec {

            executable("kotlinRestoreYarnLock")

        }

        exec {

            executable("jsTestPackageJson")

        }
        exec {

            executable("packageJsonUmbrella")

        }
        exec {

            executable("rootPackageJson")

        }
        exec {

            executable("kotlinNpmInstall")

        }

        exec {

            executable("jsGenerateExternalsIntegrated")

        }
        exec {

            executable("kotlinStoreYarnLock")

        }



        exec {

            executable("compileKotlinJs")

        }



        exec {

            executable("jsProcessResources")

        }




        exec {

            executable("jsMainClasses")

        }


        exec {

            executable("compileDevelopmentExecutableKotlinJs")

        }


        exec {

            executable("jsDevelopmentExecutableCompileSync")

        }


        exec {

            executable("jsBrowserDevelopmentRun")

        }



        println("Executed!")
    }
}
