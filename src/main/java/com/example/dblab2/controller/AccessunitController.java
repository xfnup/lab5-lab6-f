package com.example.dblab2.controller;

import com.example.dblab2.mapper.AccessMapper;
import com.example.dblab2.mapper.AccessunitMapper;
import com.example.dblab2.mapper.StockMapper;
import com.example.dblab2.pojo.*;
import com.example.dblab2.utils.JsonUtil;
import com.example.dblab2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Accessunit")
public class AccessunitController {
    @Autowired
    AccessunitMapper accessunitMapper;
    @Autowired
    StockMapper stockMapper;
    @Autowired
    AccessMapper accessMapper;

    @PostMapping("/add")
    public JsonUtil addAccessunit(@RequestBody Accessunit accessunit)
    {
        //System.out.println(accessunit);
        List<AccessunitView> accessunitViews = accessunitMapper.detailAccessunit(accessunit.getA_id());
        boolean flag=true;
        for (AccessunitView accessunitView:accessunitViews)
        {
            if (accessunitView.getG_id()==accessunit.getG_id())
            {
                accessunitMapper.updateAccessunit(new Accessunit(accessunit.getA_id(),accessunit.getS_id(),accessunit.getAu_seq(),accessunit.getG_id(), accessunit.getAu_num()+accessunitView.getAu_num(),accessunit.getAu_price()));
                flag=false;
            }
        }
        if (flag)
        {
            accessunitMapper.addAccessunit(accessunit);
        }
        System.out.println(accessunit);
        List<StockView> list=stockMapper.selectStock(accessunit.getS_id());
        for(StockView stockView:list)
        {
            if(stockView.getS_id()==accessunit.getS_id()&&stockView.getG_id()==accessunit.getG_id())
            {
                //System.out.println("hhh");
                //System.out.println(stockView.getS_id());
                //System.out.println(stockView.getG_id());
                //System.out.println(stockView.getS_num());
                //System.out.println(accessunit.getAu_num());
                stockMapper.updateStock(new Stock(stockView.getS_id(),stockView.getG_id(),stockView.getS_num()+ accessunit.getAu_num()));
                return new JsonUtil(0,"添加成功",null);
            }
        }
        //System.out.println("sss");
        //System.out.println(accessunit);
        stockMapper.addStock(new Stock(accessunit.getS_id(),accessunit.getG_id(),accessunit.getAu_num()));
        return new JsonUtil(0,"添加成功",null);
    }

    @PostMapping("/delete")
    public JsonUtil deleteAccessunit(@RequestBody Accessunit accessunit)
    {
        //au_seq,au_num,a_id,g_id
        accessunitMapper.deleteAccessunit(accessunit);
        int s_id=accessMapper.getsid(accessunit.getA_id());
        Stock stock=stockMapper.selectaStock(new Stock(s_id,accessunit.getG_id(),0));
        stockMapper.updateStock(new Stock(s_id,accessunit.getG_id(),stock.getS_num()-accessunit.getAu_num()));
        return new JsonUtil(0,"删除成功",null);
    }

    @GetMapping("/detail")
    public Result<List<AccessunitView>> detailAccessunit(@RequestParam("a_id") int a_id){
        List<AccessunitView> list=accessunitMapper.detailAccessunit(a_id);
        return Result.success(list);
    }

}
