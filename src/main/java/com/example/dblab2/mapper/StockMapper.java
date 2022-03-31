package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StockMapper {
    int addStock(Stock stock);
    int deleteStock(Stock stock);
}
