package com.chedrocardenas.MyApi.service;

import com.chedrocardenas.MyApi.dto.Purchase;
import com.chedrocardenas.MyApi.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
