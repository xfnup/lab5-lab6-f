package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Pay;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PayMapper {
    int updatePay(Pay pay);
    int addPay(Pay pay);
    int deletePay(int o_id);
    Pay selectPay(int o_id);
}
