package com.webservice.projetospring.domain.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    final int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static OrderStatus valueOf(int code){
        for(OrderStatus orderStatus : OrderStatus.values()){
            if(orderStatus.getValue() == code){
                return  orderStatus;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
