#!/bin/bash
{
usage="
Please execute the script as shown below:
	$ ./RunTool.sh [\"inputFileLocation.xml\"]
"
inputFile="inputdetails.xml"
#extract the version from the 'build.gradle' file
version=$(grep "version =" 'build.gradle' | awk -F\' '{print $2}')

echo "************************"
echo "Welcome, $USER!"
jarFile="build/FinancialQueryToolBuild/FinancialQueryTool-${version}.jar"
echo "Jar File is: ${jarFile}"

if [[ -z $1 ]];
then
	echo "Using '$inputFile' file in current directory"
else
	inputFile=$1
	echo "Using user provided input file: $inputFile"
fi

if [ -f $jarFile ];
then
	echo "Program Jar file exists"
	if [ -f $1 ];
	then
		echo "Starting the Financial Query Tool."
		java -jar $jarFile || echo "Error occured during Jar Execution"
		exit;
	else 
		echo "Input file location is not valid."
	fi
else
	echo "Jar File was not found."
fi
}
