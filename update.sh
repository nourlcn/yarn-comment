git add .

dt=`date|awk '{print $5}'`

git commit -m "$dt"

git checkout branch-0.23

git pull origin branch-0.23

git checkout branch-act-idea

git merge branch-0.23
