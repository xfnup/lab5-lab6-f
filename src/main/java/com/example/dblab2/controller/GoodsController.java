package com.example.dblab2.controller;

import com.example.dblab2.mapper.GoodsMapper;
import com.example.dblab2.pojo.Customer;
import com.example.dblab2.pojo.Goods;
import com.example.dblab2.utils.JsonUtil;
import com.example.dblab2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/delete")
    public JsonUtil deleteGoods(@RequestBody Goods goods)
    {
        System.out.println(goods.getG_id());
        System.out.println(goods.getG_name());
        goodsMapper.deleteGoods(goods);
        return new JsonUtil(0,"删除成功",null);
    }

    @GetMapping("/select")
    public Result<List<Goods>> selectGoods()
    {
        List<Goods> list=goodsMapper.selectGoods();
        return Result.success(list);
    }

    @GetMapping("/search")
    public Result<List<Goods>> searchGoods(@RequestParam("name") String name)
    {
        List<Goods> list=goodsMapper.searchGoods(name+'%');
        return Result.success(list);
    }
}
