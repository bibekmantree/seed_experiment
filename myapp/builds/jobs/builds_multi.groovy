    
pipelineJob('myapp_classic_pipeline') {
    logRotator {
        numToKeep(7)
    }
    properties {
        githubProjectUrl('https://github.com/bibekmantree/seed_experiment.git')
    }
    triggers {
        githubPush()
        //scm('H/4 * * * *')
    }
    definition {
        cps {
            script(readFileFromWorkspace('./myapp/builds/pipelines/injob_pipeline.groovy'))
            sandbox()
        }
    }
    
}//end job

job('myapp_freestyle') {
    scm {
        git {
            remote {
                    url('https://github.com/bibekmantree/seed_experiment.git')
                    credentials('github')
             }
        }
    }
    
    wrappers {
        preBuildCleanup()
    }
    steps {
        shell(
            'echo Hello Pipeline'
        )
    }
    }