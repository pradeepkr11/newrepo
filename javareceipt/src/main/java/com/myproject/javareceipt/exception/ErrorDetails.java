package com.myproject.javareceipt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDetails {
    private String errorMessage;
    private LocalDateTime localDateTime;
}
