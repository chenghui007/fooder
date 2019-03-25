package com.food.entity;

import java.util.Date;

public class TblOrderDetail {
    private Integer id;

    private String disherName;

    private String money;

    private String number;

    private String totalMoney;

    private Date createTime;

    private String orderNo;

    private Integer disherId;

    private String disherType;

    private String disherTypeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisherName() {
        return disherName;
    }

    public void setDisherName(String disherName) {
        this.disherName = disherName == null ? null : disherName.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney == null ? null : totalMoney.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getDisherId() {
        return disherId;
    }

    public void setDisherId(Integer disherId) {
        this.disherId = disherId;
    }

    public String getDisherType() {
        return disherType;
    }

    public void setDisherType(String disherType) {
        this.disherType = disherType == null ? null : disherType.trim();
    }

    public String getDisherTypeName() {
        return disherTypeName;
    }

    public void setDisherTypeName(String disherTypeName) {
        this.disherTypeName = disherTypeName == null ? null : disherTypeName.trim();
    }
}