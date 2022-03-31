package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Output;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OutputMapper {
    int addOutput(Output output);

    int deleteOutput(Output output);
}
