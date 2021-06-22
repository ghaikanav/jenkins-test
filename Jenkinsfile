pipeline {
    agent any

    tools {
        maven 'Default'
    }

    // parameters {
    //     string(name: "CredentialsID", defaultValue: '', description: "Bitbucket credential ID set up in Jenkins")
    // }

//     environment { 
//         //BitBucketUser = credentials("${CredentialsID}")  
//         path_ = "training/my-app"
//     }

    stages {

        stage('Install') {
            steps {
                echo "------------- Install maven dependencies and build jar -------------"
                 
		    script {
                        git https://github.com/ghaikanav/jenkins-test.git
                }
//                 dir("${path_}") {
		    sh "cd jenkins-test"
                    sh "git pull origin main"
                    sh "mvn -Dmaven.test.failure.ignore=true clean install"
//                 }
            }
        }

        stage('Build') {
            steps {
                echo "------------- Build Docker image -------------"
//                 dir("${path_}") {
                    // Build Maven docker image and container.
                    sh "docker image build -t jenkins-team-2 ."
//                 }
            }

        }

        stage('Run') {
            steps {
                echo "------------- Run Docker container -------------"
//                 dir("${path_}") {
                    // Run maven docker container
                    sh "docker run -d jenkins-team-2:latest"
//                 }
            }

        }
    }

    post {
        failure {
		    echo "Application failed *****" 
        }
    }    

}
