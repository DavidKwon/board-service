package kr.co.iclave.board.controller.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@RequiredArgsConstructor
@Schema(description = "기초 게시글 모델")
public class BasePostModel {

    @Schema(description = "게시글 제목")
    private String title;

    @Schema(description = "게시글 내용")
    private String content;
}
