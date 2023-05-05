package com.verizon.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Download {
    private String operator;
    private double appAvg;
    private double appMax;
    private double appMin;
    private int appCnt;
}
