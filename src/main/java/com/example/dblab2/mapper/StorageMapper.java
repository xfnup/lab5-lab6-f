package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StorageMapper {
    int addStorage(Storage storage);
    int deleteStorage(Storage storage);
    List<Storage> selectStorage();
}
