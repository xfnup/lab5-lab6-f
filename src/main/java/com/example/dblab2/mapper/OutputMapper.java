package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Output;
import com.example.dblab2.pojo.OutputView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OutputMapper {
    int addOutput(Output output);

    int deleteOutput(Output output);

    List<OutputView> selectOutput();

}
