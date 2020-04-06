package cn.classyex.learn.jpademo.repo;

import cn.classyex.learn.jpademo.domain.WxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author yex
 * @date 2020/4/6 16:57
 */
public interface WxUserRepo extends JpaRepository<WxUser, Long>, PagingAndSortingRepository<WxUser, Long>,
        QuerydslPredicateExecutor<WxUser> {
}
