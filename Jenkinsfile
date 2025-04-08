node {
    def mvnHome

    stage('Preparation') {
        // Clone the Playwright Java project
        git branch: 'main', url: 'https://github.com/Yildirim61Likos/PlayWrightAutomation'

        // Use Maven tool configured in Jenkins global tools (name it 'Maven' there)
        mvnHome = tool 'Maven'
    }

    stage('Run Tests') {
        // Run Playwright+Cucumber tests using Maven
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" clean test -Dcucumber.filter.tags="@smoke"'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" clean test -Dcucumber.filter.tags="@smoke"/)
            }
        }
    }

    stage('Publish Test Results') {
        // Publish test results from Surefire
        junit '**/target/surefire-reports/TEST-*.xml'
        
        // Optionally archive test artifacts like logs, jars, or screenshots
        archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
    }

    stage('Publish Cucumber HTML Report') {
        // If you're generating HTML Cucumber reports
        publishHTML([
            allowMissing: true,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'target/cucumber-html-reports',
            reportFiles: 'overview-features.html',
            reportName: 'Cucumber Report'
        ])
    }

    stage('Cleanup') {
        cleanWs()
    }
}