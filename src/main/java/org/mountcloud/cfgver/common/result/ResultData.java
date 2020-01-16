package org.mountcloud.cfgver.common.result;

import org.mountcloud.cfgver.common.util.GsonUtil;

/**
 * TODO:具有data属性的返回值
 * 2018/12/27.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public class ResultData<T> {

    //值
    private T data;

    public ResultData(T data) {
        this.data = data;
    }

    public ResultData() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
}
