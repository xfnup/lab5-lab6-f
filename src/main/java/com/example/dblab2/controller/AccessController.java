package com.example.dblab2.controller;

import com.example.dblab2.mapper.AccessMapper;
import com.example.dblab2.pojo.Access;
import com.example.dblab2.pojo.AccessView;
import com.example.dblab2.utils.JsonUtil;
import com.example.dblab2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Access")
public class AccessController {
    @Autowired
    AccessMapper accessMapper;

    @PostMapping("/add")
    public JsonUtil addAccess(@RequestBody Access access)
    {
        accessMapper.addAccess(access);
        return new JsonUtil(0,"添加成功",null);
    }

    @PostMapping("/delete")
    public JsonUtil deleteAccess(@RequestBody Access access)
    {
        accessMapper.deleteAccess(access.getA_id());
        return new JsonUtil(0,"删除成功",null);
    }

    @GetMapping("/select")
    public Result<List<AccessView>> selectAccess(){
        List<AccessView> list= accessMapper.selectAccess();
        return Result.success(list);
    }
}
