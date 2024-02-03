/*
 * Copyright (c) 2010
 * 
 * @date 2016
 * 
 * @author oldflame-Jm
 * 
 * Apache License Version 2.0 http://www.apache.org/licenses/LICENSE-2.0
 */
package com.mitix.len.concurrent.log;

import java.io.UnsupportedEncodingException;

/**
 * 
 * @version 1.0.0
 * @author oldflame-Jm 提供字符串处理的常用方法
 */
public class StringUtil {
  public static final String SPACE = " ";
  public static final String EMPTY = "";
  public static final String LF = "\n";
  public static final String CR = "\r";
  public static final String LINE_SEPARATOR_UNIX = "\n";
  public static final String LINE_SEPARATOR_MAC = "\r";
  public static final String LINE_SEPARATOR_WINDOWS = "\r\n";

  public static final int INDEX_NOT_FOUND = -1;
  private static final int PAD_LIMIT = 8192;

  public static final String CURRENT_PATH = ".";
  public static final String TOP_PATH = "..";
  


  /**
   * 
   */
  private static final char EXTENSION_SEPARATOR = '.';

  /**
   * unix linux文件分隔符,斜杠字符"/"
   */
  public static final char FOLDER_SEPARATOR = '/';
  /**
   * windows文件分隔符,双反斜杠字符"\\"
   */
  public static final char DIR_SEPARATOR_WINDOWS = '\\';

  /**
   * html占位符"&nbsp;"
   */
  public static final String HTML_NBSP = "&nbsp;";
  /**
   * html符号'"'
   */
  public static final String HTML_AMP = "&amp";
  /**
   * html符号'"'
   */
  public static final String HTML_QUOTE = "&quot;";
/**
     * html符号'<'
     */
  public static final String HTML_LT = "&lt;";
  /**
   * html符号'>'
   */
  public static final String HTML_GT = "&gt;";

  /**
   * <pre class="code">
   * StringUtils.isEmpty(null) = true
   * StringUtils.isEmpty("") = true
   * StringUtils.isEmpty(" ") = false
   * StringUtils.isEmpty("12345") = false
   * </pre>
   * 
   * @param cs the CharSequence to check (may be {@code null})
   * @return {@code true} if the CharSequence is null or hasn't length
   */
  public static boolean isEmpty(CharSequence cs) {
    return (cs == null) || (cs.length() == 0);
  }

  /**
   * <pre class="code">
   * this is {@code !isEmpty(CharSequence)}
   * </pre>
   * 
   * @param cs the CharSequence to check (may be {@code null})
   * @return {@code true} if the CharSequence is not null and has length
   * @see #isEmpty(CharSequence)
   */
  public static boolean isNotEmpty(CharSequence cs) {
    return !isEmpty(cs);
  }

  /**
   * <pre class="code">
   * StringUtils.isBlank(null) = true
   * StringUtils.isBlank("") = true
   * StringUtils.isBlank(" ") = true
   * StringUtils.isBlank("12345") = false
   * StringUtils.hasText(" 12345 ") = false
   * </pre>
   * 
   * @param cs the CharSequence to check (may be {@code null})
   * @return {@code true} if the CharSequence is null or contain whitespace only
   */
  public static boolean isBlank(CharSequence cs) {
    int strLen;
    if ((cs == null) || ((strLen = cs.length()) == 0)) {
      return true;
    }
    for (int i = 0; i < strLen; ++i) {
      if (!Character.isWhitespace(cs.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  /**
   * <pre class="code">
   * this is {@code !isBlank(CharSequence)}
   * </pre>
   * 
   * @param cs the CharSequence to check (may be {@code null})
   * @return {@code true} if the CharSequence is not {@code null},
   * its length is greater than 0, and it does not contain whitespace only
   * @see #isBlank(CharSequence)
   */
  public static boolean isNotBlank(CharSequence cs) {
    return !isBlank(cs);
  }
  
  /**
   * trim string
   * 
   * @param str
   * @return default trim if str=null then return null
   */
  public static String trim(String str) {
    return trim(str, null);
  }

  /**
   * trim string
   * 
   * @param str
   * @param defaultValue
   * @return if str=null then defaultValue
   */
  public static String trim(String str, String defaultValue) {
    return (null == str) ? defaultValue : str.trim();
  }

  /**
   * trim string
   * 
   * @param str
   * @return if trim(str) isEmpty then null
   */
  public static String trimToNull(String str) {
    String ts = trim(str);
    return (isEmpty(ts)) ? null : ts;
  }

  /**
   * trim string
   * 
   * @param str
   * @return if str=null then ""
   */
  public static String trimToEmpty(String str) {
    return (str == null) ? "" : str.trim();
  }

  /**
   * 大写首字母 例如：str = name, return Name
   * 
   * @param str 字符串
   * @return 字符串
   */
  public static String upperFirst(String str) {
    return Character.toUpperCase(str.charAt(0)) + str.substring(1);
  }

  /**
   * 小写首字母 例如：str = Name, return name
   * 
   * @param str 字符串
   * @return 字符串
   */
  public static String lowerFirst(String str) {
    return Character.toLowerCase(str.charAt(0)) + str.substring(1);
  }

  /**
   * 清理空白字符
   * 
   * @param str 被清理的字符串
   * @return 清理后的字符串
   */
  public static String cleanBlank(String str) {
    if (str == null) {
      return null;
    }
    return str.replaceAll("\\s*", EMPTY);
  }

  /**
   * 编码字符串
   * 
   * @param str 字符串
   * @param charset 字符集
   * @return 编码后的字节码
   */
  public static byte[] encode(String str, String charset) {
    if (str == null) {
      return null;
    }
    try {
      return str.getBytes(charset);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("Charset [{" + charset + "}] unsupported!");
    }
  }

  /**
   * 解码字节码
   * 
   * @param data 字符串
   * @param charset 字符集
   * @return 解码后的字符串
   * @throws UnsupportedEncodingException 异常
   * 
   */
  public static String decode(byte[] data, String charset) throws UnsupportedEncodingException {
    if (data == null) {
      return null;
    }
    return new String(data, charset);
  }

  /**
   * 全角字符转半角字符
   * 
   * @param str 字符串
   * @return 半角字符串
   */
  public static String getDBC(String str) {
    char c[] = str.toCharArray();
    for (int i = 0; i < c.length; i++) {
      if (c[i] == '\u3000') {
        c[i] = ' ';
      } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
        c[i] = (char) (c[i] - 65248);

      }
    }
    String returnString = new String(c);
    return returnString;
  }

  /**
   * 半角转全角
   * 
   * @param str 字符串
   * @return 全角字符串
   */
  public static String getSBC(String str) {
    char c[] = str.toCharArray();
    for (int i = 0; i < c.length; i++) {
      if (c[i] == ' ') {
        c[i] = '\u3000';
      } else if (c[i] < '\177') {
        c[i] = (char) (c[i] + 65248);

      }
    }
    return new String(c);
  }

}
