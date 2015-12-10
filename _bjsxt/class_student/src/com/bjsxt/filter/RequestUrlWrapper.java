package com.bjsxt.filter;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
/**
 * RequestUrlWrapper.java
 * 功能：包装请求url
 * 类名: RequestUrlWrapper
 * ---------------------------------------------------
 * V1.0.1    bhz    初始版本
 */
public class RequestUrlWrapper extends HttpServletRequestWrapper {

    private String charSet = "UTF-8";

    public static final String REQUEST_URL_ATTRIBUTE_NAME = "javax.servlet.forward.request_url.framework";

    public RequestUrlWrapper(HttpServletRequest httpServletRequest) {
        super(httpServletRequest);
    }


    public RequestUrlWrapper(HttpServletRequest httpServletRequest, String charSet) {
        super(httpServletRequest);
        this.charSet = charSet;
    }


    public String getParameter(String name) {
        try {
            super.setCharacterEncoding(this.charSet);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        String value = super.getParameter(name);
        value = value == null ? null : convertCharSet(value);
        return value;
    }


    public String convertCharSet(String target) {
        try {
            if ((!isGBK(target)) || " ".equals(target)) {
                return new String(target.trim().getBytes("ISO-8859-1"), this.charSet);
            } else {
                return target;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return target;
        }
    }


    public static String returnURL(HttpServletRequest request) throws Exception {
        String url = request.getAttribute(REQUEST_URL_ATTRIBUTE_NAME).toString();
        if (url == null) {
            url = request.getRequestURL().toString();
        }
        return url == null ? "" : url;
    }

    public static boolean isGBK(String string)
            throws java.io.UnsupportedEncodingException {
        byte[] bytes = string.replace('?', 'a').getBytes("ISO-8859-1");
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 63) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对于gb2312来讲,首字节码位从0×81至0×FE，尾字节码位分别是0×40至0×FE
     *
     * @param str
     * @return
     */
    public static boolean isGB2312(String str) {
        char[] chars = str.toCharArray();
        boolean isGB2312 = false;
        for (int i = 0; i < chars.length; i++) {
            byte[] bytes = ("" + chars[i]).getBytes();
            if (bytes.length == 2) {
                int[] ints = new int[2];
                ints[0] = bytes[0] & 0xff;
                ints[1] = bytes[1] & 0xff;
                if (ints[0] >= 0x81 && ints[0] <= 0xFE && ints[1] >= 0x40
                        && ints[1] <= 0xFE) {
                    isGB2312 = true;
                    break;
                }
            }
        }
        return isGB2312;
    }
}
