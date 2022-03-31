package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MerchantMapper {
    int addMerchant(Merchant merchant);

    int deleteMerchant(Merchant merchant);
}
