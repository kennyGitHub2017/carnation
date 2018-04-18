#!/bin/sh

java -Xmx1024M -Xms1024M -Xmn400M -XX:PermSize=128M -XX:MaxPermSize=128M -XX:+UseParallelOldGC -XX:-UseAdaptiveSizePolicy -XX:SurvivorRatio=3 -cp .:lib/* com.sinco.carnation.job.JobStart  &
echo $! > main.pid