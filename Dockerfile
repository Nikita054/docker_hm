FROM main_image:latest

RUN wget --no-verbose -O /tmp/apache-maven-3.3.9-bin.tar.gz http://www-eu.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz && \
    tar xzf /tmp/apache-maven-3.3.9-bin.tar.gz -C /opt/ && \
    ln -s /opt/apache-maven-3.3.9 /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/local/bin  && \
    rm -f /tmp/apache-maven-3.3.9-bin.tar.gz

ENV MAVEN_HOME /opt/maven

COPY ./ /app

RUN mvn -f /app/pom.xml package spring-boot:repackage

CMD ["java", "-jar", "/app/target/Docker_hm-1.0-SNAPSHOT.jar", "ru.sstu.homework.MainApplication"]