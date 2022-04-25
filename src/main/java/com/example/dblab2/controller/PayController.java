package com.example.dblab2.controller;

import com.example.dblab2.mapper.PayMapper;
import com.example.dblab2.pojo.Pay;
import com.example.dblab2.utils.JsonUtil;
import com.example.dblab2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Pay")
public class PayController {

    @Autowired
    PayMapper payMapper;

    @GetMapping("/pay")
    public JsonUtil payPay(@RequestParam("o_id") int o_id)
    {
        Pay pay=payMapper.selectPay(o_id);
        payMapper.updatePay(new Pay(o_id,pay.getP_tprice(),pay.getP_tprice(),0));
        return new JsonUtil(0,"付款成功",null);
    }

    @GetMapping("/select")
    public Result<List<Pay>> selectPay(@RequestParam("o_id") int o_id)
    {
        List<Pay> list=new ArrayList<>();
        Pay pay=payMapper.selectPay(o_id);
        pay.setP_pprice(pay.getP_tprice()-pay.getP_rprice());
        list.add(pay);
        return Result.success(list);
    }
}
