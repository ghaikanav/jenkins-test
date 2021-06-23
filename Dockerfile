FROM openjdk 

COPY target/assessment-0.0.1-SNAPSHOT.jar /deployments/

COPY emps.txt /deployments/

CMD java -cp /deployments/assessment-0.0.1-SNAPSHOT.jar com.kanav.assessment.fileReader.App
