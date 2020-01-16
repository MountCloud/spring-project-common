package org.mountcloud.cfgver.common.util;


/**
 * @author zhanghaishan
 * @version V1.0
 * @Description: TODO 等待工具，主要用于验证，返回的boolean，如果成功跳出等待，超时跳出等待
 *
 * 使用方法:

WaitUtil.wait(1000,()->{
//验证内容
return true;
});

 * @date 2019/11/15.
 */
public class WaitUtil {


    /**
     * 执行等待
     * @param waitTime 等待多久（毫秒）
     * @param waitMethod 验证方法
     */
    public static boolean wait(int waitTime,WaitMethod waitMethod){
        long start = System.currentTimeMillis();
        while (true){
            if(waitMethod.exec()){
                return true;
            }
            long now = System.currentTimeMillis();
            if(waitTime<(now-start)){
                return false;
            }
            try {
                //0.5秒继续验证
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
      * @author zhanghaishan
      * @version V1.0
      *
      * TODO: 等待方法
      * 2020/1/16.
      */
    public static interface WaitMethod{
        boolean exec();
    }

}
