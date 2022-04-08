package com.example.dblab2.controller;

import com.example.dblab2.mapper.OutputMapper;
import com.example.dblab2.pojo.Output;
import com.example.dblab2.pojo.OutputView;
import com.example.dblab2.utils.JsonUtil;
import com.example.dblab2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/select")
    public Result<List<OutputView>> selectOutput()
    {
        List<OutputView> list= outputMapper.selectOutput();
        return Result.success(list);
    }
}
