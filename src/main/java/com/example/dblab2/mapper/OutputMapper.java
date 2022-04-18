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

    int updateOutput(int o_id,int o_price);

    Output selectOprice(int o_id);

    List<OutputView> selectOutput();

    int maxOid();

}
