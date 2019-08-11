package com.mitix.len.multithread4oood.producer_consumer.exp1;

/**
 * @author oldflame-jm
 * @create 2018/4/9
 * ${DESCRIPTION}
 */
public class CakeMainTest {
    public static void main(String[] args) {
        Table table = new Table(3);
        new MakerThread("MakerThread-1", table, 2222).start();
        new MakerThread("MakerThread-2", table, 4555).start();
        new MakerThread("MakerThread-3", table, 9999).start();
        new EaterThread("EaterThread-1", table, 1888).start();
        new EaterThread("EaterThread-2", table, 6666).start();
        new EaterThread("EaterThread-3", table, 8999).start();
    }
}
