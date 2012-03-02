export MAVEN_OPTS=-Xmx1024m
mvn clean package -Pdist -Dtar -DskipTests
