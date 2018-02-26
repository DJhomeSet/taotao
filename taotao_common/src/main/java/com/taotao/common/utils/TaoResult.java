package com.taotao.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.common.utils
 * @date 2018/2/25
 */
public class TaoResult<T> implements Serializable{
    private long total;
    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
