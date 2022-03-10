package kr.co.iclave.board.controller.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@RequiredArgsConstructor
public class BasePostModel {

    private String title;

    private String content;
}
