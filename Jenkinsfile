node {
    
    def mvnHome = tool 'maven-3.6.1'

    // holds reference to docker image
    def dockerImage
    // ip address of the docker private repository(nexus)
    
    def dockerRepoUrl = "localhost:8082"
    def dockerImageName = "yata"
      
    stage('Clone Repo') { // for display purposes
        
        git ' https://github.com/thiagotgo90/yata.git'
        mvnHome = tool 'maven-3.6.1'
    }    

    stage('Build Project') {
      // build project via maven
        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
    }
	
	stage('Build Docker Image') {
    //build docker image
    //sh "mv ./target/hello*.jar ./data" 

    docker.withRegistry("http://localhost:8082", 'local-registry-credential') {
            
      dockerImage = docker.build("${dockerImageName}:${env.BUILD_NUMBER}")
      dockerImage.push()
    }
  }

}