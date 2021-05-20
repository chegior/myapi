package com.chedrocardenas.MyApi.service;

import com.chedrocardenas.MyApi.dao.CustomerRepository;
import com.chedrocardenas.MyApi.dto.Purchase;
import com.chedrocardenas.MyApi.dto.PurchaseResponse;
import com.chedrocardenas.MyApi.entity.Customer;
import com.chedrocardenas.MyApi.entity.Order;
import org.hibernate.id.GUIDGenerator;
import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.websocket.server.ServerEndpoint;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional // Allow el Commit() o RollBack()
    public PurchaseResponse placeOrder(Purchase purchase) {

        //genera el tracking numbre
        String trackingNumber = getTrackingNumber();
        //recuperamos la orden
        Order order = purchase.getOrder();
        //set el # de tracking a la orden
        order.setTrackingNumber(trackingNumber);
        //set la direeccion de facturacion
        order.setBillingaddress(purchase.getBillingAddres());
        //set la direeccion de envio
        order.setShippingAddress(purchase.getShippingAddress());

        purchase.getOrderDetails().forEach( x -> order.addOrderDetail(x));

        Customer customer = purchase.getCustomer();
        customer.addOrder(order);

        customerRepository.save(customer);
        return new PurchaseResponse(trackingNumber);


    }

    private String getTrackingNumber(){
        return UUID.randomUUID().toString();
    }


}
