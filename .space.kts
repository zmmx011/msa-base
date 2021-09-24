/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Build and push Docker") {
    container(displayName = "Run gradle build", image = "openjdk") {
        shellScript {
            content = """
                    ./gradlew bootBuildImage --imageName=invenia.registry.jetbrains.space/p/sso/containers/config-server
                """
        }
    }
    docker {
        build {

        }
        push("invenia.registry.jetbrains.space/p/sso/containers/config-server") {
            tags("0.\$JB_SPACE_EXECUTION_NUMBER", "lts")
        }
    }
}
