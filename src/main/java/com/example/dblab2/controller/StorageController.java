package com.example.dblab2.controller;

import com.example.dblab2.mapper.StorageMapper;
import com.example.dblab2.pojo.Goods;
import com.example.dblab2.pojo.Storage;
import com.example.dblab2.utils.JsonUtil;
import com.example.dblab2.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Storage")
public class StorageController {
    @Autowired
    StorageMapper storageMapper;

    @PostMapping("/add")
    public JsonUtil addStorage(@RequestBody Storage storage)
    {
        storageMapper.addStorage(storage);
        return new JsonUtil(0,"添加成功",null);
    }

    @PostMapping("/delete")
    public JsonUtil deleteStorage(@RequestBody Storage storage)
    {
        storageMapper.deleteStorage(storage);
        return new JsonUtil(0,"删除成功",null);
    }

    @GetMapping("/select")
    public Result<List<Storage>> selectStorage()
    {
        List<Storage> list= storageMapper.selectStorage();
        return Result.success(list);
    }
}
