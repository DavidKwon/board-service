package kr.co.iclave.board.service.dao;

import kr.co.iclave.board.persistence.entity.PostEntity;
import kr.co.iclave.board.persistence.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostDao {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostEntity> findAllPosts() {
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PostEntity findPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
    }

    @Transactional
    public void savePost(String title, String content) {
        PostEntity newPost = PostEntity.builder()
                .title(title)
                .content(content)
                .build();

        savePost(newPost);
    }

    @Transactional
    public void savePost(PostEntity postEntity) {
        postRepository.save(postEntity);
    }

    @Transactional
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}
