pipeline {
    agent any

    tools {
        maven 'maven'
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
                    if (!fileExists("pom.xml")) {
                        sh "git clone https://github.com/ghaikanav/jenkins-test.git"
                    } else {
                        echo "Already exist"
                    }
                }
//                 dir("${path_}") {
                    sh "git pull origin main"
		    echo "repo pulled"
                    sh "mvn -Dmaven.test.skip=true clean install"
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
