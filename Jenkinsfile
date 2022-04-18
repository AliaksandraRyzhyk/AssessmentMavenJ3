pipeline {
    agent any

    parameters {
        booleanParam(defaultValue: true, description: 'run auth test', name: 'auth')
        booleanParam(defaultValue: false, description: 'run promo test', name: 'promo')
    }

    stages {
        stage('auth test') {
            when {
                expression { return params.auth }
            }
            steps {
                sh "mvn -Dtest=auth.** verify"
            }
        }
        stage('promo test') {
             when {
                 expression { return params.promo }
             }
             steps {
                  script{
                    sh "mvn -Dtest=promo.** verify"
                  }
             }
        }
    }
    post {
        always {
            allure([
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
            ])
        }
    }
}
