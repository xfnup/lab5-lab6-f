package com.example.dblab2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockListView {
    private int s_id;
    private String s_name;
    private int g_id;
    private String g_name;
    private int s_num;
}
