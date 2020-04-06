package cn.classyex.learn.jpademo.model;

import cn.classyex.learn.jpademo.common.Const;
import cn.classyex.learn.jpademo.common.PageParams;
import cn.classyex.learn.jpademo.domain.QTag;
import cn.classyex.learn.jpademo.domain.QUserTag;
import cn.classyex.learn.jpademo.domain.QWxUser;
import cn.hutool.core.util.StrUtil;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Optional;

import static cn.classyex.learn.jpademo.common.Const.BEIJING_ZONE;
import static cn.classyex.learn.jpademo.common.Const.DATE_SIMPLE_FMT;

/**
 * @author yex
 * @date 2020/4/6 17:13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxUserVO extends PageParams {

    private String appId;
    private String keyword;
    private String openId;
    private String unionId;
    private Const.Status status;
    @DateTimeFormat(pattern = DATE_SIMPLE_FMT)
    private LocalDate subscribeStartTime;
    @DateTimeFormat(pattern = DATE_SIMPLE_FMT)
    private LocalDate subscribeEndTime;
    private Boolean subscribe;
    private Long tagId;

    public Predicate buildPredicate() {
        QWxUser qWxUser = QWxUser.wxUser;
        QUserTag qUserTag = QUserTag.userTag;
        QTag qTag = QTag.tag;
        BooleanBuilder predicate = new BooleanBuilder();
        if (StrUtil.isNotBlank(appId)) {
            predicate.and(qWxUser.appId.eq(appId));
        }
        if (StrUtil.isNotBlank(keyword)) {
            String fuzzKeyword = "%" + keyword + "%";
            predicate.and(qWxUser.wxUserId.stringValue().like(fuzzKeyword).or(qWxUser.nickname.like(fuzzKeyword)));
        }
        if (StrUtil.isNotBlank(openId)) {
            predicate.and(qWxUser.openId.eq(openId));
        }
        if (StrUtil.isNotBlank(unionId)) {
            predicate.and(qWxUser.unionId.eq(unionId));
        }
        Optional.ofNullable(status).ifPresent(status -> predicate.and(qWxUser.status.eq(status)));
        Optional.ofNullable(subscribeStartTime).ifPresent(subscribeStartTime ->
                predicate.and(qWxUser.subscribeTime.gt(subscribeStartTime.atStartOfDay(BEIJING_ZONE).toEpochSecond())));
        Optional.ofNullable(subscribeEndTime).ifPresent(subscribeEndTime ->
                predicate.and(qWxUser.subscribeTime.lt(subscribeEndTime.plusDays(1).atStartOfDay(BEIJING_ZONE).toEpochSecond())));
        Optional.ofNullable(subscribe).ifPresent(subscribe -> predicate.and(qWxUser.subscribe.eq(subscribe)));

        Optional.ofNullable(tagId).ifPresent(tagId ->
                predicate.and(JPAExpressions.selectFrom(qUserTag)
                        .where(qWxUser.wxUserId.eq(qUserTag.wxUserId).and(qUserTag.tagId.eq(tagId))).exists()));

        return predicate;
    }
}
