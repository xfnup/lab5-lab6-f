package com.example.dblab2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputView {
    private int o_id;
    private int c_id;
    private String c_name;
    private String c_type;
    private int o_price;
}
