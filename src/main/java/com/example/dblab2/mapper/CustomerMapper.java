package com.example.dblab2.mapper;

import com.example.dblab2.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CustomerMapper {
    int addCustomer(Customer customer);

    int deleteCustomer(Customer customer);
}
