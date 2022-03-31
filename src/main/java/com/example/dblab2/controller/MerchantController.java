package com.example.dblab2.controller;

import com.example.dblab2.mapper.MerchantMapper;
import com.example.dblab2.pojo.Merchant;
import com.example.dblab2.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Merchant")
public class MerchantController {
    @Autowired
    MerchantMapper merchantMapper;

    @PostMapping("/add")
    public JsonUtil addMerchant(@RequestBody Merchant merchant)
    {
        merchantMapper.addMerchant(merchant);
        return new JsonUtil(0,"添加成功",null);
    }

    @PostMapping("/delete")
    public JsonUtil deleteMerchant(@RequestBody Merchant merchant)
    {
        merchantMapper.deleteMerchant(merchant);
        return new JsonUtil(0,"删除成功",null);
    }
}
