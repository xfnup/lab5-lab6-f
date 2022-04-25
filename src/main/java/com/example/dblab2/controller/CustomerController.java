package com.example.dblab2.controller;

import com.example.dblab2.mapper.CustomerMapper;
import com.example.dblab2.pojo.Customer;
import com.example.dblab2.utils.JsonUtil;
import com.example.dblab2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/select")
    public Result<List<Customer>> selectCustomer()
    {
        List<Customer> list=customerMapper.selectCustomer();
        return Result.success(list);
    }

    @GetMapping("/search")
    public Result<List<Customer>> searchCustomer(@RequestParam("name") String name)
    {
        List<Customer> list=customerMapper.searchCustomer(name+'%');
        return Result.success(list);
    }
}
