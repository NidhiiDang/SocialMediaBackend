package com.nidhi.social_media.Dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    @NotEmpty
    @Size(min = 3, message = "user name should have at least 3 characters")
    private String firstName;
    private String lastName;
    @NotEmpty
    @Size(min = 5, message = "user name should have at least 5 characters")
    private String username;

    @NotEmpty
    @Size(min = 8, message = "user name should have at least 8 characters one uppercase one lowercase one numeric and one special")
    private String password;

}
