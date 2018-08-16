#!/usr/bin/env  bash

#Moves Scripts from the scripts directory to /usr/local/bin and makes them executable

for i in *; do
    sudo cp $i /usr/local/bin/
    sudo chmod 755 /usr/local/bin/$i
    echo "Moved: $i"
done
