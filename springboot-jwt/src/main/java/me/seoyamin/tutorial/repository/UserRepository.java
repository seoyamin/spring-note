package me.seoyamin.tutorial.repository;

import me.seoyamin.tutorial.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository를 extends하면 기본적인 메소드 (findAll, save 등) 사용 가능
public interface UserRepository extends JpaRepository<User, Long> {

    // @EntityGraph : query 수행 시, Lazy가 아닌 Eager 조회를 통해 authorities 정보도 같이 가져올 수 있음
    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsername(String username);

}
