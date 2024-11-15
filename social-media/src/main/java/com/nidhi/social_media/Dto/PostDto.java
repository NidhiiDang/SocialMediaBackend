package com.nidhi.social_media.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {

    private String caption;
    @NotEmpty
    private String image;
    private String video;

}
