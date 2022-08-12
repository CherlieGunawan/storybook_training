package id.co.nds.storybook.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.storybook.entities.StoryEntity;

@Repository
public interface StoryRepo extends JpaRepository<StoryEntity, String>, JpaSpecificationExecutor<StoryEntity> {
    @Query(value = "SELECT COUNT(*) FROM ms_story WHERE LOWER(name) = LOWER(:name)", nativeQuery = true)
    long countByName(@Param("name") String name);
}
