package com.nidhi.social_media.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReelsDto {

    private String title;
    @NotEmpty
    private String video;
}
