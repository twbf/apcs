#!/usr/bin/env  bash

#format: gaz.sh python file
#can use other prgrams too
#if local connection isn't avalable then it goes through global wifi server

LIP="192.168.1.5"
GIP="24.237.37.131"

#check whether user is local
ssh -q thomas@$LIP exit

#set IP adress to be the right one
if [ $? -eq 0 ]; then
    IP="$LIP"
elif [ $? -eq 255 ]; then
    IP="$GIP"
fi

echo $IP
