package org.mountcloud.cfgver.common.util;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author zhanghaishan
 * @version V1.0
 * TODO get很多参数拼接字符串太累，这个类方便get字符串的拼接，面对11个参数要拼接的时候已经无法忍受了，使用此工具可以生成httpget的参数
 * 2018/3/21.
 */
@SuppressWarnings("serial")
public class HttpParam extends LinkedHashMap<String,Object>{

    /**
     * url encode开关，默认开
     */
    private boolean urlEncodeSwitch = true;


    /**
     * 添加一个字符串类型的变量
     * @param key key
     * @param value 值
     * @return HttpParam
     */
    public HttpParam add(String key,Object value) {
        this.put(key, value);
        return this;
    }

    /**
     * 添加一个字符串类型的变量
     * @param key key
     * @param value 值
     * @return HttpParam
     */
    public HttpParam addInteger(String key,Integer value) {
        this.put(key, StringUtil.toString(value));
        return this;
    }

    /**
     * 返回get需要拼接的字符串
     * @return httpGet params string
     */
    public String toParamString(){
        boolean firstParam = true;
        StringBuffer paramStringBuffer = new StringBuffer("");

        Set<String> keys = this.keySet();

        for(String key : keys){

            if(this.get(key)==null){
                continue;
            }

            String val = this.get(key).toString();
            if(!StringUtil.isEmpty(val)){

                //不是第一个参数前加连接符
                if(!firstParam){
                    paramStringBuffer.append("&");
                }else{
                    //是第一个参数的话就标记以后都不是第一个参数
                    firstParam = false;
                }
                //get需要urlencode

                String tempVal = val;
                if(urlEncodeSwitch){
                    tempVal= urlEncode(val);
                }
                //拼接字符串
                paramStringBuffer.append(key);
                paramStringBuffer.append("=");
                paramStringBuffer.append(tempVal);
            }
        }

        return paramStringBuffer.toString();
    }

    /**
     * url需要转义
     */
    public void urlEncode(){
        urlEncodeSwitch = true;
    }

    /**
     * url不需要转义
     */
    public void urlNotEncode(){
        urlEncodeSwitch =false;
    }

    @Override
    public String toString() {
        String json = GsonUtil.GsonString(this);
        return json;
    }
    
    /**
     * 内容URL转码
     * @param content 转码内容
     * @return  转码结果
     */
    public static String urlEncode(String content){
        String resutl = content;
        try {
            resutl = URLEncoder.encode(content,"UTF-8");
            resutl =resutl.replaceAll("\\+",  "%20");
        } catch (UnsupportedEncodingException e) {
        	e.printStackTrace();
        }
        return resutl;
    }
}
