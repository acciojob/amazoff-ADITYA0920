package com.driver;

public class Order {

    private String id;
    private int deliveryTime;

    public Order(String id, String deliveryTime) {

        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
        this.id=id;
        String temp[]=deliveryTime.split(":");
        int t=0;
        for(int i=0;i<2;i++){
            if(i==0){
                t+=Integer.valueOf(temp[i])*60;
            }
            else{
                t+=Integer.valueOf(temp[i]);
            }
        }
        this.deliveryTime=t;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDeliveryTime(int deliveryTime) {

        this.deliveryTime = deliveryTime;
    }

    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}

}
