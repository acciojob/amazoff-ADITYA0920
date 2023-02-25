package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
  //01.
    public void addOrder(Order order){

        orderRepository.addOrder(order);
    };
    //02.
    public void addPartner(String partnerId){
        orderRepository.addPartner(partnerId);
    };
    //03.
    public void addOrderPartnerPair(String orderId,String partnerId){
        orderRepository.addOrderPartnerPair(orderId,partnerId);
    };
    //04.
    public Order getOrderById(String orderId){
        return orderRepository.getOrderById(orderId);
    };
    //05.
    public DeliveryPartner getPartnerById(String partnerId){
        return orderRepository.getPartnerById(partnerId);
    };
    //06.
    public int getOrderCountByPartnerId(String partnerId){
        return orderRepository.getOrderCountByPartnerId(partnerId);
    };
    //07.
    public List<Order> getOrdersByPartnerId(String partnerId){
        return orderRepository.getOrdersByPartnerId(partnerId);
    };
    //08.
    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    };
    //09.
    public Integer getCountOfUnassignedOrders(){
        return orderRepository.getCountOfUnassignedOrders();
    };
    //10.
    public Integer getOrdersLeftAfterGivenTimeByPartnerId( String time,String partnerId){
        return orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(time,partnerId);
    };
    //11.
    public String getLastDeliveryTimeByPartnerId(String partnerId){
        return orderRepository.getLastDeliveryTimeByPartnerId(partnerId);
    };
    //12.
    public void deletePartnerById(String partnerId){
             orderRepository.deletePartnerById(partnerId);
    };
    //13.
    public void deleteOrderById(String orderId){
            orderRepository.deleteOrderById(orderId);
    };

}
