node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/ZOSOpenTools/gitlabcliport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/gitlabcliport.git'), string(name: 'PORT_DESCRIPTION', value: 'GLab is an open source GitLab CLI tool bringing GitLab to your terminal next to where you are already working with git and your code without switching between windows and browser tabs. Work with issues, merge requests, watch running pipelines directly from your CLI among other features.' ), string(name: 'BUILD_LINE', value: 'STABLE'), string(name: 'NODE_LABEL', value: "go_120" ) ]
  }
}
