package com.pcfactory.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor


public class WebpayCreateRequest {
    private String buy_order;
    private String session_id;
    private double amount;
    private String return_url;

    public WebpayCreateRequest(String buy_order, String session_id, double amount, String return_url) {
        this.buy_order = buy_order;
        this.session_id = session_id;
        this.amount = amount;
        this.return_url = return_url;
    }

}