# Create your grading script here
 
# set -e
DirNAME="./student-submission/" 
rm -rf student-submission
git clone $1 student-submission
 
cd student-submission

echo -e "\n"
Score=0
MaxScore=100
EachSucess=10
InputFile="ListExamples.java"
TestFile="TestListExamples.java"
file="ListExamples"
CPATH=".:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar"
total=1

TESTINFO=".unittest.error"

if [[ -e $InputFile ]]
then
   echo -e [Found] $InputFile [+10 points]
   Score=$(($Score+$EachSucess))
else
   echo -e "File Does not Exist." [Exception]
   echo "Total points: [$Score]"
   exit
fi

cp ../TestListExamples.java ./
javac -cp $CPATH *.java 2> Compile-err.txt

javac ListExamples.java
if [[ $? == 0 ]]
then
   echo [Complie Success] $InputFile [+10 points]
   Score=$(($Score+$EachSucess))
   javac -cp .:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar *.java
   java -cp .:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > error.txt
else
   echo [Fail to Compile] $InputFile [Exception]
   echo "Total Points: [$Score]"
   exit
fi

java -cp $CPATH org.junit.runner.JUnitCore $file > test-result.txt

grep -A100000  Failures: test-result.txt > calculation.txt
sed -e 's/^.*, //' calculation.txt > calculation2.txt
sed -e 's/^.*: //' calculation2.txt > calculation3.txt
# NumSucess=$(($total-$error))
# NewScore=$(($EachSucess*$NumSucess))
# Score=$(($Score+$NewScore))

echo -e "\nResults:\n[+10 points for every correct test]"
grep -A100000 Failures: test-result.txt

echo -e "Total Points:"
awk '{sum= sum+$1} END { print 100-sum*10}' calculation3.txt

