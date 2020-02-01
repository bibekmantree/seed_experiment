pipeline {
    agent any
    stages {
        stage('initial_step') {
            steps {
                sh 'ls -al'
             }
        }
    }

}
