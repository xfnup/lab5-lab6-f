package com.example.dblab2.controller;

import com.example.dblab2.mapper.StockMapper;
import com.example.dblab2.pojo.Stock;
import com.example.dblab2.pojo.StockView;
import com.example.dblab2.utils.JsonUtil;
import com.example.dblab2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Stock")
public class StockController {
    @Autowired
    StockMapper stockMapper;

    @PostMapping("/add")
    public JsonUtil addStock(@RequestBody Stock stock)
    {
        stockMapper.addStock(stock);
        return new JsonUtil(0,"添加成功",null);
    }

    @PostMapping("/delete")
    public JsonUtil deleteStock(@RequestBody Stock stock)
    {
        stockMapper.deleteStock(stock);
        return new JsonUtil(0,"删除成功",null);
    }

    @GetMapping("/detail")
    public Result<List<StockView>> selectStock(@RequestParam("s_id") int s_id)
    {
        List<StockView> list=stockMapper.selectStock(s_id);
        return Result.success(list);
    }
}
