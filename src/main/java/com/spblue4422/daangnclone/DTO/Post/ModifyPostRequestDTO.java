package com.spblue4422.daangnclone.DTO.Post;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
public class ModifyPostRequestDTO {
    private long postId;
    private int categoryId;
    private String title;
    private String content;
    private int price;

    public ModifyPostRequestDTO(long postId, int categoryId, String title, String content, int price) {
        this.postId = postId;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.price = price;
    }
}
