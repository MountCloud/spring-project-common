package org.mountcloud.cfgver.common.util;


/**
 * @author zhanghaishan
 * @version V1.0
 * @Description: TODO 重新尝试工具
 * @date 2019/11/15.
 */
public class ReTryUtil<T> {

    /**
     * 重新尝试几次
     */
    private Integer reTryNum;

    /**
     * 现在到了第几次
     */
    private Integer nowReTryNum;

    /**
     * 构造函数
     * @param reTryNum 尝试几次
     */
    private ReTryUtil(Integer reTryNum){
        this.reTryNum = reTryNum;
    }

    /**
     * 开始尝试
     * @param reTryMethod 用来尝试的方法
     * @param reTryCheck 验证尝试结果的方法
     * @return 尝试获取的内容
     */
    public T start(ReTryMethod reTryMethod, ReTryCheck reTryCheck){
        for(int i=0;i<getReTryNum();i++){
            setNowReTryNum(i+1);
            Object result = reTryMethod.get(this);
            if(reTryCheck.check(result,this)){
                return (T) result;
            }
            try {
                //等待1秒尝试
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        return null;
    }

    public Integer getReTryNum() {
        return reTryNum;
    }

    public void setReTryNum(Integer reTryNum) {
        this.reTryNum = reTryNum;
    }

    public Integer getNowReTryNum() {
        return nowReTryNum;
    }

    public void setNowReTryNum(Integer nowReTryNum) {
        this.nowReTryNum = nowReTryNum;
    }

    /**
     * 静态尝试的方法，方便调用
     * @param tryNum 尝试次数
     * @param reTryMethod 尝试方法
     * @param reTryCheck 验证尝试的方法
     * @param <T> T
     * @return 尝试结果
     */
    public static<T> T reTry(int tryNum, ReTryMethod reTryMethod, ReTryCheck reTryCheck){
        ReTryUtil<T> reTryUtil = new ReTryUtil<T>(tryNum);
        return reTryUtil.start(reTryMethod,reTryCheck);
    }

    /**
      * @author zhanghaishan
      * @version V1.0
      *
      * TODO: 尝试方法
      * 2020/1/16.
      */
    public interface ReTryMethod{
        Object get(ReTryUtil ru);
    }

    /**
      * @author zhanghaishan
      * @version V1.0
      *
      * TODO: 尝试的验证方法
      * 2020/1/16.
      */
    public interface ReTryCheck{
        boolean check(Object obj, ReTryUtil ru);
    }
}
