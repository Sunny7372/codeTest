package com.filedownload.dao;

import java.util.List;

public class Acknowledge {
    private String bankId;
    private List<AtrData> data;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public List<AtrData> getData() {
        return data;
    }

    public void setData(List<AtrData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Acknowledge{" +
                "bankId='" + bankId + '\'' +
                ", data=" + data +
                '}';
    }
}
