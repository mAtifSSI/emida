package com.emdia.employee.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name="account",url = "http://localhost:8084/accounts/")
//@Repository
interface AccountClientService {
    @GetMapping("/api/")
    fun getItems(): String
}