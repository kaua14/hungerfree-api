# Define a imagem base
FROM openjdk:17-jdk

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da sua aplicação para o contêiner
COPY target/hungerfree.jar app.jar

# Define o comando de execução da sua aplicação
CMD ["java", "-jar", "app.jar"]