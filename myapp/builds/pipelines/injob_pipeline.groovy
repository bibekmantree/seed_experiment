pipeline {
    agent any
    stages {
        stage('initial_step') {
            steps {
                sh 'ls -al'
             }
        }

        stage('Set Terraform path') {
            steps {
                script {
                    def tfHome = tool name: 'Terraform'
                    env.PATH = "${tfHome}:${env.PATH}"
                }
                sh 'terraform --version'
            }
        }

        stage('terraform init') {
           steps {

               sh 'terraform init '
           }
        }
        /*
        stage('terraform plan') {
           steps {

               sh 'terraform plan '
           }
        }
        */
    }

}