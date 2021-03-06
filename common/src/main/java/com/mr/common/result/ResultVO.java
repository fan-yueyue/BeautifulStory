package com.mr.common.result;

import java.util.List;

public class ResultVO<T> {
    public ResultVO(String code, String error) {
        this.code = code;
        this.error = error;
    }

    public ResultVO() {

    }

    private String code;

    private String error;

    private List<T> dataList;

    private List<T> addressList;


    public List<T> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<T> addressList) {
        this.addressList = addressList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
