#!/bin/sh
LOOK_FOR=$1

if [ -z $LOOK_FOR ]; then
        echo -e "Usage: findclass <classname>\n Will find . -name *.jar and jar tvf them"
fi

for i in `find . -name "*.jar"`
do
  echo "Looking in $i ..."
  jar tvf $i | grep $LOOK_FOR > /dev/null
  if [ $? == 0 ]
  then
    echo "==> Found \"$LOOK_FOR\" in $i"
  fi
done
