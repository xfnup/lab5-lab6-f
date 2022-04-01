package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    int addGoods(Goods goods);//增加商品

    int deleteGoods(Goods goods);//删除商品

    List<Goods> selectGoods();//返回所有商品
}
