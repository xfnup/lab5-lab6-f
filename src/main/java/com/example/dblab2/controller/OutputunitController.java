package com.example.dblab2.controller;

import com.example.dblab2.mapper.OutputunitMapper;
import com.example.dblab2.mapper.StockMapper;
import com.example.dblab2.pojo.Outputunit;
import com.example.dblab2.pojo.OutputunitView;
import com.example.dblab2.pojo.Stock;
import com.example.dblab2.utils.JsonUtil;
import com.example.dblab2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Outputunit")
public class OutputunitController {
    @Autowired
    OutputunitMapper outputunitMapper;
    @Autowired
    StockMapper stockMapper;

    @PostMapping("/add")
    public JsonUtil addOutputunit(@RequestBody Outputunit outputunit)
    {
        outputunitMapper.addOutputunit(outputunit);
        int oldNum=stockMapper.selectaStock(new Stock(outputunit.getS_id(),outputunit.getG_id(),0)).getS_num();
        stockMapper.updateStock(new Stock(outputunit.getS_id(),outputunit.getG_id(),oldNum-outputunit.getOu_num()));
        return new JsonUtil(0,"添加成功",null);
    }

    @PostMapping("/delete")
    public JsonUtil deleteOutputunit(@RequestBody Outputunit outputunit)
    {
        outputunitMapper.deleteOutputunit(outputunit);
        int oldNum=stockMapper.selectaStock(new Stock(outputunit.getS_id(),outputunit.getG_id(),0)).getS_num();
        stockMapper.updateStock(new Stock(outputunit.getS_id(),outputunit.getG_id(),oldNum+outputunit.getOu_num()));
        return new JsonUtil(0,"删除成功",null);
    }

    @GetMapping("/detail")
    public Result<List<OutputunitView>> detailoutputunitview(@RequestParam("o_id") int o_id)
    {
        List<OutputunitView> list=outputunitMapper.selectOutputunit(o_id);
        return Result.success(list);
    }
}
