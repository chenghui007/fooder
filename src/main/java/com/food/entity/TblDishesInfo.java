package com.food.entity;

public class TblDishesInfo {
    private Integer id;

    private String disherType;

    private String dishierName;

    private Integer price;

    private Integer makeTime;

    private String disherImage;

    private String disherDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisherType() {
        return disherType;
    }

    public void setDisherType(String disherType) {
        this.disherType = disherType == null ? null : disherType.trim();
    }

    public String getDishierName() {
        return dishierName;
    }

    public void setDishierName(String dishierName) {
        this.dishierName = dishierName == null ? null : dishierName.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Integer makeTime) {
        this.makeTime = makeTime;
    }

    public String getDisherImage() {
        return disherImage;
    }

    public void setDisherImage(String disherImage) {
        this.disherImage = disherImage == null ? null : disherImage.trim();
    }

    public String getDisherDesc() {
        return disherDesc;
    }

    public void setDisherDesc(String disherDesc) {
        this.disherDesc = disherDesc == null ? null : disherDesc.trim();
    }
}