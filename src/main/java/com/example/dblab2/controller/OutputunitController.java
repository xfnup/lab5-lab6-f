package com.example.dblab2.controller;

import com.example.dblab2.mapper.OutputunitMapper;
import com.example.dblab2.pojo.Outputunit;
import com.example.dblab2.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Outputunit")
public class OutputunitController {
    @Autowired
    OutputunitMapper outputunitMapper;

    @PostMapping("/add")
    public JsonUtil addOutputunit(@RequestBody Outputunit outputunit)
    {
        outputunitMapper.addOutputunit(outputunit);
        return new JsonUtil(0,"添加成功",null);
    }

    @PostMapping("/delete")
    public JsonUtil deleteOutputunit(@RequestBody Outputunit outputunit)
    {
        outputunitMapper.deleteOutputunit(outputunit);
        return new JsonUtil(0,"删除成功",null);
    }
}
