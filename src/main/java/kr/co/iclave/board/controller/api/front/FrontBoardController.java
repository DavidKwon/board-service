package kr.co.iclave.board.controller.api.front;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.iclave.board.controller.model.BasePostModel;
import kr.co.iclave.board.controller.model.PostModel;
import kr.co.iclave.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/front")
@RequiredArgsConstructor
@Tag(name = "게시판 API")
public class FrontBoardController {

    private final PostService postService;

    @GetMapping("/boards/posts")
    @Operation(summary = "모든 게시글 조회")
    public ResponseEntity<List<PostModel>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/boards/posts/{id}")
    @Operation(summary = "특정 id 에 해당하는 게시글 조회")
    public ResponseEntity<PostModel> getSinglePost(
            @Parameter(description = "게시글 id") @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok(postService.getSinglePost(id));
    }

    @PostMapping("/boards/posts")
    @Operation(summary = "제목, 내용으로 게시글 생성")
    public ResponseEntity<Object> createSinglePost(
            @RequestBody BasePostModel basePostModel
    ) {
        postService.createSinglePost(basePostModel.getTitle(), basePostModel.getContent());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/boards/posts/{id}")
    @Operation(summary = "게시글 id, 제목, 내용으로 게시글 수정")
    public ResponseEntity<Object> updateSinglePost(
            @Parameter(description = "게시글 id") @PathVariable("id") Long id,
            @RequestBody BasePostModel basePostModel
    ) {
        postService.updateSinglePost(id, basePostModel.getTitle(), basePostModel.getContent());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/boards/posts/{id}")
    @Operation(summary = "특정 id 에 해당하는 게시글 삭제")
    public ResponseEntity<Object> deleteSinglePost(
            @Parameter(description = "게시글 id") @PathVariable("id") Long id
    ) {
        postService.deletePostById(id);
        return ResponseEntity.ok().build();
    }
}
