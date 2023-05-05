package com.verizon.poc.repository;

import com.verizon.poc.model.Download;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DownloadRepository {

    public List<Download> getDownloadData(){
        Download download1 = new Download("AT&T", 257.3, 1729.4, 0.5, 12005);
        Download download2 = new Download("T-Mobile", 271.2, 1729.4, 0.5, 12005);
        Download download3 = new Download("Verizon", 1202.0, 1729.4, 0.5, 12005);
        List<Download> list = new ArrayList<>();
        list.add(download1);
        list.add(download2);
        list.add(download3);
        return list;
    }
}
