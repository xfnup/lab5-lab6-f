package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsMapper {

    int addGoods(Goods goods);//增加商品
}
