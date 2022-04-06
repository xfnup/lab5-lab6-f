package com.example.dblab2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessunitView {
    private int a_id;
    private int au_seq;
    private int g_id;
    private String g_name;
    private int au_num;
    private int au_price;
}
