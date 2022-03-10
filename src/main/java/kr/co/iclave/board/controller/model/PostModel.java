package kr.co.iclave.board.controller.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class PostModel extends BasePostModel {

    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
