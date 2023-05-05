package com.verizon.poc.service;

import com.verizon.poc.model.Chart;
import com.verizon.poc.repository.DownloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChartService {


    public Chart getChart(){
        Chart chart = new Chart("Demo change");
        return chart;
    }
}
