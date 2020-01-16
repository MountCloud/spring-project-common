package org.mountcloud.cfgver.common.util;


import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhanghaishan
 * @version V1.0
 * TODO: 字符串工具集
 * 2018/1/18.
 */
public class StringUtil extends StringUtils{

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 转Interger
     * @param obj obj
     * @return result
     */
    public static Integer toInteger(Object obj){
        if(obj == null){
            return null;
        }
        return Integer.parseInt(obj.toString());
    }

    /**
     * 转Float
     * @param obj obj
     * @return result
     */
    public static Float toFloat(Object obj){
        if(obj == null){
            return null;
        }
        return Float.parseFloat(obj.toString());
    }

    /**
     * 转double
     * @param obj obj
     * @return result
     */
    public static Double toDouble(Object obj){
        if(obj == null){
            return null;
        }
        return Double.parseDouble(obj.toString());
    }

    /**
     * 装Long
     * @param obj obj
     * @return result
     */
    public static Long toLong(Object obj){
        if(obj == null){
            return null;
        }
        return Long.parseLong(obj.toString());
    }

    /**
     * 转Boolean
     * @param obj obj
     * @return result
     */
    public static Boolean toBoolean(Object obj){
        if(obj == null){
            return null;
        }
        return Boolean.parseBoolean(obj.toString());
    }

    /**
     * 转String
     * @param obj obj
     * @return result
     */
    public static String toString(Object obj){
        if(obj == null){
            return null;
        }
        return obj.toString();
    }

    /**
     * 格式化时间
     * @param date 时间
     * @return result
     */
    public static String dataToDate(Date date){
        return sdf.format(date);
    }

    /**
     * 根据map替换
     * @param str 替换map的字符串
     * @param map map
     * @return result
     */
    public static String replaceByMap(String str,Map<String,String> map){
        if(map!=null){
            Set<String> keys = map.keySet();
            for(String key : keys){
                String val = map.get(key);
                str = str.replaceAll(key,val);
            }
        }
        return str;
    }

    /**
     * 提取字符串里的数字
     * @param str string
     * @return number result
     */
    public static String findNumber(String str){
        String regEx="[^0-9]";
        String newStr = findString(str,regEx);
        return newStr;
    }

    /**
     * 根据正则提取字符串
     * @param str 字符串
     * @param regEx  正则
     * @return result
     */
    public static String findString(String str,String regEx){
        if(str==null){
            return null;
        }
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String newStr =  m.replaceAll("").trim();
        return newStr;
    }

    /**
     * 根据需要复制的字符串长度进行复制拼接字符串
     * @param str 字符串
     * @param cloneNum 需要拼接的次数
     * @return result
     */
    public static String cloneAndAppend(String str,int cloneNum){
        String newStr = str;
        for(int i=0;i<cloneNum;i++){
            newStr = newStr + newStr;
        }
        return newStr;
    }

    /**
     * 查询字符串
     * @param regex 正则
     * @param str 字符串
     * @return result
     */
    public static List<String> findStringsByRegs(String regex, String str){
        List<String> strs = new ArrayList<>();
        Pattern r = Pattern.compile(regex);
        Matcher ma = r.matcher(str);
        while (ma.find()){
            String findStr = ma.group(0);
            if(findStr!=null&&findStr.length()>0){
                strs.add(findStr);
            }
        }
        return strs;
    }

    /**
     * 查询字符串
     * @param regex 正则
     * @param str 字符串
     * @return result
     */
    public static String findStringsByRegsOne(String regex, String str){
        List<String> strs = findStringsByRegs(regex,str);
        String result = strs.size()==0? null : strs.get(0);
        return result;
    }
    
    /**
     * 查找正则数组
     * @param regex 正则
     * @param str 字符串
     * @return 查找结果
     */
    public static List<String> findGroups(String regex,String str){
    	List<String> strs = new ArrayList<String>();
    	Pattern r = Pattern.compile(regex);
        Matcher ma = r.matcher(str);
        if(ma.find()) {
        	int groupCount = ma.groupCount()+1;
        	if(groupCount>1) {
        		for(int i=1;i<groupCount;i++) {
        			String tempStr = ma.group(i);
        			strs.add(tempStr);
        		}
        	}
        }
        return strs;
    }

    /**
     * bytes转字符串
     * @param bytes bytes
     * @param charset charset
     * @return result
     */
    public static String byteToString(byte[] bytes,String charset) {
    	String str = null;
    	try {
			str = new String(bytes,charset);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return str;
    }

    /**
     * bytes转字符串
     * @param bytes bytes
     * @return 结果
     */
    public static String byteToString(byte[] bytes) {
    	return byteToString(bytes, "UTF-8");
    }
}
