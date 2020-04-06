package cn.classyex.learn.jpademo.service;

import cn.classyex.learn.jpademo.domain.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author yex
 * @date 2020/4/6 18:29
 */
@SpringBootTest
public class TagServiceTest {

    @Autowired
    private TagService tagService;

    @Test
    public void listByWxUserId() {
        Long wxUserId = 1L;
        List<Tag> list = tagService.listByWxUserId(wxUserId);
        Assertions.assertEquals(1, list.size());
    }

}
