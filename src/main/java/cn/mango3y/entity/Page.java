package cn.mango3y.entity;

import lombok.Data;

@Data
public class Page {
    private Integer pageNum = 1;
    private Integer pageSize = 3;

    public Page() {
    }

    public Page(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
