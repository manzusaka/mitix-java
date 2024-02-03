package com.mitix.len.jvm.classlifecycle;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class ParentClass {
    private String s_val = "f-成员变量";
    private static String s_static_val = "f-静态变量";
    private SubClass subClass = new SubClass("member");
    private static SubClass s_subClass;


    // 静态初始化块
    static {
        //静态变量类加载是完成初始化
        System.out.println(s_static_val);
        s_subClass = new SubClass();
        System.out.println("父类--静态初始化块");
    }

    // 初始化块
    {
        //成员变量类实例化完成初始化
        System.out.println(s_val);
        System.out.println("父类--初始化块");
    }

    // 构造器
    public ParentClass() {
        System.out.println("父类--构造器");
    }

    //子类初始化
    public void init() {
        System.out.println("父类-init");
    }

    @Override
    public int hashCode() {
        System.out.println("父类-执行hashCode");
        return super.hashCode();
    }

    @Override
    public String toString() {
        System.out.println("父类-执行tostring");
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("父类-执行finalize");
    }
}
