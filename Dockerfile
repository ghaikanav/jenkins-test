FROM openjdk 

COPY target/assessment-0.0.1-SANPSHOT.jar /deployments/

CMD java -cp /deployments/assessment-0.0.1-SANPSHOT.jar com.kanav.assessment.fileReader.App
