pipeline {
    agent any
    stages {
        stage('Clean Up'){
          steps{
            step([$class: 'WsCleanup'])
          }
        }
        stage('SCM') {
            steps { 
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'PathRestriction', excludedRegions: '', includedRegions: '''myapp/.*
                ''']], submoduleCfg: [], userRemoteConfigs: [[ url: 'https://github.com/bibekmantree/delete_dsl_mono.git']]])
            }
        }//end SCM
        
         //stage ('Cleanup') {
           // steps {
             //   step([$class: 'WsCleanup']) 
            //}
        //}
    }

}
