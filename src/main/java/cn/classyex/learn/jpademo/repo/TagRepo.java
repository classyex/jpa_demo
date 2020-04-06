package cn.classyex.learn.jpademo.repo;

import cn.classyex.learn.jpademo.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author yex
 * @date 2020/4/6 17:03
 */
public interface TagRepo extends JpaRepository<Tag, Long>, PagingAndSortingRepository<Tag, Long>,
        QuerydslPredicateExecutor<Tag> {
}
