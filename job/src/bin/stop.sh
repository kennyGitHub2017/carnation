#!/bin/sh

cat ./main.pid |while read LINE
do
    kill -9 $LINE
    echo "kill $LINE"
done