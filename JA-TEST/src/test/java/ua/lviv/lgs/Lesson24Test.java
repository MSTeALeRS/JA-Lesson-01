package ua.lviv.lgs;

import org.junit.*;
import org.junit.rules.TestWatcher;

public class Lesson24Test {


    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        protected void failed(Throwable e, org.junit.runner.Description description) {
            System.out.println("FAILED--> " + description.getMethodName());
        }

        ;

        protected void succeeded(org.junit.runner.Description description) {
            System.out.println("SUCCEED--> " + description.getMethodName());
        }

        ;
    };


    @Test
    public void timeTest() {
        new Time(10, 15);
    }

    @Test
    public void addTimeTest() {
        Time actualSum = Time.addTime(new Time(10, 15), new Time(2, 5));
        int actualHour = actualSum.getHour();
        int expectedHour = 12;
        int actualMin = actualSum.getMin();
        int expectedMin = 20;

        Assert.assertEquals(actualHour, expectedHour);
        Assert.assertEquals(actualMin, expectedMin);
    }


}