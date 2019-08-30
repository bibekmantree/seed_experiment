job('dsl_seed_project') {
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
}