package com.example.esciencenewsapp;

import com.example.esciencenewsapp.Models.Headlines;

import java.util.List;

public interface OnFetchDataListener<ApiResponse> {

    void onFetchData(List<Headlines> list, String message);
    void onErrorListener(String message);
}
