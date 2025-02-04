import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2024.03"

project {

    buildType(Buld1)
}

object Buld1 : BuildType({
    name = "Buld1"

    params {
        password("pass", "credentialsJSON:36d362dc-4561-43f8-8839-c19e1b199977")
        password("pass2", "credentialsJSON:88c3cc3b-d925-47ee-a09a-d408f5d82d87")
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = """
                echo %pass%
                echo %pass2%
            """.trimIndent()
        }
    }
})
