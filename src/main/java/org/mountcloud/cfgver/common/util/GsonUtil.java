package org.mountcloud.cfgver.common.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * TODO: Gson工具
 * 2018/5/30.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public class GsonUtil {
    private static Gson gson = null;
    private static Gson formatGson = null;
    static {
        if (gson == null) {
            gson =  new GsonBuilder()
            		.setDateFormat("yyyy-MM-dd hh:mm:ss")
                    .serializeNulls()
                    .create();
        }
        
        if (formatGson == null) {
        	formatGson =  new GsonBuilder()
        			.setDateFormat("yyyy-MM-dd hh:mm:ss")
                    .setPrettyPrinting()
                    .create();
        }
    }

    private GsonUtil() {
    }

    /**
     * 转成json
     *
     * @param object 类
     * @return json
     */
    public static String GsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
        	try {
            gsonString = gson.toJson(object);
        	}catch(Exception e) {
        		
        	}
        }
        return gsonString;
    }
    /**
     * 格式化转成json
     *
     * @param object 类
     * @return json
     */
    public static String GsonStringFormate(Object object) {
        String gsonString = null;
        if (formatGson != null) {
        	try {
            gsonString = formatGson.toJson(object);
        	}catch(Exception e) {
        		
        	}
        }
        return gsonString;
    }
    /**
     * 转成bean
     *
     * @param gsonString json
     * @param cls classT
     * @param <T> 类型
     * @return T
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * 转成list
     *
     * @param gsonString json
     * @param cls classT
     * @param <T> 类型
     * @return 结果
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 转成list中有map的
     *
     * @param <T> 类型
     * @param gsonString json
     * @return 结果
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * 转成map的
     *
     * @param <T> 类型
     * @param gsonString json
     * @return 结果
     */
    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
}
