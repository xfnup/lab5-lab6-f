package com.example.dblab2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Outputunit {
    private int o_id;
    private int ou_seq;
    private int s_id;
    private int g_id;
    private int ou_num;
    private int ou_price;
}
