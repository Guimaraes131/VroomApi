# Etapa de build com Maven + Java 21
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app

# Copia pom.xml para cache de dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código
COPY src ./src

# Build do projeto
RUN mvn clean package -DskipTests

# Etapa de runtime (Java 21)
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app

# Copia o JAR gerado
COPY --from=build /app/target/VroomApi-0.0.1-SNAPSHOT.jar ./app.jar

# Expondo porta 8080
EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]
