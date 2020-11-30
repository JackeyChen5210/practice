package org.example.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

public class StringUtil {


    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean hasOneNullOrEmpty(String... strs) {
        for (String v : strs) {
            if (isNullOrEmpty(v)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNullOrEmpty(String... ss) {
        for (String s : ss) {
            if (isNotEmpty(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEmpty(String... ss) {
        for (String s : ss) {
            if (isNullOrEmpty(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }


    public static void toEmptyStringWhenNull(Object o) {
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            try {
                if (declaredField.get(o) == null) {
                    declaredField.set(o, "");
                }
            } catch (Exception e) {
                break;
            }
        }
    }

    public static String sub(String orgString) {
        if (orgString == null) {
            return null;
        }
        int i = orgString.indexOf(".");
        if (i != -1 && (orgString.length() - i) > 2) {
            return orgString.substring(0, i + 3);
        }
        return orgString;
    }

    public static String lowerFirstCharacter(String simpleName) {
        if (simpleName == null || "".equals(simpleName)) {
            return simpleName;
        }
        return simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);
    }

    public static boolean containsAny(String str, String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            if (str.contains(strs[i])) {
                return true;
            }
        }
        return false;
    }

    public static String returnEmptyIfNull(String content) {
        return content == null ? "" : content;
    }

    public static String urlEncoding(String content) {
        String encodedContent = null;
        try {
            encodedContent = URLEncoder.encode(content, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodedContent;
    }
}
