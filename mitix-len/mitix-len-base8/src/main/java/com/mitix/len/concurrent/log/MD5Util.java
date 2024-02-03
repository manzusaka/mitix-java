package com.mitix.len.concurrent.log;


import java.security.MessageDigest;

/**
 *
 *
 */
public class MD5Util {

    /**
     * 密码算法
     *
     * @param sourceStr
     * @return
     */
    public static String getsSecurityCdode(String sourceStr) {
        if (isBlank(sourceStr)) {
            throw new RuntimeException("设备号不能为空");
        }
        String origin = getStrMD5(sourceStr.toUpperCase().trim());
        StringBuilder sb = new StringBuilder(origin.length());
        for (int i = 0; i < origin.length(); i++) {
            if (Character.isDigit(origin.charAt(i))) {
                sb.append(origin.charAt(i));
            }
        }
        if (sb.length() > 8) {
            return sb.substring(0, 8);
        }
        return sb.toString();
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
     * 获取字符串的MD5值
     *
     * @param sourceStr 字符串
     * @return 字符串MD5码
     */
    public static String getStrMD5(String sourceStr) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(sourceStr.getBytes());
            byte hash[] = digest.digest();
            StringBuffer result = new StringBuffer(hash.length * 2);
            for (int i = 0; i < hash.length; i++) {
                if (((int) hash[i] & 0xff) < 0x10) {
                    result.append("0");
                }
                result.append(Long.toString((int) hash[i] & 0xff, 16));
            }
            return result.toString();
        } catch (Exception e) {
            throw new RuntimeException("MD5加密异常", e);
        }
    }


    public static void main(String[] args) {
        System.out.println(MD5Util.getStrMD5("abc"));
        System.out.println(MD5Util.getStrMD5("abc\n"));
    }
}
