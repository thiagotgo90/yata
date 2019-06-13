pipeline {

    agent any

    parameters {
      string (name: 'dockerRepoUrl', defaultValue: 'localhost:8082', description: 'Repo URL')
    }

    stages {

      stage('Clone Repo') { 

        steps {
          git ' https://github.com/thiagotgo90/yata.git'
        }        
      }    

      stage('Build Project') {

        steps {
          
          script {
            def mvnHome = tool 'maven-3.6.1'
            sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
          }
        }
      }
    
      stage('Build Docker Image') {
        
        steps {
          
          script {

              def dockerImageName = "yata"
          
              docker.withRegistry("http://${params.dockerRepoUrl}", 'local-registry-credential') {
                dockerImage = docker.build("${dockerImageName}:${env.BUILD_NUMBER}")
                dockerImage.push()
            }
          }
      }
    }
  }
}