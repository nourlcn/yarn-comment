for x in `jps|grep -v Jps|awk {'print $1'}`;
do
	kill $x
done
