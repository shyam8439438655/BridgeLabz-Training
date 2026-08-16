package com.contactApp.contactApp.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestDTO {

    @NotBlank(message = "Name should not be blank")
    @Size(min=2 , max=50 , message = "Name must be within 2 to 50 character")
    private String name;


    @NotBlank
    private String mobNo;

    @Email
    private String email;
}