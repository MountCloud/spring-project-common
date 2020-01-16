package org.mountcloud.cfgver.common.result;

import java.util.List;

import org.mountcloud.cfgver.common.util.GsonUtil;

/**
 * TODO: 分页工具
 * 2018/4/25.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public class PageBean<T> {


    /**
     * 创建一个分页工具
     * @param list 数据
     * @param pageIndex 页码
     * @param pageSize 每页数量
     * @param maxCount 最大数量
     * @param <Y> 类型
     * @return 分页工具
     */
    public static <Y> PageBean<Y> createPageBean(List<Y> list,long pageIndex,long pageSize,long maxCount){
        PageBean<Y> pageBean = new PageBean<Y>();
        pageBean.setDatas(list);
        pageBean.setPageIndex(pageIndex);
        pageBean.setPageSize(pageSize);
        pageBean.setMaxCount(maxCount);
        if(maxCount==0){
            pageBean.setMaxPage(0);
        }else {
            long maxPage = maxCount % pageSize > 0 ? maxCount / pageSize + 1 : maxCount / pageSize;
            pageBean.setMaxPage(maxPage);
        }
        return pageBean;
    }

    //"页码"
    private long pageIndex;

    //"每页个数"
    private long pageSize;

    //"总个数"
    private long maxCount;

    //"总页数"
    private long maxPage;

    //"数据"
    private List<T> datas;

    public long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(long maxCount) {
        this.maxCount = maxCount;
    }

    public long getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(long maxPage) {
        this.maxPage = maxPage;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
    
}
