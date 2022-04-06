package com.example.dblab2.controller;

import com.example.dblab2.mapper.AccessunitMapper;
import com.example.dblab2.pojo.Access;
import com.example.dblab2.pojo.Accessunit;
import com.example.dblab2.pojo.AccessunitView;
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

    @PostMapping("/add")
    public JsonUtil addAccessunit(@RequestBody Accessunit accessunit)
    {
        accessunitMapper.addAccessunit(accessunit);
        return new JsonUtil(0,"添加成功",null);
    }

    @PostMapping("/delete")
    public JsonUtil deleteAccessunit(@RequestBody Accessunit accessunit)
    {
        accessunitMapper.deleteAccessunit(accessunit);
        return new JsonUtil(0,"删除成功",null);
    }

    @GetMapping("/detail")
    public Result<List<AccessunitView>> detailAccessunit(@RequestParam("a_id") int a_id){
        List<AccessunitView> list=accessunitMapper.detailAccessunit(a_id);
        return Result.success(list);
    }

}
