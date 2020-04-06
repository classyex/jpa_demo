package cn.classyex.learn.jpademo.repo;

import cn.classyex.learn.jpademo.domain.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author yex
 * @date 2020/4/6 17:05
 */
public interface UserTagRepo extends JpaRepository<UserTag, Long>, PagingAndSortingRepository<UserTag, Long>,
        QuerydslPredicateExecutor<UserTag> {
}
