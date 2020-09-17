package com.entity;

/**
 * @ProjectName: StudentSystem
 * @Package: com.entity
 * @ClassName: Page
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/16 17:37
 * @Version: 1.0
 */
public class Page {
    private  Integer pageCurren=1;
    private Integer pageTotal;
    private  Integer count;
    private  Integer pageSize=3;

    public Integer getPageCurren() {
        return pageCurren;
    }

    public void setPageCurren(Integer pageCurren) {
        this.pageCurren = pageCurren;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
