package org.mountcloud.springproject.common.util;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: Map工具
 * 2019/4/10.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public class MapUtil {

    /**
     * 封装一下方便map取值
     * @param map map
     * @param attrStr 例如 data.user.name 取map中的data中的user中的name
     * @return result
     */
    public static Object getVal(Map<String,Object> map, String attrStr){
    	if(map==null) {
    		return null;
    	}
        String[] attrs = attrStr.split("\\.");
        String attr = attrs[0];
        Object val = map.get(attr);
        if(val == null || attrs.length==1){
            return val;
        }
        @SuppressWarnings("unchecked")
		Map<String,Object> resultData = (Map<String, Object>) val;

        String newAttrStr = attrStr.substring(attrStr.indexOf(".")+1);
        return getVal(resultData,newAttrStr);
    }
    
    /**
     * 对象转map
     * @param obj 对象
     * @param index 属性深度，防止无限递归
     * @return result
     * @throws IllegalAccessException ex
     * @throws IllegalArgumentException  ex
     */
    public static Map<String,Object> objToMap(Object obj,int index) throws IllegalArgumentException, IllegalAccessException{
    	Map<String,Object> result = new HashMap<String, Object>();
    	
    	List<Field> fields = new ArrayList<Field>();
    	ObjectUtil.getFields(obj.getClass(), fields, index);
    	
    	for(int i=0;i<fields.size();i++) {
    		Field field = fields.get(i);
    		Object value = ObjectUtil.getFieldsValue(field, obj);
    		result.put(field.getName(), value);
    	}
    	return result;
    }

	/**
	 * 对象转map
	 * @param obj 对象
	 * @return map
	 */
	public static Map<String,Object> toMap(Object obj){
    	if(obj==null) {
    		return null;
    	}
    	if(obj instanceof Map) {
    		return (Map<String, Object>) obj;
    	}
    	return null;
    }
}
