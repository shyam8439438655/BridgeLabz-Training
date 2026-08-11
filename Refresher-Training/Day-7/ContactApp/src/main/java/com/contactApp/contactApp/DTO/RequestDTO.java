package com.contactApp.contactApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RequestDTO {
    private String name;
    private String email;
    private String mobNo;

}
