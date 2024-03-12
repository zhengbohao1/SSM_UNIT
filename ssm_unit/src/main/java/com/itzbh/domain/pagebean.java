package com.itzbh.domain;

import java.util.List;

public class pagebean<T> {
    private  int totalcount;
    private List<T> rows;

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "pagebean{" +
                "totalcount=" + totalcount +
                ", rows=" + rows +
                '}';
    }
}
