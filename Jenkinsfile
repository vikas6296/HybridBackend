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
                bat 'mvn clean compile -e -X'
            }
        }

       stage('Run Tests') {
                  steps {
                      echo "Running tests on environment: ${params.ENV}"
                      bat "mvn test -Denv=${params.ENV} -e -X "
                  }
              }
    }

   post {
    always {
        echo 'Pipeline execution completed.'

        // Archive JUnit-compatible XMLs (if you still want them)
        junit 'target/surefire-reports/TEST-*.xml'

        // Publish Spark HTML Report
        publishHTML(target: [
            reportDir: 'test-output/Spark',         // ✅ Location of Spark HTML report
            reportFiles: 'Index.html',              // ✅ Entry point of the report
            reportName: 'Spark HTML Report',
            keepAll: true,
            allowMissing: false,
            alwaysLinkToLastBuild: true
        ])
    }


    success {

    script {


      def rawHtml = readFile('comparison_report.html')

      // Strip outer tags if needed (optional)
      def comparisonReport = rawHtml
          .replaceAll(/(?s)<html>.*?<body>/, '')  // remove <html><head>...<body>
          .replaceAll('</body>\\s*</html>', '')   // remove </body></html>

        echo '✅ Neobank Build & tests passed successfully !'
        mail to: 'vtest9910@gmail.com,vikas.kumar5@timesinternet.in,vikas.kumar5@joinabound.com',
             subject: "✅ Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
             mimeType: 'text/html',
             body: """
                               <p>Build #${env.BUILD_NUMBER} passed.</p>
                               <p>Check: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                               <br/>
                               <h2>Comparison Report</h2>
                               ${comparisonReport}
                            """
    }
    }

    failure {

    script {
              def rawHtml = readFile('comparison_report.html')

                   // Strip outer tags if needed (optional)
                   def comparisonReport = rawHtml
                       .replaceAll(/(?s)<html>.*?<body>/, '')  // remove <html><head>...<body>
                       .replaceAll('</body>\\s*</html>', '')   // remove </body></html>


        echo '❌ Neobank Build or tests failed..........'
        mail to: 'vtest9910@gmail.com,vikas.kumar5@timesinternet.in,vikas.kumar5@joinabound.com',
             subject: "❌ Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
             mimeType: 'text/html',
             body: """
                               <p>Build #${env.BUILD_NUMBER} passed.</p>
                               <p>Check: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                               <br/>
                               <h2>Comparison Report</h2>
                               ${comparisonReport}
                            """
    }

    }

    }
}
