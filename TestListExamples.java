import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

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
  public void testMerge(){
    List<String> input1 = new ArrayList<String>();;
    List<String> input2 = new ArrayList<String>();;
    List<String> output = ListExamples.merge(input1, input2);
    List<String> expected = new ArrayList<String>();;
    assertEquals(expected, output);
  }
}

