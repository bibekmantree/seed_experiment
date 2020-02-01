job('dsl_seed_myapp') {
    scm {
        git {
            remote {
                    url('https://github.com/bibekmantree/seed_experiment.git')
            }
        }
    }
    wrappers {
        preBuildCleanup()
    }
    triggers {
        upstream('metarseed', 'UNSTABLE')
    }
    steps {
        dsl {
            external('./myapp/dsl_seed_myapp.groovy')
            removeAction('DELETE')
            removeViewAction('DELETE')
        }
    }
}
