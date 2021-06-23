pipeline {
    agent any
    tools {
        maven 'maven361'
        jdk 'jdk11'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    extensions: [[$class: 'CleanCheckout']],
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: 'github-credentials', url: 'https://github.com/PJATK-Database-department/testautomation-rest.git']]
                ])
            }
        }
        stage ('Build & Run') {
            steps {

                echo 'Building test framework'
                sh 'mvn clean install -Dmaven.test.skip=true'
                sh 'mvn test'
            }
        }
        stage ('Publish report') {
            steps {

                echo 'Publishing report'
                cucumber '**/Cucumber.json'
            }
        }
    }
}