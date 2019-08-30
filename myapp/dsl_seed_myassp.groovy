job('dsl_seed_myapp_builds') {
    scm {
        git {
            remote {
                    url('https://github.com/bibekmantree/seed_experiment.git')
                    credentials('github')
             }
        }
    }
    triggers {
        upstream('dsl_seed_myapp', 'UNSTABLE')
    }
    wrappers {
        preBuildCleanup()
    }
    steps {
        dsl {
            external('./myapp/builds/builds_*.groovy')
            removeAction('DELETE')
            removeViewAction('DELETE')
        }
    }
}