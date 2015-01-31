#!/bin/bash
 
for eachbranch in $(git branch -a | grep remotes | grep -v HEAD | grep -v master | awk -F/ '{print $3}'); 
do
  git branch $eachbranch --track remotes/origin/$eachbranch;
done
