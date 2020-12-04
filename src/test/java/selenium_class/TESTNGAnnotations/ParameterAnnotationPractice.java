package selenium_class.TESTNGAnnotations;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotationPractice {

    //We need to use parameters annotation with xml file bc the values for our parameter will come from xlm file.

   @Parameters({"firstName", "lastName"})
    @Test
    public void printName(String name, String lastName){
        System.out.println("The name is:"+ name);
        System.out.println("The last name is:"+ lastName);

    }


}
