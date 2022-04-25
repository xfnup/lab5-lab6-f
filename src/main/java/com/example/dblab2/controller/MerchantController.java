package com.example.dblab2.controller;

import com.example.dblab2.mapper.MerchantMapper;
import com.example.dblab2.pojo.Goods;
import com.example.dblab2.pojo.Merchant;
import com.example.dblab2.utils.JsonUtil;
import com.example.dblab2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/select")
    public Result<List<Merchant>> selectMerchant()
    {
        List<Merchant> list=merchantMapper.selectMerchant();
        return Result.success(list);
    }

    @GetMapping("/search")
    public Result<List<Merchant>> searchMerchant(@RequestParam("name") String name)
    {
        List<Merchant> list=merchantMapper.searchMerchant(name+'%');
        return Result.success(list);
    }
}
