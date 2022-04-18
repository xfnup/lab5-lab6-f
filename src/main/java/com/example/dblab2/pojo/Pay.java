package com.example.dblab2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pay {
    private int o_id;
    private int p_tprice;
    private int p_pprice;
    private int p_rprice;
}
