package com.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StrMD5 {
	public final static Logger log = LoggerFactory.getLogger(StrMD5.class);
	public static final int MD532=32;
	public static final int MD516=16;
	/**
	 * 返回MD5加密
	 * @param sourceStr
	 * @param MDleng
	 * @return
	 */
	public static String MD5(String sourceStr,int MDleng) {
	        String result = "";
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(sourceStr.getBytes());
	            byte b[] = md.digest();
	            int i;
	            StringBuffer buf = new StringBuffer("");
	            for (int offset = 0; offset < b.length; offset++) {
	                i = b[offset];
	                if (i < 0)
	                    i += 256;
	                if (i < 16)
	                    buf.append("0");
	                buf.append(Integer.toHexString(i));
	            }
	            result = buf.toString();
	            if(StrMD5.MD516==MDleng){
	            	result=buf.toString().substring(8, 24);
	            }
	        } catch (NoSuchAlgorithmException e) {
	        	log.error(e.getMessage(),e);
	        }
	        return result;
	    }
}
