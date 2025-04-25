package com.abbou.marjane.response;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private Object data;

}
