package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MerchantMapper {
    int addMerchant(Merchant merchant);

    int deleteMerchant(Merchant merchant);

    List<Merchant> selectMerchant();
}
