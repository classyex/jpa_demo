package cn.classyex.learn.jpademo.service;

import cn.classyex.learn.jpademo.domain.Tag;

import java.util.List;

/**
 * @author yex
 * @date 2020/4/6 18:30
 */
public interface TagService {

    /**
     * listByWxUserId <br>
     * @version 1.0 <br>
     * @date 2020/4/6 18:34 <br>
     * @author yex <br>
     *
     * @param wxUserId
     * @return java.util.List<cn.classyex.learn.jpademo.domain.Tag>
     */
    List<Tag> listByWxUserId(Long wxUserId);
}
