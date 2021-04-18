pipeline {

   //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Mac'
  }

    //Opciones específicas de Pipeline dentro del Pipeline
    options {
      	buildDiscarder(logRotator(numToKeepStr: '3'))
   	disableConcurrentBuilds()
    }

     //Una sección que define las herramientas “preinstaladas” en Jenkins
      tools {
        jdk 'JDK8_Mac' //Preinstalada en la Configuración del Master
      }

   //Aquí comienzan los “items” del Pipeline
  stages{

	stage('Build') {
      steps{
        echo "------------>Build<------------"
        //Construir sin tarea test que se ejecutó previamente
      	sh './gradlew build -x test'
      }
    }

    stage('Unit Tests') {
      steps{
        echo "------------>>Clean<------------"
        sh './gradlew clean'

        echo "------------>Unit Tests<------------"
        sh './gradlew  test'
      }
    }

    stage('Static Code Analysis') {
	    steps{
				echo "------------>Static Code Analysis<------------"
		withSonarQubeEnv('Sonar'){
		    sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
		}
	    }
	}
  }

   post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
	        junit 'dominio/build/test-results/testDebugUnitTest/*.xml'
	        junit 'infraestructura/build/test-results/testDebugUnitTest/*.xml'

        }
        failure {
            echo 'This will run only if failed'
            mail(to: 'daniel.ibarra@ceiba.com.co',
                subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                body: "Something is wrong with ${env.BUILD_URL}")
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}
