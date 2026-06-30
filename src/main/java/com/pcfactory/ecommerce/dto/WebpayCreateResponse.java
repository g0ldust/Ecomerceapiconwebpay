package com.pcfactory.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class WebpayCreateResponse {
    private String token;
    private String url;
}