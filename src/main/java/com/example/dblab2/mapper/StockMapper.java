package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Stock;
import com.example.dblab2.pojo.StockView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StockMapper {
    int addStock(Stock stock);
    int deleteStock(Stock stock);
    int updateStock(Stock stock);
    List<StockView> selectStock(int s_id);
}
