# Create your grading script here

# set -e

rm -rf student-submission
git clone $1 student-submission

cd student-submission
file="ListExamples.java"
if [[ -e $file ]]
then
    echo "true"
else
    echo "File Does not Exist"
    exit
fi

cp ../TestListExamples.java ./

javac ListExamples.java
javac TestListExamples.java
if [[ $? == 0 ]]
then
    javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
    java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples
else 
    echo "Not Compliling!"
fi