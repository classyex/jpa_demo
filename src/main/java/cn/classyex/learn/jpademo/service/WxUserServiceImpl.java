package cn.classyex.learn.jpademo.service;

import cn.classyex.learn.jpademo.domain.QWxUser;
import cn.classyex.learn.jpademo.domain.WxUser;
import cn.classyex.learn.jpademo.model.WxUserVO;
import cn.classyex.learn.jpademo.repo.WxUserRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yex
 * @date 2020/4/6 17:07
 */
@Service
@AllArgsConstructor
public class WxUserServiceImpl implements WxUserService {

    private WxUserRepo wxUserRepo;
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<WxUser> list(WxUserVO vo) {
        QWxUser qWxUser = QWxUser.wxUser;
        PageRequest pageRequest = vo.toPageRequest();
        List<WxUser> fetch = jpaQueryFactory.selectFrom(qWxUser).where(vo.buildPredicate())
                .offset(pageRequest.getOffset())
                .limit(pageRequest.getPageSize())
                .orderBy(qWxUser.createTime.asc()).fetch();
        return fetch;
    }
}
