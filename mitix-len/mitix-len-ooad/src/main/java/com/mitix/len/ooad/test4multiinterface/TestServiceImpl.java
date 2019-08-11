package com.mitix.len.ooad.test4multiinterface;

/**
 * @author oldflame-jm
 * @create 2018/4/5
 * ${DESCRIPTION}
 */
public class TestServiceImpl implements TestService1, TestService2 {
    @Override
    public void sayhaha(String name) {
        System.out.println("this is how haha  " + name);
    }

    public static void main(String[] args) {
        TestServiceImpl testServiceImpl = new TestServiceImpl();
        TestService1 testService1 = (TestService1) testServiceImpl;
        testService1.sayhaha("lala1");
        TestService2 testService2 = (TestService2) testServiceImpl;
        testService2.sayhaha("lala2");
    }
}
