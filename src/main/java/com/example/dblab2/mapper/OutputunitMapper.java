package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Outputunit;
import com.example.dblab2.pojo.OutputunitView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OutputunitMapper {
    int addOutputunit(Outputunit outputunit);

    int deleteOutputunit(Outputunit outputunit);

    List<OutputunitView> selectOutputunit(int o_id);
}
