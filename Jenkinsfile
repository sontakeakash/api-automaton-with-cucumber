pipeline 
  { 
    agent any 
    stages 
      { 
        stage('Build') 
        { 
          steps 
            { 
              echo 'Build project' 
            } 
        } 
       stage('Test') 
        { 
            steps 
            { 
              echo 'Test project' 
            }
        } 
        stage('Deploy') 
        { 
            steps 
              { 
                echo 'Deploy project' 
              } 
        } 
      } 
    post 
    { 
      always 
        { 
          emailext body: 'Jenkins First Pipline reults', subject: 'Build results', to: 'aakashsontake391@gmail.com' 
        } 
    } 
  }
