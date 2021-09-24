/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Build and push Docker") {
    container(displayName = "Run gradle build", image = "openjdk") {
        shellScript {
            content = """
                    ./gradlew build
                    cp -r config-server/build $mountDir/share
                    ls $mountDir/share
                """
        }
    }
    docker {
        resources {
            cpu = 1.cpu
            memory = 2000.mb
        }
        beforeBuildScript {
            content = "cp -r  $mountDir/share docker"
        }
        build {
            context = "docker"
            file = "./docker/Dockerfile"
        }
        push("invenia.registry.jetbrains.space/p/sso/containers/config-server") {
            tags("0.\$JB_SPACE_EXECUTION_NUMBER", "lts")
        }
    }
}
