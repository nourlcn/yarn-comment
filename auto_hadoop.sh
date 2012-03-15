SRC=/home/nourl/github/mr2_config
DST=/home/nourl/github/hadoop-common/hadoop-dist/target/hadoop-0.23.3-SNAPSHOT

cp $SRC/export.sh $DST/
cp $SRC/*.xml $DST/etc/


cd $DST

mkdir conf

mv etc/hadoop/*  ./conf/
cat $SRC/debug >> ./conf/yarn-env.sh

#source export.sh
#bin/hdfs namenode -format -clusterid testhdfs

