package org.mountcloud.springproject.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanghaishan
 * @version 创建时间：2019/3/3 14:38
 * TODO: 日志工具
 */
public class LoggerUtil {
    /**
     * 日志集合
     */
    private static Map<Class<?>,LoggerBean> loggerMap = new HashMap<>();

    /**
     * 提供日志
     * @param cls 类
     * @return 日志
     */
    public static LoggerBean getLogger(Class<?> cls){
        LoggerBean loggerBean = loggerMap.get(cls);
        if(loggerBean==null){
            Logger logger = LoggerFactory.getLogger(cls);
            loggerBean = new LoggerBean(logger);
            loggerMap.put(cls,loggerBean);
        }
        return loggerBean;
    }

    /**
     * 打印一个json
     * @param cls 对象
     * @return 日志工具类
     */
    public static LoggerParam getLoggerJson(Class<?> cls){
        LoggerBean loggerBean = getLogger(cls);
        LoggerParam loggerParam = new LoggerParam(loggerBean);
        return loggerParam;
    }

    /**
     * 日志内部类
     */
    public static class LoggerBean{
        private Logger logger;
        public LoggerBean(Logger logger){
            this.logger = logger;
        }
        public Logger getLogger(){
            return this.logger;
        }

        public void info(String str){
            this.logger.info(str);
        }

        public void debug(String str){
            this.logger.debug(str);
        }

        public void error(String str){
            this.logger.error(str);
        }

        public void warn(String str){
            this.logger.warn(str);
        }

        public void exceptionLog(String str,Exception ex){
            this.logger.error(str,ex);
        }
    }

    /**
     * 用来打印json对象用的
     */
    public static class LoggerParam{
        private LoggerBean loggerBean;

        private Map<String,Object> jsonData = new HashMap<>();

        public LoggerParam(LoggerBean lb){
            this.loggerBean = lb;
        }

        /**
         * 向jsondata中添加一个数据
         * @param key key
         * @param data 数据
         * @return LoggerParam
         */
        public LoggerParam add(String key,Object data){
            jsonData.put(key,data);
            return this;
        }

        public void info(){
            String json = this.toString();
            loggerBean.info(json);
        }

        public void error(){
            String json = this.toString();
            loggerBean.error(json);
        }

        @Override
        public String toString() {
            return GsonUtil.GsonString(jsonData);
        }
    }
}
