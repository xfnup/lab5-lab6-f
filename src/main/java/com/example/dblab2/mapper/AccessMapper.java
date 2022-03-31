package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Access;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccessMapper {
    int addAccess(Access access);

    int deleteAccess(int a_id);
}
