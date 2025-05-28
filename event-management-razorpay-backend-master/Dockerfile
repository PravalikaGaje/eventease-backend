# Build stage
FROM maven:3.9-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Environment variables for application configuration
ENV SPRING_APPLICATION_NAME=event-management-system
ENV SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/event_management_system?createDatabaseIfNotExist=true&useUnicode=true
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=ammu123
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.MySQL8Dialect

# Swagger configuration
ENV SPRINGDOC_PACKAGES_TO_SCAN=com.eventmanagement.controller
ENV SPRINGDOC_PATHS_TO_MATCH=/api/**

# Email configuration
ENV SPRING_MAIL_HOST=smtp.gmail.com
ENV SPRING_MAIL_PORT=587
ENV SPRING_MAIL_USERNAME=pravalikagaje2002@gmail.com
ENV SPRING_MAIL_PASSWORD=snop eywo habv qcly
ENV SPRING_MAIL_PROPERTIES_MAIL_SMTP_AUTH=true
ENV SPRING_MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_ENABLE=true

# Razorpay configuration
ENV COM_EVENTMANAGEMENT_PAYMENTGATEWAY_RAZORPAY_KEY=rzp_test_3nrR6uALCMwvMx
ENV COM_EVENTMANAGEMENT_PAYMENTGATEWAY_RAZORPAY_SECRET=qMwtgeukwXEDDigs5M9UxlZj

# File upload configuration
ENV SPRING_SERVLET_MULTIPART_MAX_FILE_SIZE=10MB
ENV SPRING_SERVLET_MULTIPART_MAX_REQUEST_SIZE=10MB

# Create directory for image storage
RUN mkdir -p /app/images
ENV COM_EVENTMANAGEMENT_IMAGE_FOLDER_PATH=/app/images

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]