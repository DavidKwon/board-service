package kr.co.iclave.board.service;

import kr.co.iclave.board.controller.model.PostModel;
import kr.co.iclave.board.persistence.entity.PostEntity;
import kr.co.iclave.board.service.dao.PostDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostDao postDao;

    public PostModel getSinglePost(Long id) {
        PostEntity postEntity = postDao.findPostById(id);

        return convertEntityToModel(postEntity);
    }

    private PostModel convertEntityToModel(PostEntity postEntity) {
        return PostModel.builder()
                .id(postEntity.getId())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .createdAt(postEntity.getCreatedAt())
                .updatedAt(postEntity.getUpdatedAt())
                .build();
    }

    public List<PostModel> getAllPosts() {
        List<PostEntity> allPosts = postDao.findAllPosts();

        return allPosts.stream()
                .map(this::convertEntityToModel)
                .collect(Collectors.toList());
    }

    public void createSinglePost(String title, String content) {
        postDao.savePost(title, content);
    }

    public void updateSinglePost(Long id, String title, String content) {
        PostEntity postEntity = postDao.findPostById(id);

        postDao.savePost(
                PostEntity.builder()
                        .id(postEntity.getId())
                        .title(title)
                        .content(content)
                        .createdAt(postEntity.getCreatedAt())
                        .build()
        );
    }

    public void deletePostById(Long id) {
        postDao.deletePostById(id);
    }
}
