def call(ip,user,credId){
  sshagent([credId]) {
    sh "mv target/myweb*.war target/app.war"
    // copy war
    sh "scp -o StrictHostKeyChecking=no target/app.war ${user}@${ip}:/opt/tomcat9/webapps"
    // stop server
    sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
    // start server
    sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
  }
}
