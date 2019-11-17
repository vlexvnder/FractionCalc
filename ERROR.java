//creates a generic error with two constructors; either a message or a message and a cause
public class ERROR extends Exception{
  public ERROR(String message, Throwable cause){
    super(message, cause);
  }
  public ERROR(String message){
    super(message);
  }
}