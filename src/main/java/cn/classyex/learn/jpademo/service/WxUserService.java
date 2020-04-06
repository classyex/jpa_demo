package cn.classyex.learn.jpademo.service;

import cn.classyex.learn.jpademo.domain.WxUser;
import cn.classyex.learn.jpademo.model.WxUserVO;

import java.util.List;

/**
 * @author yex
 * @date 2020/4/6 17:06
 */
public interface WxUserService {

    /**
     * list <br>
     * @version 1.0 <br>
     * @date 2020/4/6 17:14 <br>
     * @author yex <br>
     *
     * @param vo
     * @return java.util.List<cn.classyex.learn.jpademo.domain.WxUser>
     */
    List<WxUser> list(WxUserVO vo);
}
