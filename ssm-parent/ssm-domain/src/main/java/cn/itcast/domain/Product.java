package cn.itcast.domain;

import java.util.Date;

public class Product {
    private String id;
    private String productNum;
    private String productName;
    private String cityName;
    private Date departureTimeStr;
    private Double productPrice;
    private String productDesc;
    private Integer productStatusStr;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTimeStr() {
        return departureTimeStr;
    }

    public void setDepartureTimeStr(Date departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatusStr() {
        return productStatusStr;
    }

    public void setProductStatusStr(Integer productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
