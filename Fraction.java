import java.util.*;
import java.math.BigInteger;
class Fraction{
 
  public int num;
  public int denom;
  
  //constructor for a proper fraction w/ whole component, makes it impropper
  public Fraction(int whole, int numerator, int denominator){
    
    //checks if Denom is 0; throws exception
    if(Integer.signum(denominator)==0){
      throw new ArithmeticException("Can't set denominator to 0");
    }

    //checks whether fractional part should be positive or negative based on whole input


    if(Integer.signum(whole)==-1){
      numerator=0-numerator;
    }

    //turns fraction into an improper fraction
    this.num=numerator;
    this.denom=denominator;
    this.num+=whole*this.denom;
    simplify();
  
  }
  //Constructor for impropper or fraction w/o whole part
  public Fraction(int numerator, int denominator){
    
   if(denominator==0){
      throw new ArithmeticException("Can't set denominator to 0");
    }
    this.num=numerator;
    this.denom=denominator;
    simplify();
  }

  //constructs a frac with a whole part, makes impropper
  public Fraction(int whole){
     this.num=whole;
     this.denom=1;
   simplify();
  }

  //makes the denominators equal
  public static void makeDenomsEqual(Fraction a, Fraction b){
    int ad=a.denom;
    a.num=a.num*b.denom;
    a.denom=a.denom*b.denom;
    b.denom=ad*b.denom;
    b.num=b.num*ad;
  }
  //addition
  public static Fraction add(Fraction a, Fraction b){
    
    makeDenomsEqual(a,b);
    Fraction res=new Fraction(a.num+b.num, a.denom);
    res.simplify();
    return res;
    
  }
  //subtraction
  public static Fraction subtract(Fraction a, Fraction b){
    
    makeDenomsEqual(a,b);
    Fraction res=new Fraction(a.num-b.num, a.denom);
    
    res.simplify();

    return res;  
  }

//multiplication
  public static Fraction multiply(Fraction a, Fraction b){
   
    

    Fraction res=new Fraction(a.num*b.num,a.denom*b.denom);

    res.simplify();

    return res;

  }
//division
  public static Fraction divide(Fraction a, Fraction b){
     
      int temp=b.denom;
      
      b.denom=Math.abs(b.num);
      if(b.num<0){b.num=-temp;}
      else{b.num=temp;}
      
      return multiply(a,b);
  }

  
  //simplifies an impropper fraction
  public void simplify(){
    
    //uses BigInteger to get the gcd and divide
    BigInteger b1 = BigInteger.valueOf(num);
    BigInteger b2 = BigInteger.valueOf(denom);
    BigInteger g = b1.gcd(b2);
    int gcd=g.intValue();
    num=num/gcd;
    denom=denom/gcd;
    
  }

  //parses a fraction from a string
  public static Fraction parse(String in){

    //parses a propper frac w/ whole compopnent
    if(in.contains("_")){
      return new Fraction(
        Integer.parseInt(in.substring(0, in.indexOf("_"))),
        Integer.parseInt(in.substring(in.indexOf("_")+1, in.indexOf("/"))),
         Integer.parseInt(in.substring(in.indexOf("/")+1)));}

    //parse w/ only frac component
    else if(in.contains("/")){
      return new Fraction(
        Integer.parseInt(in.substring(0, in.indexOf("/"))),
        Integer.parseInt(in.substring(in.indexOf("/")+1))
      
      );
    }
    //parses w/ no frac component
    else{
      return new Fraction(Integer.parseInt(in));
    }
     
    }
  
  //overides toString method so fraction can be printed as a string w/ propper format. 
  @Override
  public String toString(){
    simplify();
    if(num==0){
      return "0";
    }
    else if(denom==1){
      return String.format("%s",num);
    }
    else if(Math.abs(num)>=denom){
      int whole=0;
      while(Math.abs(num)>=denom){
        if(num<0){
          num+=denom;
          whole--;
        }
        else{
          num-=denom;
          whole++;
        }
      }
      if(num==0){return String.format("%s",whole); }
      else{return String.format("%s_%s/%s",whole,Math.abs(num),denom);}
    }
    else{
      return String.format("%s/%s",num,denom);
    }
  }
}