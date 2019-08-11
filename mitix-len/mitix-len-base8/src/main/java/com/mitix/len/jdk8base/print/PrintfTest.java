package com.mitix.len.jdk8base.print;

/**
 * @author oldflame-jm
 * @since 1.0.0
 */
public class PrintfTest {
    public static void main(String[] args) {
        //定义一些变量，用来“格式化”输出。
        double a = 848.234;//double型无法强制类型转换为String型，
        float d = (float) a;
        String b = "nihao";
        int c = 111;
        char e = '.';
        System.out.print("输出字符：");
        System.out.printf("%c", e);//"%c"输出一个字符。
        System.out.println();
        //“%”表示进行格式化输出，“%”之后的内容为格式化的定义。
        System.out.println("单精度浮点型:" + d);/*单精度浮点型占32位存储空间，在一些
        处理器上比双精度更快而且只占用双精度一般的空间，但是当值很大或很小的时候，它
        将变得不准确*/
        System.out.println("双精度型:" + a);/*双精度型占64位存储空间，在一些现代化的
        被优化用来进行高速数学计算的处理器上比单精度的快，当需要保持多次反复迭代计算
        的准确性时，或在操作值很大的数字时，双精度是最好的选择。*/
        System.out.print("格式化输出浮点数:");
        System.out.printf("%f", a);//格式化输出浮点数。
        System.out.println();
        System.out.print("输出长度为9，小数点后两位的值：");
        System.out.printf("%9.2f", a);/*“9.2”中的9表示输出的长度，2表示小数点后的
        位数,其中标点符号也占一位*/
        System.out.println();
        System.out.print("输出长度为9，小数点后两位的值：");
        System.out.printf("%9.2f000000", a);//指定位置填0
        System.out.println();
        System.out.print("输出长度为9，小数点后两位,带正负号的值：");
        System.out.printf("%+9.2f", a);//“+”表示输出的数带正负号。
        System.out.println();
        System.out.print("输出长度为9，小数点后两位,左对齐（默认为右对齐）的值：");
        System.out.printf("%-9.2f", a);//“-”表示输出的数左对齐（默认为右对齐）。
        System.out.println();
        System.out.print("输出长度为9，小数点后两位,带符号，左对齐（默认为右对齐）的值：");
        System.out.printf("%+-9.2f", a);//“+-”表示输出的数左对齐（默认为右对齐）。
        //不能用指数形式输出
        System.out.println();
        System.out.print("输出十进制整数:");
        System.out.printf("%d", c);//“%d”表示输出十进制整数。
        System.out.println();
        System.out.print("输出宽度为10的十进制整数:");
        System.out.printf("%10d", c);/*“%md”表示输出宽度为m的十进制整数，如果数据
        的位数小于m，则左端补以空格，若大于m，则按实际位数输出。其他进制数也可以这样*/
        System.out.println();
        System.out.print("输出长整型数据:");
        System.out.printf("%1d", c);//“%1d”表示输出长整型数据，前面的是数字1。
        System.out.println();
        System.out.print("输出八进制整数:");
        System.out.printf("%o", c);//“%o”表示输出八进制整数。//"%u"输出十进制形式无法使用。
        System.out.println();
        System.out.print("输出带有八进制标志的整数:");
        System.out.printf("%#o", c);//“%#o”表示输出带有八进制标志的整数。标志是数字0
        System.out.println();
        System.out.print("输出十六进制整数:");
        System.out.printf("%x", c);//“%x”表示输出八进制整数。
        System.out.println();
        System.out.print("输出带有十六进制标志的整数:");
        System.out.printf("%#x", c);//“%#x”表示输出带有十六进制标志的整数标志，标志第一位是数字0。
        //printf不能用于输出二进制，可以用如下方式输出二进制
        System.out.println("十进制转换为二进制：" + Integer.toBinaryString(c));
        //这种方法也可以输出八进制，十六进制，分别如下，但不可以将其他进制转换为十进制
        System.out.println("十进制转换为八进制：" + Integer.toOctalString(c));
        System.out.println("十进制转换为十六进制：" + Integer.toHexString(c));
        //下面的方法只适用于将其他进制转换为十进制
        System.out.println("输出一个二进制数的十进制表示：" + Integer.valueOf("111001", 2));
        System.out.println("输出一个八进制数的十进制表示：" + Integer.valueOf("111001", 8));
        System.out.println("输出一个十六进制数的十进制表示：" + Integer.valueOf("111001", 16));
        System.out.print("输出字符串：");
        System.out.printf("%s", b);//"%s"表示输出字符串，当输出的为字符串时，“%s”可以省去。
        System.out.println();
        System.out.print("输出占m列的字符串：");
        System.out.printf("%13s", b);/*"%ms"表示输出的字符串占m列，如字符串本身长度大于m，则输出
        原字符串;如果串长小与m，则左补空格*/
        System.out.println();
        System.out.print("输出占m列的右对齐的字符串：");
        System.out.printf("%-13s", b);/*-表示字符串右对齐*/
        System.out.println();
        System.out.print("输出占m列，但只取字符串中左端n个字符的的字符串：");
        System.out.printf("%13.3s", b);/*"%m.n"表示输出占m列，但只取字符串中左端n个字符，右对齐*/
        System.out.println();
        System.out.print("输出占m列，但只取字符串中左端n个字符的右对齐的字符串：");
        System.out.printf("%-13.3s", b);/*-表示字符串右对齐*/
        System.out.println();
        System.out.printf("输出一个浮点数: %f,一个字符串: %s,一个整数: %d", a, b, c);
        //可以输出多个变量，但一定要注意顺序不要漏掉逗号
        System.out.println();
        System.out.printf("字符串：%2$s,%3$d的十六进制数:%3$#x,双精度%1$1f的单精度浮点型表示:%1$f", a, b, c);
        //双精度的格式输出为数字1加f，"X$表示第几个变量，指的是这一行后面给出的变量的第几个。
    }
}
