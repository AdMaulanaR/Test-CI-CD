package AdMaulana.stepDef;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;

import java.util.Objects;

import static AdMaulana.helper.Utility.quitDriver;
import static AdMaulana.helper.Utility.startDriver;

public class Hooks {

    String tagsRunning = null;

    @BeforeAll
    public static void setUp(){
        System.out.println("Before All");
    }
    @AfterAll
    public static void tearDown(){
        System.out.println("After All");
    }

    @Before
    public void beforeTest(Scenario scenario){
        System.out.println("Before Test");

        String[] tags = scenario.getSourceTagNames().toArray(new String[0]);
        tagsRunning = tags[0];
        if (Objects.equals(tagsRunning, "@web")){
            startDriver();
        }
    }
    @After
    public void afterTest(Scenario scenario) throws InterruptedException{

        if (Objects.equals(tagsRunning, "@web")){
            Thread.sleep(1000);
            quitDriver();
        }
    }
}
