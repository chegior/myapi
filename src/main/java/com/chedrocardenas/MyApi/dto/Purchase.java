package com.chedrocardenas.MyApi.dto;

import com.chedrocardenas.MyApi.entity.Address;
import com.chedrocardenas.MyApi.entity.Customer;
import com.chedrocardenas.MyApi.entity.Order;
import com.chedrocardenas.MyApi.entity.OrderDetails;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    Customer customer;
    Order order;
    Address shippingAddress;
    Address billingAddres;
    Set<OrderDetails> orderDetails;
}
