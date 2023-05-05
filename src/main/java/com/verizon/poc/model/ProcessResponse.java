package com.verizon.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProcessResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
}
