SRC=/home/nourl/github/mr2_config
DST=/home/nourl/github/hadoop-common/hadoop-dist/target/hadoop-0.23.3-SNAPSHOT

cp $SRC/export.sh $DST/
cp $SRC/*.xml $DST/etc/


cd $DST

mkdir conf

mv etc/hadoop/*  ./conf/
cat $SRC/debug >> ./conf/yarn-env.sh

cp $DST/share/hadoop/mapreduce/*example*.jar $DST/
cp $SRC/input $DST/


#scp -r -P1314 ./* hadoop@115.25.139.50:/home/hadoop/yarn/

#echo "pi"
#echo "----------"
echo "bin/hadoop jar hadoop-mapreduce-examples-0.23.3-SNAPSHOT.jar pi 1 1"

#echo "wordcount"
#echo "--------------"
echo "bin/hadoop jar hadoop-mapreduce-examples-0.23.3-SNAPSHOT.jar wordcount file:///home/nourl/github/hadoop-common/hadoop-dist/target/hadoop-0.23.3-SNAPSHOT/input file:///home/nourl/github/hadoop-common/hadoop-dist/target/hadoop-0.23.3-SNAPSHOT/output"

#source export.sh
#bin/hdfs namenode -format -clusterid testhdfs

