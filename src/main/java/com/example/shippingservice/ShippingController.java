package com.example.shippingservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shipping")
@RequiredArgsConstructor
@Slf4j
public class ShippingController {

    private final UserServiceClient userServiceClient;

    @PostMapping
    public ShippingDTO createOrder(@RequestBody ShippingDTO shippingDTO) {
        UserDTO user = userServiceClient.getUser(shippingDTO.getUserId());
        shippingDTO.setId(30L);
        log.info("Sending shipoing creation notification for user : {}", user);
        return shippingDTO;
    }


}
