rem rmi compile the server class file
rmic RMIServer

rem compile all java files (server, interface and client)
javac *.java

rem start the rmiregistry in the background
start rmiregistry

rem start, bind and register the RMIServer
start java RMIServer

rem wait for the server to fully start up
pause

rem execute the RMIClient
java -Djava.security.policy=client.policy RMIClient

pause
