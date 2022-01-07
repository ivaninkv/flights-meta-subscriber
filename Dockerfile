FROM openjdk:11-jre-buster
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", \
            "-Dspring.datasource.url=${DB_URL}", \
            "-Dspring.datasource.username=${DB_USER}", \
            "-Dspring.datasource.password=${DB_PASS}", \
            "-Ddictionary.fixedRateString=${DICT_FIXED_RATE}", \
            "-Ddictionary.countryURL=${DICT_COUNTRY_URL}", \
            "-Ddictionary.cityURL=${DICT_CITY_URL}", \
            "-jar", "app.jar"]
