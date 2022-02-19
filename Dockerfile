FROM maven:3.8.4-jdk-11
COPY . /app
WORKDIR /app
RUN mvn clean package
RUN chmod -R 777 target/rtapp-0.0.1.war
CMD ["java", "-jar", "target/rtapp-0.0.1.war"]