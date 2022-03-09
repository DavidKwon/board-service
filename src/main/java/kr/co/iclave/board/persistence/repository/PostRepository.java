package kr.co.iclave.board.persistence.repository;

import kr.co.iclave.board.persistence.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    @Modifying
    @Query(value = "UPDATE PostEntity p SET p.title = :title, p.content = :content WHERE p.id = :id")
    Integer updateSinglePost(@Param("id") Long id, @Param("title") String title, @Param("content") String content);
}
