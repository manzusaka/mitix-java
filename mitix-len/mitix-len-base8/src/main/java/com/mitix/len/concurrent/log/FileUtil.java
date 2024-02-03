package com.mitix.len.concurrent.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

/**
 * 
 * 创建于:2014-12-10<br>
 * 版权所有(C) 2014 深圳市银之杰科技股份有限公司<br>
 * 文件操作工具类,提供了文件或者目录的新建，删除，文件的读写，拷贝，剪切，文件比较等功能
 * 
 * @author honglvhang
 * @version 1.0.0.0
 */
public class FileUtil {
	/** Class文件扩展名 */
	public static final String CLASS_EXT = ".class";
	/** Jar文件扩展名 */
	public static final String JAR_FILE_EXT = ".jar";
	/** 在Jar中的路径jar的扩展名形式 */
	public static final String JAR_PATH_EXT = ".jar!";
	/** 当Path为文件形式时, path会加入一个表示文件的前缀 */
	public static final String PATH_FILE_PRE = "file:";

	/**
	 * 创建文件文件夹
	 * 
	 * @param fullFilePath
	 *            文件的全路径，使用POSIX风格
	 * @return 文件夹，若路径为null，返回null
	 * @throws IOException
	 *             IO异常
	 */
	public static File createFolder(String fullFilePath) throws IOException {
		if (fullFilePath == null) {
			return null;
		}
		File file = new File(fullFilePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		return file;
	}

	/**
	 * 创建文件，如果这个文件存在，直接返回这个文件
	 * 
	 * @param fullFilePath
	 *            文件的全路径，使用POSIX风格
	 * @return 文件，若路径为null，返回null
	 * @throws IOException
	 *             IO异常
	 */
	public static File createFile(String fullFilePath) throws IOException {
		if (fullFilePath == null) {
			return null;
		}
		File file = new File(fullFilePath);
		file.getParentFile().mkdirs();
		if (!file.exists()) {
			file.createNewFile();
		}
		return file;
	}

	/**
	 * 删除文件或者文件夹
	 * 
	 * @param fullFileOrDirPath
	 *            文件或者目录的路径
	 * @return 成功与否
	 * @throws IOException
	 *             IO异常
	 */
	public static boolean deleteFile(String fullFileOrDirPath)
			throws IOException {
		return deleteFile(new File(fullFileOrDirPath));
	}

	/**
	 * 删除文件或者文件夹
	 * 
	 * @param file
	 *            文件对象
	 * @return 成功与否
	 * @throws IOException
	 *             IO异常
	 */
	public static boolean deleteFile(File file) throws IOException {
		if (file == null || file.exists() == false) {
			return true;
		}

		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File childFile : files) {
				boolean isOk = deleteFile(childFile);
				if (isOk == false) {
					// 删除一个出错则本次删除任务失败
					return false;
				}
			}
		}
		return file.delete();
	}

	/**
	 * 复制文件<br>
	 * 如果目标文件为目录，则将源文件以相同文件名拷贝到目标目录
	 * 
	 * @param src
	 *            源文件
	 * @param dest
	 *            目标文件或目录
	 * @param isOverride
	 *            是否覆盖目标文件
	 * @throws IOException
	 *             IO异常
	 */
	public static void copy(File src, File dest, boolean isOverride)
			throws IOException {
		if (!src.exists()) {
			throw new FileNotFoundException("File not exist: " + src);
		}
		if (!src.isFile()) {
			throw new IOException("Not a file:" + src);
		}
		if (equals(src, dest)) {
			throw new IOException("Files '" + src + "' and '" + dest
					+ "' are equal");
		}
		if (dest.exists()) {
			if (dest.isDirectory()) {
				dest = new File(dest, src.getName());
			}
			if (dest.exists() && !isOverride) {
				throw new IOException("File already exist: " + dest);
			}
		}

		// do copy file
		FileInputStream input = new FileInputStream(src);
		FileOutputStream output = new FileOutputStream(dest);
		try {
			IOUtil.copy(input, output);
		} finally {
			IOUtil.closeQuietly(output);
			IOUtil.closeQuietly(input);
		}

		if (src.length() != dest.length()) {
			throw new IOException("Copy file failed of '" + src + "' to '"
					+ dest + "' due to different sizes");
		}
	}

	/**
	 * 移动文件或者目录
	 * 
	 * @param src
	 *            源文件或者目录
	 * @param dest
	 *            目标文件或者目录
	 * @param isOverride
	 *            是否覆盖目标
	 * @throws IOException
	 *             IO异常
	 */
	public static void move(File src, File dest, boolean isOverride)
			throws IOException {
		// check
		if (!src.exists()) {
			throw new FileNotFoundException("File already exist: " + src);
		}
		if (dest.exists()) {
			if (!isOverride) {
				throw new IOException("File already exist: " + dest);
			}
			dest.delete();
		}

		// 来源为文件夹，目标为文件
		if (src.isDirectory() && dest.isFile()) {
			throw new IOException("Can not move directory [" + src
					+ "] to file [" + dest + "]");
		}

		// 来源为文件，目标为文件夹
		if (src.isFile() && dest.isDirectory()) {
			dest = new File(dest, src.getName());
		}

		if (src.renameTo(dest) == false) {
			// 在文件系统不同的情况下，renameTo会失败，此时使用copy，然后删除原文件
			try {
				copy(src, dest, isOverride);
				src.delete();
			} catch (Exception e) {
				throw new IOException("Move [" + src + "] to [" + dest
						+ "] failed!");
			}

		}
	}

	/**
	 * 文件是否存在
	 * 
	 * @param path
	 *            文件路径
	 * @return 是否存在
	 */
	public static boolean isExist(String path) {
		return new File(path).exists();
	}

	/**
	 * 检查两个文件是否是同一个文件
	 * 
	 * @param file1
	 *            文件1
	 * @param file2
	 *            文件2
	 * @return 是否相同
	 */
	public static boolean equals(File file1, File file2) {
		try {
			file1 = file1.getCanonicalFile();
			file2 = file2.getCanonicalFile();
		} catch (IOException ignore) {
			return false;
		}
		return file1.equals(file2);
	}

	/**
	 * 从文件中读取每一行数据
	 * 
	 * @param path
	 *            文件路径
	 * @param charset
	 *            字符集,如果字符集为空，则用默认的编码格式进行读取
	 * @return 文件中的每行内容的集合List
	 * @throws IOException
	 *             IO异常
	 */
	public static List<String> readLines(String path, String charset)
			throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			return null;
		}
		if (!file.isFile()) {
			throw new RuntimeException("不是一个标准文件。。。");
		}
		InputStream in = new FileInputStream(file);
		if (charset == null) {
			return IOUtil.readLines(in);
		} else {
			return IOUtil.readLines(in, charset);
		}
	}

	/**
	 * 根据模式把集合写入到文本中
	 * 
	 * @param lines
	 *            集合
	 * @param fullFilePath
	 *            文本路径
	 * @param lineEnding
	 *            结束符，如果null则默认windows换行符为
	 * @param charset
	 *            字符集，如果为null则用默认字符集
	 * @param isAppend
	 *            写入方式isAppend=true追加isAppend=false覆盖
	 * @throws IOException
	 *             IO异常
	 */
	public static void writeLines(Collection<?> lines, String fullFilePath,
			String lineEnding, String charset, boolean isAppend)
			throws IOException {
		PrintWriter writer = null;
		if (charset == null) {
			writer = new PrintWriter(new OutputStreamWriter(
					new FileOutputStream(createFile(fullFilePath), isAppend)));
		} else {
			writer = new PrintWriter(new OutputStreamWriter(
					new FileOutputStream(createFile(fullFilePath), isAppend),
					charset));
		}
		IOUtil.writeLines(lines, writer, lineEnding);
		IOUtil.closeQuietly(writer);
	}

	/**
	 * 根据模式把集合写入到文本中,默认以一个新文件的形式写文件
	 * 
	 * @param lines
	 *            集合
	 * @param fullFilePath
	 *            文本路径
	 * @param lineEnding
	 *            结束符，如果null则默认windows换行符为
	 * @throws IOException
	 *             IO异常
	 */
	public static void writeLines(Collection<?> lines, String fullFilePath,
			String lineEnding) throws IOException {
		writeLines(lines, fullFilePath, lineEnding, null, false);
	}

	/**
	 * 写数据到文件中
	 * 
	 * @param data
	 *            数据
	 * @param fullFilePath
	 *            目标文件
	 * @throws IOException
	 *             IO异常
	 */
	public static void writeBytes(String fullFilePath, byte[] data)
			throws IOException {
		writeBytes(createFile(fullFilePath), data);
	}

	/**
	 * 写数据到文件中
	 * 
	 * @param dest
	 *            目标文件
	 * @param data
	 *            数据
	 * @throws IOException
	 *             IO异常
	 */
	public static void writeBytes(File dest, byte[] data) throws IOException {
		writeBytes(dest, data, 0, data.length, false);
	}

	/**
	 * 写入数据到文件
	 * 
	 * @param dest
	 *            目标文件
	 * @param data
	 *            数据
	 * @param off
	 *            数据中的起始偏移量
	 * @param len
	 *            要写入的字节数
	 * @param isAppend
	 *            写入方式isAppend=true追加isAppend=false覆盖
	 * @throws IOException
	 *             IO异常
	 */
	public static void writeBytes(File dest, byte[] data, int off, int len,
			boolean isAppend) throws IOException {
		if (dest.exists() == true) {
			if (dest.isFile() == false) {
				throw new IOException("不是一个标准文件dest=" + dest);
			}
		}
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(dest, isAppend);
			out.write(data, off, len);
		} finally {
			IOUtil.closeQuietly(out);
		}
	}

	/**
	 * 读取文件所有数据<br>
	 * 文件的长度不能超过Integer.MAX_VALUE
	 * 
	 * @param fullFilePath
	 *            文件路径
	 * @return 字节码
	 * @throws IOException
	 *             IO异常
	 */
	public static byte[] readBytes(String fullFilePath) throws IOException {
		return readBytes(createFile(fullFilePath));
	}

	/**
	 * 读取文件所有数据<br>
	 * 文件的长度不能超过Integer.MAX_VALUE
	 * 
	 * @param file
	 *            文件
	 * @return 字节码
	 * @throws IOException
	 *             IO异常
	 */
	public static byte[] readBytes(File file) throws IOException {
		// check
		if (!file.exists()) {
			throw new FileNotFoundException("文件不存在file=" + file);
		}
		if (!file.isFile()) {
			throw new IOException("不是一个标准文件file=" + file);
		}

		long len = file.length();
		if (len >= Integer.MAX_VALUE) {
			throw new IOException("文件过大，比int类型的最大长度都大。。。");
		}

		byte[] bytes = new byte[(int) len];
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			in.read(bytes);
		} finally {
			IOUtil.closeQuietly(in);
		}
		return bytes;
	}

	/**
	 * 将流的内容写入文件<br>
	 * 
	 * @param dest
	 *            目标文件
	 * @param in
	 *            输入流
	 * @throws IOException
	 *             IO异常
	 */
	public static void writeStream(File dest, InputStream in)
			throws IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(dest);
			IOUtil.copy(in, out);
		} finally {
			IOUtil.closeQuietly(out);
		}
	}

	/**
	 * 将流的内容写入文件<br>
	 * 
	 * @param fullFilePath
	 *            文件绝对路径
	 * @param in
	 *            输入流
	 * @throws IOException
	 *             IO异常
	 */
	public static void writeStream(String fullFilePath, InputStream in)
			throws IOException {
		writeStream(createFile(fullFilePath), in);
	}

	/**
	 * File参数校验工具，判断是否是一个可以操作的文件
	 * 
	 * @param file
	 *            文件
	 * @return 是否是可操作文件
	 */
	public static boolean isrwFile(File file) {
		if (file == null) {
			throw new NullPointerException("File值为空 !");
		}
		if (file.exists() == false) {
			throw new RuntimeException("Xml文件不存在!");
		}
		if (file.isFile() == false) {
			throw new RuntimeException("File不是一个标准文件!");
		}
		return true;
	}
}
