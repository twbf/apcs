#!/usr/bin/env  bash
#format: gaz.sh python file
#can use other prgrams too
#if local connection isn't avalable then it goes through global wifi server

#Notes: Need to solve global IP bug

LIP="192.168.1.5"
GIP="24.237.37.131"

#check whether user is local
ssh -q ConnectTimeout=5 thomas@$LIP exit

#set IP adress to be the right one
if [ $? -eq 0 ]; then
    IP=$LIP
elif [ $? -eq 255 ]; then
    IP=$GIP
fi

#copy files over and run commands
SET UPSTREAM

cur=$(pwd)

cd /Users/thomasbueler-faudree/Github/
git add $cur
git commit -m 'automated test'
git push origin master

ssh thomas@$IP /bin/bash << EOF
    source ~/tensorflow/venv/bin/activate
    cd mac/
    git pull
    $1 $2
    git add .
    git commit -m 'auto server'
    git push origin master
EOF

cd /Users/thomasbueler-faudree/Github/
git pull origin master

# cd /home/
# git pull
# $1 $dir/$2
