package com.example.dblab2.controller;

import com.example.dblab2.mapper.CustomerMapper;
import com.example.dblab2.pojo.Customer;
import com.example.dblab2.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    CustomerMapper customerMapper;

    @PostMapping("/add")
    public JsonUtil addCustomer(@RequestBody Customer customer)
    {
        customerMapper.addCustomer(customer);
        return new JsonUtil(0,"添加成功",null);
    }

    @PostMapping("/delete")
    public JsonUtil deleteCustomer(@RequestBody Customer customer)
    {
        customerMapper.deleteCustomer(customer);
        return new JsonUtil(0,"删除成功",null);
    }
}
