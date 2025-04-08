pipeline 
{
    agent any

    triggers 
    {
        githubPush()
    }

    tools 
    {
        maven 'Maven'
    }

    environment 
    {
        TEST_TAG = "@smoke"
    }

    stages 
    {
        stage('Checkout Repository') 
        {
            steps 
            {
                git branch: 'main', url: 'https://github.com/Yildirim61Likos/PlayWrightAutomation'
            }
        }

        stage('Run Playwright Tests') 
        {
            steps 
            {
                script 
                {
                    try 
                    {
                        if (isUnix()) 
                        {
                            sh 'mvn clean test -Dcucumber.filter.tags=${TEST_TAG}'
                        } else 
                        {
                            bat "mvn clean test -Dcucumber.filter.tags=${env.TEST_TAG}"
                        }
                    } catch (e) 
                    {
                        currentBuild.result = 'FAILURE'
                        throw e
                    }
                }
            }
        }

        stage('Publish Test Results') 
        {
            steps 
            {
                junit '**/target/surefire-reports/TEST-*.xml'
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            }
        }

        stage('Publish Cucumber HTML Report') 
        {
            steps 
            {
                publishHTML([
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-html-reports',
                    reportFiles: 'overview-features.html',
                    reportName: 'Cucumber Report'
                ])
            }
        }
    }

    post 
    {
        always 
        {
            cleanWs()
        }
    }
}
