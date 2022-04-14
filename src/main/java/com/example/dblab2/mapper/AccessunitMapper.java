package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Access;
import com.example.dblab2.pojo.Accessunit;
import com.example.dblab2.pojo.AccessunitView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccessunitMapper {
    int addAccessunit(Accessunit accessunit);

    int deleteAccessunit(Accessunit accessunit);

    int updateAccessunit(Accessunit accessunit);

    List<Accessunit> selectAccessunit();

    List<AccessunitView> detailAccessunit(int a_id);
}
