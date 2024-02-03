package com.mitix.len.concurrent.log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 创建于:2014-12-10<br>
 * 版权所有(C) 2014 深圳市银之杰科技股份有限公司<br>
 * IO操作
 *
 * @author honglvhang
 * @version 1.0.0.0
 */
public class IOUtil {
    // /**
    // * java文件分隔符常量
    // */
    // public static final char DIR_SEPARATOR = File.separatorChar;
    /**
     * 读写操作的缓存大小
     */
    private static final int BUFFERSIZEDEF = 4096;

    /**
     * 将InputStream复制到OutputStream中 使用默认Buffer大小
     *
     * @param input  输入字节流
     * @param output 输出字节流
     * @return 返回拷贝的字节流的长度
     * @throws IOException IO异常
     */
    public static int copy(InputStream input, OutputStream output)
            throws IOException {
        long count = copyLarge(input, output, BUFFERSIZEDEF);
        if (count > 2147483647L) {
            return -1;
        }
        return (int) count;
    }

    /**
     * 将Reader中的内容复制到Writer中 使用默认Buffer大小
     *
     * @param readerinput  读入字符流
     * @param writeroutput 写字符流
     * @return 返回拷贝的字符流的长度
     * @throws IOException IO异常
     */
    public static int copy(Reader readerinput, Writer writeroutput)
            throws IOException {
        long count = copyLarge(readerinput, writeroutput, BUFFERSIZEDEF);
        if (count > 2147483647L) {
            return -1;
        }
        return (int) count;
    }

    /**
     * 将输入流InputStream复制到Writer中，使用默认编码格式 使用默认Buffer大小
     *
     * @param input        输入字节流
     * @param writeroutput 写字符流
     * @throws IOException IO异常
     */
    public static void copy(InputStream input, Writer writeroutput)
            throws IOException {
        InputStreamReader in = new InputStreamReader(input);
        copy(in, writeroutput);
    }

    /**
     * 将InputStream以指定的编码格式读入到Writer中 使用默认Buffer大小
     *
     * @param input        输入字节流
     * @param writeroutput 写字符流
     * @param encoding     编码格式
     * @throws IOException IO异常
     */
    public static void copy(InputStream input, Writer writeroutput,
                            String encoding) throws IOException {
        if (encoding == null) {
            copy(input, writeroutput);
        } else {
            InputStreamReader in = new InputStreamReader(input, encoding);
            copy(in, writeroutput);
        }
    }

    /**
     * 将Reader复制到OutputStream中 使用默认Buffer大小
     *
     * @param readerinput 读入字符流
     * @param output      输出字节流
     * @throws IOException IO异常
     */
    public static void copy(Reader readerinput, OutputStream output)
            throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(output);
        copy(readerinput, out);
        out.flush();
    }

    /**
     * 将Reader读入，以指定的编码输出到OutputStream 使用默认Buffer大小 码
     *
     * @param readerinput 读入字符流
     * @param output      输出字节流
     * @param encoding    编码格式
     * @throws IOException IO异常
     */
    public static void copy(Reader readerinput, OutputStream output,
                            String encoding) throws IOException {
        if (encoding == null) {
            copy(readerinput, output);
        } else {
            OutputStreamWriter out = new OutputStreamWriter(output, encoding);
            copy(readerinput, out);
            out.flush();
        }
    }

    /**
     * 将Reader中的内容复制到Writer中 使用指定的缓存大小
     *
     * @param readerinput  读入字符流
     * @param writeroutput 写字符流
     * @param buffersize   缓存大小
     * @return 返回拷贝的字符流长度
     * @throws IOException IO异常
     */
    public static long copyLarge(Reader readerinput, Writer writeroutput,
                                 int buffersize) throws IOException {
        char[] buffer = new char[buffersize];
        long count = 0L;
        int n = 0;
        while (-1 != (n = readerinput.read(buffer))) {
            writeroutput.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    /**
     * 将InputStream复制到OutputStream中 使用指定的缓存大小
     *
     * @param input      输入字节流
     * @param output     输出字节流
     * @param buffersize 缓存大小
     * @return 返回拷贝的字节流长度
     * @throws IOException IO异常
     */
    public static long copyLarge(InputStream input, OutputStream output,
                                 int buffersize) throws IOException {
        byte[] buffer = new byte[buffersize];
        long count = 0L;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    /**
     * 把InputStream字节流转换成char[]
     *
     * @param input 输入字节流
     * @return char数组
     * @throws IOException IO异常
     */
    public static char[] toCharArray(InputStream input) throws IOException {
        CharArrayWriter output = new CharArrayWriter();
        copy(input, output);
        return output.toCharArray();
    }

    /**
     * 把InputStream字节流转换成char[],指定读入的编码格式
     *
     * @param input    输入字节流
     * @param encoding 编码格式
     * @return char数组
     * @throws IOException IO异常
     */
    public static char[] toCharArray(InputStream input, String encoding)
            throws IOException {
        CharArrayWriter output = new CharArrayWriter();
        copy(input, output, encoding);
        return output.toCharArray();
    }

    /**
     * 把Reader字节流转换成char[]
     *
     * @param readerinput 读入字符流
     * @return char数组
     * @throws IOException IO异常
     */
    public static char[] toCharArray(Reader readerinput) throws IOException {
        CharArrayWriter sw = new CharArrayWriter();
        copy(readerinput, sw);
        return sw.toCharArray();
    }

    /**
     * 从InputStream中读取每一行数据，返回集合 默认编码格式
     *
     * @param input 输入字节流
     * @return 返回读入字符串集合（List）
     * @throws IOException IO异常
     */
    public static List<String> readLines(InputStream input) throws IOException {
        InputStreamReader reader = new InputStreamReader(input);
        return readLines(reader);
    }

    /**
     * 从InputStream中读取每一行数据，返回集合 如果编码格式为null,则使用默认编码格式
     *
     * @param input    输入字节流
     * @param encoding 编码格式
     * @return 返回读入字符串集合（List）
     * @throws IOException IO异常
     */
    public static List<String> readLines(InputStream input, String encoding)
            throws IOException {
        if (encoding == null) {
            return readLines(input);
        }
        InputStreamReader reader = new InputStreamReader(input, encoding);
        return readLines(reader);
    }

    /**
     * 从Reader中读取每一行数据，返回集合
     *
     * @param readerinput 读入字符流
     * @return 返回读入字符串集合（List）
     * @throws IOException IO异常
     */
    public static List<String> readLines(Reader readerinput) throws IOException {
        BufferedReader reader = new BufferedReader(readerinput);
        List<String> list = new ArrayList<String>();
        String line = reader.readLine();
        while (line != null) {
            list.add(line);
            line = reader.readLine();
        }
        return list;
    }

    /**
     * 将集合输入写入OutputStream
     *
     * @param lines      数据集合
     * @param output     输出字节流
     * @param lineEnding 换行符可以直接获取IOUtil常量获得，如果为null则默认为WINDOWS换行符
     * @throws IOException IO异常
     */
    @SuppressWarnings("rawtypes")
    public static void writeLines(Collection<?> lines, OutputStream output,
                                  String lineEnding) throws IOException {
        if (lines == null) {
            return;
        }
        if (lineEnding == null) {
            lineEnding = StringUtil.LINE_SEPARATOR_WINDOWS;
        }
        for (Iterator i = lines.iterator(); i.hasNext(); ) {
            Object line = i.next();
            if (line != null) {
                output.write(line.toString().getBytes());
            }
            output.write(lineEnding.getBytes());
        }
    }

    /**
     * 将集合输入写入OutputStream,指定编码格式
     *
     * @param lines      集合数据
     * @param output     输出字节流
     * @param encoding   编码格式，可以在CharsetUtil中获取编码个是
     * @param lineEnding 换行符可以直接获取IOUtil常量获得，如果为null则默认为WINDOWS换行符
     * @throws IOException IO异常
     */
    @SuppressWarnings("rawtypes")
    public static void writeLines(Collection<?> lines, OutputStream output,
                                  String encoding, String lineEnding) throws IOException {
        if (encoding == null) {
            writeLines(lines, output, lineEnding);
        } else {
            if (lines == null) {
                return;
            }
            if (lineEnding == null) {
                lineEnding = StringUtil.LINE_SEPARATOR_WINDOWS;
            }
            for (Iterator i = lines.iterator(); i.hasNext(); ) {
                Object line = i.next();
                if (line != null) {
                    output.write(line.toString().getBytes(encoding));
                }
                output.write(lineEnding.getBytes(encoding));
            }

        }
    }

    /**
     * 将集合输入写入Writer,指定编码格式
     *
     * @param lines      数据集合
     * @param writer     写入字符流
     * @param lineEnding 换行符可以直接获取IOUtil常量获得，如果为null则默认为WINDOWS换行符
     * @throws IOException IO异常
     */
    @SuppressWarnings("rawtypes")
    public static void writeLines(Collection<?> lines, Writer writer,
                                  String lineEnding) throws IOException {
        if (lines == null) {
            return;
        }
        if (lineEnding == null) {
            lineEnding = StringUtil.LINE_SEPARATOR_WINDOWS;
        }
        for (Iterator i = lines.iterator(); i.hasNext(); ) {
            Object line = i.next();
            if (line != null) {
                writer.write(line.toString());
            }
            writer.write(lineEnding);
        }

    }

    /**
     * 比较两个输入流是否相同
     *
     * @param input1 输入字节流1
     * @param input2 输入字节流2
     * @return 返回比较结果--true相等
     * @throws IOException IO异常
     */
    public static boolean contentEquals(InputStream input1, InputStream input2)
            throws IOException {
        if (!(input1 instanceof BufferedInputStream)) {
            input1 = new BufferedInputStream(input1);
        }
        if (!(input2 instanceof BufferedInputStream)) {
            input2 = new BufferedInputStream(input2);
        }

        int ch = input1.read();
        while (-1 != ch) {
            int ch2 = input2.read();
            if (ch != ch2) {
                return false;
            }
            ch = input1.read();
        }

        int ch2 = input2.read();
        return ch2 == -1;
    }

    /**
     * 比较两个Reader是否相同
     *
     * @param readerinput1 读入字符流
     * @param readerinput2 写字符流
     * @return 返回比较结果--true相等
     * @throws IOException IO异常
     */
    public static boolean contentEquals(Reader readerinput1, Reader readerinput2)
            throws IOException {
        if (!(readerinput1 instanceof BufferedReader)) {
            readerinput1 = new BufferedReader(readerinput1);
        }
        if (!(readerinput2 instanceof BufferedReader)) {
            readerinput2 = new BufferedReader(readerinput2);
        }

        int ch = readerinput1.read();
        while (-1 != ch) {
            int ch2 = readerinput2.read();
            if (ch != ch2) {
                return false;
            }
            ch = readerinput1.read();
        }

        int ch2 = readerinput2.read();
        return ch2 == -1;
    }

    /**
     * 判断输入字节流可以跳过多少个字节，如果toSkip大于整个文件大小则返回文件大小 <br>
     * 用于InputStream的skip方法做预先判断
     *
     * @param input  输入字节流
     * @param toSkip 跳跃长度
     * @return 返回实际可跳跃长度
     * @throws IOException IO异常
     */
    public static long skip(InputStream input, long toSkip) throws IOException {
        if (toSkip < 0L) {
            throw new IllegalArgumentException(
                    "Skip count must be non-negative, actual: " + toSkip);
        }
        byte[] skipByteBuffer = new byte[2048];
        long remain = toSkip;
        while (remain > 0L) {
            long n = input.read(skipByteBuffer, 0,
                    (int) Math.min(remain, 2048L));
            if (n < 0L) {
                break;
            }
            remain -= n;
        }
        return toSkip - remain;
    }

    /**
     * 判断输入字符流可以跳过多少个字节，如果toSkip大于整个文件大小则返回文件大小 <br>
     * 用于Reader的skip方法做预先判断
     *
     * @param readerinput 输入字符流
     * @param toSkip      跳跃长度
     * @return 返回实际可跳跃长度
     * @throws IOException IO异常
     */
    public static long skip(Reader readerinput, long toSkip) throws IOException {
        if (toSkip < 0L) {
            throw new IllegalArgumentException(
                    "Skip count must be non-negative, actual: " + toSkip);
        }

        char[] skipCharBuffer = new char[2048];
        long remain = toSkip;
        while (remain > 0L) {
            long n = readerinput.read(skipCharBuffer, 0,
                    (int) Math.min(remain, 2048L));
            if (n < 0L) {
                break;
            }
            remain -= n;
        }
        return toSkip - remain;
    }

    /**
     * 关闭IO流,可用于实现Closeable接口实现类的关闭动作,例如FileInputStream, FileOutputStream<br>
     * FileReader, FileWriter等等
     *
     * @param closeable
     */
    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * 关闭Socket
     *
     * @param sock
     */
    public static void closeQuietly(Socket sock) {
        if (sock == null) {
            return;
        }
        try {
            sock.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
