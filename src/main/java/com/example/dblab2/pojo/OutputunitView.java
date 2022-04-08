package com.example.dblab2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputunitView {
   /* o_id,ou_seq,s_id,s_name,g_id,g_name,ou_num,ou_price*/
    private int o_id;
    private int ou_seq;
    private int s_id;
    private String s_name;
    private int g_id;
    private String g_name;
    private int ou_num;
    private int ou_price;
}
