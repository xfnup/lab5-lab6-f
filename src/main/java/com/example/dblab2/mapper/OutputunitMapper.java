package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Outputunit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OutputunitMapper {
    int addOutputunit(Outputunit outputunit);

    int deleteOutputunit(Outputunit outputunit);
}
