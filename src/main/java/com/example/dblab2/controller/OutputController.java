package com.example.dblab2.controller;

import com.example.dblab2.mapper.OutputMapper;
import com.example.dblab2.pojo.Output;
import com.example.dblab2.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Output")
public class OutputController {
    @Autowired
    OutputMapper outputMapper;

    @PostMapping("/add")
    public JsonUtil addOutput(@RequestBody Output output)
    {
        outputMapper.addOutput(output);
        return new JsonUtil(0,"添加成功",null);
    }

    @PostMapping("/delete")
    public JsonUtil deleteOutput(@RequestBody Output output)
    {
        outputMapper.deleteOutput(output);
        return new JsonUtil(0,"删除成功",null);
    }
}
