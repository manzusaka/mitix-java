package com.mitix.len.jvm.classlifecycle;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class SubClass {
    private String s_val = "s-成员变量";
    private static String s_static_val = "s-静态变量";

    // 静态初始化块
    static {
        //静态变量类加载是完成初始化
        System.out.println(s_static_val);
        System.out.println("子类--静态初始化块");
    }

    // 初始化块
    {
        //成员变量类实例化完成初始化
        System.out.println(s_val);
        System.out.println("子类--初始化块");
    }

    // 构造器
    public SubClass() {
        System.out.printf("子类--构造器 name=%s\n", "default");
    }

    // 构造器
    public SubClass(String name) {
        System.out.printf("子类--构造器 name=%s\n", name);
    }

    //子类初始化
    public void init() {
        System.out.println("子类-init");
    }

    @Override
    public int hashCode() {
        System.out.println("子类-执行hashCode");
        return super.hashCode();
    }

    @Override
    public String toString() {
        System.out.println("子类-执行tostring");
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("子类-执行finalize");
    }

    // 程序入口
    public static void main(String[] args) {
        new SubClass();
    }
}
