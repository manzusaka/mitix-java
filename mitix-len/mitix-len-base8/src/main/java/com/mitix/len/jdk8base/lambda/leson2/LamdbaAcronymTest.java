package com.mitix.len.jdk8base.lambda.leson2;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author oldflame-jm
 * @create 2018/9/6
 * lamdba的方法和构造器的引用
 * lamdba的简写
 */
public class LamdbaAcronymTest {

    /**
     * 测试静态方法引用
     */
    @Test
    public void testStaticMethod() {
        Integer[] integerArray = new Integer[]{3, 2, 1, 7, 0};
        //倒叙排序
        Arrays.sort(integerArray, (x, y) -> Integer.compareUnsigned(y, x));
        //进行排序
        Arrays.sort(integerArray, Integer::compareUnsigned);
        System.out.println(integerArray[0]);
        System.out.println(integerArray[1]);
        System.out.println(integerArray[2]);
        System.out.println(integerArray[3]);
        System.out.println(integerArray[4]);
    }

    @Test
    public void testObjectMethod() {
        List<String> names = new ArrayList<>();
        names.add("info1");
        names.add("info3");
        names.add("info2");
        //lamdba表达式
        names.forEach(str -> System.out.println(str));
        names.forEach(System.out::println);
    }


    /**
     * 方法引用的第一个参数被用作接受者
     * 实例方法绑定
     */
    @Test
    public void testComparator() {
        Comparator<Person> personComp = Comparator.comparing(p -> p.getLastName());
        //这里的格式也是ReferenceType:Identifer  但是Identifer是实例方法不是静态方法
        //因为接收者不确定
        Comparator personComp2 = Comparator.comparing(Person::getLastName);

        Map<String, String> map = new LinkedHashMap<>();
        map.put("alpha", "X");
        map.put("bravo", "Y");
        map.put("charlie", "Z");

        String str = "alpha-bravo-charlie";
        //绑定方法  表达式
        //map.replaceAll((k, y) -> str.replace(k, y));
        //简写表达式,
        map.replaceAll(str::replace);


        //未绑定方法
        //map.replaceAll((k, v) -> k.concat(v));
        //未绑定方法简写，会把第一个参数传入进去，作为接收者
        map.replaceAll(String::concat);


        System.out.println(map.get("alpha"));
    }


    /**
     * 构造器引用
     */
    @Test
    public void testConstructor() {
        Stream<String> stringStream = Stream.of("aaa.txt");

        //正常写法
        //Stream<File> fileStream1 = stringStream.map(s -> new File(s));
        //简写
        Stream<File> fileStream2 = stringStream.map(File::new);
    }
}
