export MAVEN_OPTS=-Xmx1024m
#mvn clean package -Pdist -Dtar -DskipTests
#mvn clean package -Pdist -Dtar -DskipTests

mvn clean package -Pdist -Dtar -DskipTests -Dmaven.skip.javadoc=true |grep -v [INFO]
