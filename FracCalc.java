import java.math.*;
import java.util.*;

class FracCalc {
  
/*
Scans the userinput in and calls the produceAnswer method

Throws ERROR
*/

   public static void main(String[] args) throws ERROR
    {
       Scanner s=new Scanner(System.in);
       while(true){
        String in=s.nextLine();
        
        if(in.toUpperCase().equals("quit".toUpperCase())){
          break;
        }
       System.out.println(produceAnswer(in));
       }
    } 
   /*
  Iterates through the input while constructing Fractions parsed by Fraction.parse()

  @Param input: the userinput String

  Throws Error
   */
    public static String produceAnswer(String input) throws ERROR
    { 
      //Puts the input, delimited by spaces, into a List
       List<String> arr = new ArrayList<String>(Arrays.asList(input.split(" ")));
        
        //checks to make sure there is two fractions and one operator, or just one Fraction, else throws ERROR
        if(arr.size()<3 & arr.size()>1){
            throw new ERROR("Not enough numbers or operations to create a mathematical sentence");
        }

        //iterates through List of inputs
        while(arr.size()>1){
          Fraction f;
          Fraction s;

          //Parses the inputs
          try{
           f=Fraction.parse(arr.get(0));
           s=Fraction.parse(arr.get(2));
          }
          //If improperly formatted, throws ERROR
          catch(NumberFormatException e){
            throw new ERROR("Cannot convert input to fraction", e);
          }

          //Gets the operator
          String op=arr.get(1);
       
          
          //conducts operations
          if(op.equals("+")){
            arr.set(2, Fraction.add(f,s).toString());
          }
          else if(op.equals("-")){
            arr.set(2, Fraction.subtract(f,s).toString());
          }
          else if(op.equals("*")){
          
            arr.set(2, Fraction.multiply(f,s).toString());
          }
          else if(op.equals("/")){
           arr.set(2, Fraction.divide(f,s).toString());
          }
          else{
throw new ERROR("Invalid Operation");
          }
         
         //makes the output the first element on list by removing previous operator and initial fraction
          arr.remove(0);
          arr.remove(0);
                  




        }
        //returns the result
        try{
        return Fraction.parse(arr.get(0)).toString();
        }
        catch(NumberFormatException e){
            throw new ERROR("Cannot convert input to fraction", e);
          }
    } }
    
