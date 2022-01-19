package com.spblue4422.daangnclone.DTO.Post;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class AddPostRequestDTO {
    private int categoryId;
    private String title;
    private String content;
    private int price;

    public AddPostRequestDTO(int categoryId, String title, String content, int price) {
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.price = price;
    }
}
