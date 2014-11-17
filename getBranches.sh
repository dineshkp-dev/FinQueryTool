#!/bin/bash
#Simple shell script to get all the branches from the Remote repository.
#The script downloads each of the branches from the Remote Repository and creates local branches (which track them) with the same name.
#1. Clone the Remote Repository
#2. Ensure the permissions for this script allow the sript to be executed.
#3. Execute the script.

for eachbranch in $(git branch -a | grep remotes | grep -v HEAD | grep -v master | awk -F/ '{print $3}'); 
do
  git branch $eachbranch --track remotes/origin/$eachbranch;
done