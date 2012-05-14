mvn package -Pdist -Dtar -DskipTests -Dmaven.skip.javadoc=true -pl hadoop-mapreduce-project

cd ./hadoop-mapreduce-project

src_base=/home/nourl/github/hadoop-common/hadoop-mapreduce-project/target/hadoop-mapreduce-0.23.3-SNAPSHOT
dst_base=/home/nourl/github/hadoop-common/hadoop-dist/target/hadoop-0.23.3-SNAPSHOT

cp $src_base/share/hadoop/mapreduce/*.jar $dst_base/share/hadoop/mapreduce/

cp $src_base/share/hadoop/mapreduce/lib/*.jar $dst_base/share/hadoop/mapreduce/lib

cp $src_base/bin/* $dst_base/bin/

cp $src_base/libexec/* $dst_base/libexec/

cp $src_base/bin/* $dst_base/bin/

cp $src_base/sbin/* $dst_base/sbin/


