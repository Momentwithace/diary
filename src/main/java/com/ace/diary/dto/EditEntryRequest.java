package com.ace.diary.dto;

import lombok.Data;

@Data
public class EditEntryRequest {
    private String title;
    private String body;
}
