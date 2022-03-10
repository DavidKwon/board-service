package kr.co.iclave.board.controller.api.front;

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
public class FrontBoardController {

    private final PostService postService;

    @GetMapping("/boards/posts")
    public ResponseEntity<List<PostModel>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/boards/posts/{id}")
    public ResponseEntity<PostModel> getSinglePost(@PathVariable("id") Long id) {
        return ResponseEntity.ok(postService.getSinglePost(id));
    }

    @PostMapping("/boards/posts")
    public ResponseEntity<Object> createSinglePost(@RequestBody BasePostModel basePostModel) {
        postService.createSinglePost(basePostModel.getTitle(), basePostModel.getContent());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/boards/posts/{id}")
    public ResponseEntity<Object> updateSinglePost(
            @PathVariable("id") Long id,
            @RequestBody BasePostModel basePostModel
    ) {
        postService.updateSinglePost(id, basePostModel.getTitle(), basePostModel.getContent());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/boards/posts/{id}")
    public ResponseEntity<Object> deleteSinglePost(@PathVariable("id") Long id) {
        postService.deletePostById(id);
        return ResponseEntity.ok().build();
    }
}
