package cucumber_class.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void setup(){
        System.out.println("Before hook has been executed");

    }

    @After
    public void cleanup(){



    }
}
