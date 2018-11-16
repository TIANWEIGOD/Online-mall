package cn.itcast.util;

import java.io.Serializable;
import java.util.List;

public class PageBean<E> implements Serializable {

    private List<E> list;
    // 当前页
    private int curPage;
    // 总页数
    private int totalPage;
    // 总记录数
    private int totalCount;
    // 每页记录数
    private int pageSize;
    // 上一页
    private int prePage;
    // 下一页
    private int nextPage;
    // 开始页
    private int startPage;
    // 结束页
    private int lostPage;
    // 其实索引
    private int startIndex;

    public PageBean(int curPage, int totalCount, int pageSize) {
        this.curPage = curPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;

        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        this.startIndex = (curPage - 1) * pageSize;

        if (curPage == 1) {
            this.prePage = curPage;
        } else {
            this.prePage = curPage - 1;
        }

        if (curPage == totalPage) {
            this.nextPage = curPage;
        } else {
            this.nextPage = curPage + 1;
        }
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getLostPage() {
        return lostPage;
    }

    public void setLostPage(int lostPage) {
        this.lostPage = lostPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
