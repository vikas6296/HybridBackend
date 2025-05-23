pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK 21'
    }

    parameters {
        choice(name: 'ENV', choices: ['qa', 'stage', 'prod'], description: 'Select environment to run tests')
    }

    environment {
        TEST_ENV = "${params.ENV}"
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/vikas6296/HybridBackend.git', branch: 'master'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

       stage('Run Tests') {
                  steps {
                      echo "Running tests on environment: ${params.ENV}"
                      sh "mvn test -Denv=${params.ENV}"
                  }
              }
    }

   post {
    always {
        echo 'Pipeline execution completed.'

        // Archive JUnit-compatible XMLs (if you still want them)
        junit '**/target/surefire-reports/testng-results.xml'

        // Publish Spark HTML Report
        publishHTML(target: [
            reportDir: 'test-output/Spark',         // ✅ Location of Spark HTML report
            reportFiles: 'index.html',              // ✅ Entry point of the report
            reportName: 'Spark HTML Report',
            keepAll: true,
            allowMissing: false,
            alwaysLinkToLastBuild: true
        ])
    }

    success {
        echo '✅ Build & tests passed!'
        mail to: 'vtest9910@gmail.com,vikas.kumar5@timesinternet.in,vikas.kumar5@joinabound.com',
             subject: "✅ Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
             body: "Build #${env.BUILD_NUMBER} passed.\nCheck: ${env.BUILD_URL}"
    }

    failure {
        echo '❌ Build or tests failed.'
        mail to: 'vtest9910@gmail.com,vikas.kumar5@timesinternet.in,vikas.kumar5@joinabound.com',
             subject: "❌ Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
             body: "Build #${env.BUILD_NUMBER} failed.\nCheck: ${env.BUILD_URL}"
    }

    }
}
