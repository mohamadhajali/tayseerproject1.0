package com.example.androidproject;

public class Room {
    private int id, cap, priceByDay;
    private String img;

    public Room(int id, int cap, int priceByDay, String img) {
        this.id = id;
        this.cap = cap;
        this.priceByDay = priceByDay;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public int getPriceByDay() {
        return priceByDay;
    }

    public void setPriceByDay(int priceByDay) {
        this.priceByDay = priceByDay;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
