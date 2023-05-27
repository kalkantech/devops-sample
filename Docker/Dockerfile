# Fetching latest version of Java
FROM ${JAVA_BASE_IMAGE}

# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/${JAVA_JAR_NAME}-${PROJECT_VERSION}.jar /app

# Exposing port 8080
EXPOSE 8080

# Starting the application
CMD ["java", "-jar", "${JAVA_JAR_NAME}-${PROJECT_VERSION}.jar"]