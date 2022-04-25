package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Access;
import com.example.dblab2.pojo.AccessView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccessMapper {
    int addAccess(Access access);

    int deleteAccess(int a_id);

    List<AccessView> selectAccess();

    int getsid(int a_id);
}
