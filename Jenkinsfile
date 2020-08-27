pipeline{
    agent any
    stages {
        stage('build') {
           withMaven(maven : 'apache-maven-3.6.1') {
               bat'mvn version'
            }
        }
    }
}