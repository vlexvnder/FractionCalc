public class BasicTester{
  int c=1;
  public void test(){
    TestUtil.test(this);
  }
  public BasicTester(){}
  public void assertEquals(String x, String y){
    if(x.equals(y)) System.out.println("Test Case: "+c+" TRUE");
    else System.out.println("Test Case: "+c+" False");
    c++;
  }
}
