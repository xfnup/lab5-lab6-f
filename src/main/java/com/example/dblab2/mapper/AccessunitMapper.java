package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Accessunit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccessunitMapper {
    int addAccessunit(Accessunit accessunit);

    int deleteAccessunit(Accessunit accessunit);
}
