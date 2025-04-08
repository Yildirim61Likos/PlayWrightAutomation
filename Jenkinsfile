node 
{
    def mvnHome

    // Optional: use triggers in a declarative pipeline only
    // triggers {
    //     githubPush()
    // }

    stage('Checkout Repository') 
    {
        echo 'Cloning Playwright Java project...'
        git branch: 'main', url: 'https://github.com/Yildirim61Likos/PlayWrightAutomation'
        mvnHome = tool 'Maven' // Make sure "Maven" is defined in Global Tools
    }

    stage('Run Playwright Tests') 
    {
        echo 'Running Playwright + Cucumber tests...'
        def testTag = "@smoke" // Change this if needed or pass as parameter

        withEnv(["MVN_HOME=$mvnHome"]) 
        {
            try 
            {
                if (isUnix()) 
                {
                    sh "\"$MVN_HOME/bin/mvn\" clean test -Dcucumber.filter.tags=${testTag}"
                } else 
                {
                    bat(/"%MVN_HOME%\bin\mvn" clean test -Dcucumber.filter.tags=${testTag}/)
                }
            } catch (e) 
            {
                echo "Test execution failed: ${e.getMessage()}"
                currentBuild.result = 'FAILURE'
                throw e
            }
        }
    }

    stage('Publish Test Results') 
    {
        echo 'Publishing test reports...'
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
    }

    stage('Publish Cucumber HTML Report') 
    {
        echo 'Publishing Cucumber HTML Report...'
        publishHTML([
            allowMissing: true,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'target/cucumber-html-reports',
            reportFiles: 'overview-features.html',
            reportName: 'Cucumber Report'
        ])
    }

    stage('Cleanup Workspace') 
    {
        echo 'Cleaning up workspace...'
        cleanWs()
    }
    
    
    
}