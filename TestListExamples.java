import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.internal.runners.statements.ExpectException;

public class TestListExamples implements StringChecker{
  // Write your grading tests here!
  public boolean checkString(String s){
    if (s.length()<5){return false;}
    return true;
  }
  @Test(timeout = 50)
  public void testList1(){
    StringChecker check1 = new TestListExamples();
    List<String> testingList = new ArrayList<String>();
    testingList.add("hellooo");
    testingList.add("123456");
    testingList.add("1234");
    ArrayList<String> expected = new ArrayList<>();
    expected.add("hellooo");
    expected.add("123456");
    assertEquals(expected, ListExamples.filter(testingList, check1));
  }
  @Test(timeout = 50)
  public void testFilterEmpty(){
    StringChecker check1 = new TestListExamples();
    List<String> testingList = new ArrayList<String>();
    ArrayList<String> expected = new ArrayList<>();
    assertEquals(expected, ListExamples.filter(testingList, check1));
  }
  @Test(timeout = 50)
  public void testFilterNone(){
    StringChecker check1 = new TestListExamples();
    List<String> testingList = new ArrayList<String>();
    testingList.add("hi");
    testingList.add("12");
    testingList.add("no");
    ArrayList<String> expected = new ArrayList<>();
    assertEquals(expected, ListExamples.filter(testingList, check1));
  }
  @Test(timeout = 50)
  public void testFilterAll(){
    StringChecker check1 = new TestListExamples();
    List<String> testingList = new ArrayList<String>();
    testingList.add("hiiiiiiii");
    testingList.add("122222222");
    testingList.add("nooooooooo");
    ArrayList<String> expected = new ArrayList<>();
    expected.add("hiiiiiiii");
    expected.add("122222222");
    expected.add("nooooooooo");
    assertEquals(expected, ListExamples.filter(testingList, check1));
  }
  @Test(timeout = 50)
  public void testMerge(){
    List<String> input1 = new ArrayList<String>();;
    List<String> input2 = new ArrayList<String>();;
    List<String> output = ListExamples.merge(input1, input2);
    List<String> expected = new ArrayList<String>();;
    assertEquals(expected, output);
  }
  @Test( timeout = 50)
  public void testMergeRegular(){
    List<String> input1 = new ArrayList<String>();;
    List<String> input2 = new ArrayList<String>();;
    input1.add("1");
    input2.add("2");
    List<String> output = ListExamples.merge(input1, input2);
    List<String> expected = new ArrayList<String>();
    expected.add("1");
    expected.add("2");
    assertEquals(expected, output);
  }
  @Test( timeout = 50)
  public void testMergeDuplicates(){
    List<String> input1 = new ArrayList<String>();;
    List<String> input2 = new ArrayList<String>();;
    input1.add("1");
    input1.add("1");
    input1.add("1");
    input2.add("2");
    input2.add("2");
    input2.add("2");
    List<String> output = ListExamples.merge(input1, input2);
    List<String> expected = new ArrayList<String>();
    expected.add("1");
    expected.add("1");
    expected.add("1");
    expected.add("2");
    expected.add("2");
    expected.add("2");
    assertEquals(expected, output);  
  }
  @Test( timeout = 50)
  public void testMergeSame(){
    List<String> input1 = new ArrayList<String>();;
    List<String> input2 = new ArrayList<String>();;
    input1.add("1");
    input2.add("1");
    List<String> output = ListExamples.merge(input1, input2);
    List<String> expected = new ArrayList<String>();
    expected.add("1");
    expected.add("1");
    assertEquals(expected, output);
  }
}

