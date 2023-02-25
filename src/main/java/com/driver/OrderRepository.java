package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class OrderRepository {
    Map<String ,Order> OrderHashMap=new HashMap<>();
    Map<String,DeliveryPartner>PartnerHashMap=new HashMap<>();
    Map<String, List<String>>OrderPartnerHashMap=new HashMap<>();

    public void addOrder(Order order){
        OrderHashMap.put(order.getId(),order);
    };
    public void addPartner(String partnerId){
        DeliveryPartner d=null;
        PartnerHashMap.put(partnerId,d);
    };
    public void addOrderPartnerPair(String orderId,String partnerId){
        List<String>list=new ArrayList<>();
        if(OrderPartnerHashMap.containsKey(partnerId)){
            list=OrderPartnerHashMap.get(partnerId);
            OrderPartnerHashMap.put(partnerId,list);
        }
        else{
            list.add(orderId);
            OrderPartnerHashMap.put(partnerId,list);
        }
    };
    public Order getOrderById(String orderId){
        if(OrderHashMap.containsKey(orderId)){
            return OrderHashMap.get(orderId);
        }
        return null;
    };
    public DeliveryPartner getPartnerById(String partnerId){
        if(PartnerHashMap.containsKey(partnerId)){
            return PartnerHashMap.get(partnerId);
        }
        return null;
    };
    public int getOrderCountByPartnerId(String partnerId){
        int cnt=0;
        if(OrderPartnerHashMap.containsKey(partnerId)){
            List<String>temp=OrderPartnerHashMap.get(partnerId);
            cnt=temp.size();
            return  cnt;
        }
        return cnt;
    };
    public List<String> getOrdersByPartnerId(String partnerId){
        List<String>list=new ArrayList<>();
        if(OrderPartnerHashMap.containsKey(partnerId)){
            list=OrderPartnerHashMap.get(partnerId);
            return  list;
        }
        return list;
    };
    public List<Order> getAllOrders(){
        List<Order>list=new ArrayList<>();
        for(String str:OrderHashMap.keySet()){
            list.add(OrderHashMap.get(str));
        }
        return list;
    };
    public Integer getCountOfUnassignedOrders(){
        Set<String>set=new HashSet<>();
        for(String str:OrderHashMap.keySet()){
            if(check(str))set.add(str);
        }
        return (Integer) set.size();

    };
    public boolean check(String str){
        //Map<String, List<String>>OrderPartnerHashMap=new HashMap<>();
        List<String>list=new ArrayList<>();
        for(String st:OrderPartnerHashMap.keySet()){
            list=OrderPartnerHashMap.get(st);
            if(list.contains(str)) return false;
        }
        return true;
    }
    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String time,String partnerId){
         int cnt=0;
        for(String str:OrderPartnerHashMap.get(partnerId)){
            Order curr=null;
            curr=OrderHashMap.get(str);
            int given_time=Integer.valueOf(time);
            if(curr.getDeliveryTime()>given_time)cnt++;
        }
        return cnt;
    };
    public String getLastDeliveryTimeByPartnerId(String partnerId){
        int last=0;
        List<String>list=OrderPartnerHashMap.get(partnerId);
        for(String str:list){
            last=Math.max(last,Integer.valueOf(str));

        }
        return String.valueOf(last);
    };
    public void deletePartnerById(String partnerId){

        PartnerHashMap.remove(partnerId);
        OrderPartnerHashMap.remove(partnerId);
    };
    public void deleteOrderById(String orderId){
        for(String str:OrderHashMap.keySet()){
            OrderHashMap.remove(str);
        }
    };
}
