package cn.classyex.learn.jpademo.service;

import cn.classyex.learn.jpademo.domain.QTag;
import cn.classyex.learn.jpademo.domain.QUserTag;
import cn.classyex.learn.jpademo.domain.Tag;
import cn.classyex.learn.jpademo.repo.TagRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yex
 * @date 2020/4/6 18:31
 */
@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

    private TagRepo tagRepo;
    private JPAQueryFactory jpaQueryFactory;


    @Override
    public List<Tag> listByWxUserId(Long wxUserId) {
        QTag qTag = QTag.tag;
        QUserTag qUserTag = QUserTag.userTag;
        List<Tag> list = jpaQueryFactory.selectFrom(qTag)
                .innerJoin(qUserTag).on(qTag.tagId.eq(qUserTag.tagId))
                .where(qUserTag.wxUserId.eq(wxUserId)).fetch();
        return list;
    }
}
