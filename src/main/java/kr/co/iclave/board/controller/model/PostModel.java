package kr.co.iclave.board.controller.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@Schema(description = "게시글 모델")
public class PostModel extends BasePostModel {

    @Schema(description = "게시글 id")
    private Long id;

    @Schema(description = "게시글 생성 일시")
    private LocalDateTime createdAt;

    @Schema(description = "게시글 수정 일시")
    private LocalDateTime updatedAt;
}
