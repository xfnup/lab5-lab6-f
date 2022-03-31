package com.example.dblab2.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonUtil {
    private int code;//状态码
    private String message;//返回信息段
    private String data;//数据段
}
