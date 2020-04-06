package cn.classyex.learn.jpademo.controller;

import cn.classyex.learn.jpademo.domain.WxUser;
import cn.classyex.learn.jpademo.model.WxUserVO;
import cn.classyex.learn.jpademo.service.WxUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yex
 * @date 2020/4/6 17:08
 */
@RestController
@RequestMapping("/wxusers")
@AllArgsConstructor
public class WxUserController {

    private WxUserService wxUserService;

    @GetMapping
    public List<WxUser> list(WxUserVO vo) {
        return wxUserService.list(vo);
    }

}
