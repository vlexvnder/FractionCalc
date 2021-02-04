
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;



public class TestUtil {


  public static Collection<Method> getMethods(Class<?> clazz) {

    Collection<Method> found = new ArrayList<Method>();
    
      for (Method m1 : clazz.getDeclaredMethods()) {
        boolean overridden = false;

        for (Method m2 : found) {
          if (m2.getName().equals(m1.getName())
              && Arrays.deepEquals(m1.getParameterTypes(), m2
                  .getParameterTypes())) {
            overridden = true;
            break;
          }
        }

        if (!overridden)
          found.add(m1);
      }
return found;
    }

    
  
  public static void test(Object n){
    

    for(Method m:TestUtil.getMethods(n.getClass())){
      try{
      System.out.print(m.getName()+" ");
      m.invoke(n, new Object[] {});
      }catch(IllegalArgumentException e){}catch(IllegalAccessException f){}
      catch(java.lang.reflect.InvocationTargetException e){}
    }
  }
   
}
