package com.example.dblab2.controller;

import com.example.dblab2.mapper.OutputMapper;
import com.example.dblab2.mapper.OutputunitMapper;
import com.example.dblab2.mapper.PayMapper;
import com.example.dblab2.mapper.StockMapper;
import com.example.dblab2.pojo.Outputunit;
import com.example.dblab2.pojo.OutputunitView;
import com.example.dblab2.pojo.Pay;
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
    @Autowired
    OutputMapper outputMapper;
    @Autowired
    PayMapper payMapper;

    @PostMapping("/add")
    public JsonUtil addOutputunit(@RequestBody Outputunit outputunit)
    {
        outputunitMapper.addOutputunit(outputunit);
        int oldprice=outputMapper.selectOprice(outputunit.getO_id()).getO_price();
        outputMapper.updateOutput(outputunit.getO_id(),oldprice+outputunit.getOu_price());

        Pay pay= payMapper.selectPay(outputunit.getO_id());
        payMapper.updatePay(new Pay(pay.getO_id(),oldprice+outputunit.getOu_price(),pay.getP_pprice(),pay.getP_rprice()+outputunit.getOu_price()));

        int oldNum=stockMapper.selectaStock(new Stock(outputunit.getS_id(),outputunit.getG_id(),0)).getS_num();
        stockMapper.updateStock(new Stock(outputunit.getS_id(),outputunit.getG_id(),oldNum-outputunit.getOu_num()));
        return new JsonUtil(0,"添加成功",null);
    }

    @PostMapping("/delete")
    public JsonUtil deleteOutputunit(@RequestBody Outputunit outputunit)
    {
        outputunitMapper.deleteOutputunit(outputunit);
        int oldprice=outputMapper.selectOprice(outputunit.getO_id()).getO_price();
        outputMapper.updateOutput(outputunit.getO_id(),oldprice-outputunit.getOu_price());

        Pay pay= payMapper.selectPay(outputunit.getO_id());
        if (pay.getP_pprice()>0)
        {
            payMapper.updatePay(new Pay(pay.getO_id(),oldprice-outputunit.getOu_price(),pay.getP_pprice()-outputunit.getOu_price(),0));
        }
        else
        {
            payMapper.updatePay(new Pay(pay.getO_id(),oldprice-outputunit.getOu_price(),0,0));
        }
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
