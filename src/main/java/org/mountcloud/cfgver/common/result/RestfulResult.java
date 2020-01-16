package org.mountcloud.cfgver.common.result;

/**
 * @author zhanghaishan
 * @version V1.0
 * TODO: Rest的结果，算是一个标准返回格式
 * 2017/12/20.
 */
public class RestfulResult<T> {
    //状态
    private int status = 0;
    //数据
    private T data;
    //消息
    private String message = "";

    public RestfulResult() {
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    /**
      * @author zhanghaishan
      * @version V1.0
      *
      * TODO: 状态
      * 2020/1/16.
      */
    public static enum ResultStatus {
        //成功
        SUCCESS(0),
        //失败
        FAILE(-1);

        private int value;

        private ResultStatus(int value) {
            this.setValue(value);
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    
}
