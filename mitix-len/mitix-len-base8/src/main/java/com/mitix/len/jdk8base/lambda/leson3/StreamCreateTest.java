package com.mitix.len.jdk8base.lambda.leson3;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.zip.ZipFile;

/**
 * @author oldflame-jm
 * @create 2018/9/6
 * ${DESCRIPTION}
 */
public class StreamCreateTest {

    @Test
    public void testExample1() {
        IntStream.iterate(1, i -> i * 2).limit(10).forEachOrdered(System.out::println);
    }

    /**
     * 创建空的Stream对象
     */
    @Test
    public void testStreamCreate1() {
        Stream stream = Stream.empty();
    }

    /**
     * 通过集合类中的stream或者parallelStream方法创建；
     */
    @Test
    public void testStreamCreate2() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        //获取串行的Stream对象
        Stream listStream = list.stream();
        //获取并行的Stream对象
        Stream parallelListStream = list.parallelStream();
    }

    /**
     * 通过Stream中的of方法创建
     */
    @Test
    public void testStreamCreate3() {
        Stream s = Stream.of("test");
        Stream s1 = Stream.of("a", "b", "c", "d");
    }

    /**
     * 通过Stream中的iterate方法创建
     * iterate方法有两个不同参数的方法：
     */
    @Test
    public void testStreamCreate4() {
        List<Integer> ages = Stream.iterate(new Car("dudu", 12), car -> {
            car.setAge(133);
            return car;
        }).map(Car::getAge).collect(Collectors.toList());
        System.out.println(ages.get(0));
        //static<T > Stream < T > iterate(T seed, Predicate < ? super T > hasNext, UnaryOperator < T > next)
    }

    /**
     * 通过Stream中的generate方法创建
     */
    @Test
    public void testStreamCreate5() {
        Stream.generate(() -> new Car("dudu", 22));
    }

    /**
     * 通过IntStream LongStream中的range方法创建
     */
    @Test
    public void testStreamCreate6() {
        LongStream arrStream = LongStream.range(1, 20);
        OptionalLong ol = arrStream.max();
        System.out.println(ol.orElse(-1L));

        arrStream = LongStream.empty();
        OptionalLong ol2 = arrStream.max();
        System.out.println(ol2.orElse(-1L));
    }

    /**
     * 通过Arrays创建
     */
    @Test
    public void testStreamCreate7() {
        Arrays.stream(new Object[]{"aa", "bb"});
    }


    /**
     * 通过BufferedReader创建
     */
    @Test
    public void testStreamCreate8() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/oldflame-jm/tmp/aaaa.ttx")));
        Stream<String> lines = reader.lines();
    }

    /**
     * 通过File创建
     */
    @Test
    public void testStreamCreate9() throws FileNotFoundException {
        Path paths = new File("/Users/oldflame-jm/").toPath();
        try (Stream<Path> pathStream = Files.walk(paths)) {
            pathStream.map(Path::toFile)
                    .filter(File::isDirectory)
                    .map(file -> file.getAbsoluteFile()).forEach(str -> System.out.println(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Pattern
     */
    @Test
    public void testStreamCreate10() throws FileNotFoundException {
        String split = ",";
        Pattern pattern = Pattern.compile(split);
        String info = "look is dd,woesss。  where,infoss, &&s ss,s7yyy";
        pattern.splitAsStream(info).forEach(System.out::println);
    }


    /**
     * JarFile  ZipFile
     */
    @Test
    public void testStreamCreate11() throws IOException {
        JarFile jarFile = new JarFile(new File("/Users/oldflame-jm/.m2/repository/commons-logging/commons-logging/1.1.3/commons-logging-1.1.3.jar"));
        jarFile.stream();

        ZipFile zipFile = new ZipFile(new File("/Users/oldflame-jm/.m2/repository/commons-logging/commons-logging/1.1.3/commons-logging-1.1.3.jar"));
        zipFile.stream();

    }
}
