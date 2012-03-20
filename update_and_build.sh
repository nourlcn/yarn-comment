git pull hg branch-act-idea

export MAVEN_OPTS=-Xmx1024m

#mvn clean package -Pdist -Dtar -DskipTests
mvn clean package -Pdist -Dtar -DskipTests
