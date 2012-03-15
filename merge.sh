update_file=./update_file

git add .

dt=`date|awk '{print $5}'`

git commit -m "$dt"

git checkout branch-0.23

echo "" >> $update_file
echo "$dt" >> $update_file

git pull origin branch-0.23 >> $update_file

echo "--------------------------------------"  >> $update_file


git checkout branch-act-idea

git merge branch-0.23
