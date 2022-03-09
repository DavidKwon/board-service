package kr.co.iclave.board.controller.api.front;

import kr.co.iclave.board.controller.model.PostModel;
import kr.co.iclave.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/front")
@RequiredArgsConstructor
public class FrontBoardController {

    private final PostService postService;

    @GetMapping("/boards")
    public ResponseEntity<List<PostModel>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/boards/{id}")
    public ResponseEntity<PostModel> getSinglePost(@PathVariable("id") Long id) {
        return ResponseEntity.ok(postService.getSinglePost(id));
    }

    @PostMapping("/boards")
    public ResponseEntity<Object> createSinglePost(@RequestBody PostModel postModel) {
        postService.createSinglePost(postModel.getTitle(), postModel.getContent());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/boards")
    public ResponseEntity<Object> updateSinglePost(@RequestBody PostModel postModel) {
        postService.updateSinglePost(postModel.getId(), postModel.getTitle(), postModel.getContent());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/boards/{id}")
    public ResponseEntity<Object> deleteSinglePost(@PathVariable("id") Long id) {
        postService.deletePostById(id);
        return ResponseEntity.ok().build();
    }
}
