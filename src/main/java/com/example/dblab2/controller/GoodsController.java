package com.example.dblab2.controller;

import com.example.dblab2.mapper.GoodsMapper;
import com.example.dblab2.pojo.Goods;
import com.example.dblab2.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Goods")
public class GoodsController {
    @Autowired
    GoodsMapper goodsMapper;

    @PostMapping("/add")
    public JsonUtil addGoods(@RequestBody Goods goods)
    {
        goodsMapper.addGoods(goods);
        return new JsonUtil(0,"添加成功",null);
    }
}
