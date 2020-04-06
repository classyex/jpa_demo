package cn.classyex.learn.jpademo.service;

import cn.classyex.learn.jpademo.domain.WxUser;
import cn.classyex.learn.jpademo.model.WxUserVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static cn.classyex.learn.jpademo.common.Const.Status.VALID;

/**
 * @author yex
 * @date 2020/4/6 17:20
 */
@SpringBootTest
public class WxUserServiceTest {

    @Autowired
    private WxUserService wxUserService;

    @Test
    public void test_list_by_conditions() {
        WxUserVO vo = new WxUserVO();
        vo.setAppId("1111111");
        vo.setKeyword("张三");
        vo.setOpenId("openid11111");
        vo.setStatus(VALID);
        vo.setSubscribe(true);
        vo.setSubscribeStartTime(LocalDate.of(2020,4,6));
        vo.setSubscribeEndTime(LocalDate.of(2020,4,6));
        vo.setTagId(1L);
        vo.setPageNum(1);
        vo.setPageSize(20);
        List<WxUser> list = wxUserService.list(vo);
        Assertions.assertEquals(5, list.size());
    }




}
