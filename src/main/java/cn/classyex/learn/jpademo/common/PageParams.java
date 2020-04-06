package cn.classyex.learn.jpademo.common;

import lombok.Data;
import org.springframework.data.domain.PageRequest;

/**
 * @author yex
 * @date 2020/4/6 17:12
 */
@Data
public class PageParams {
    /** 页数 */
    private Integer pageNum;
    /** 每页大小 */
    private Integer pageSize;

    public PageParams() {
        this(1);
    }

    public PageParams(Integer pageNum) {
        this(pageNum, 20);
    }

    public PageParams(Integer pageNum, Integer pageSize) {
        if (pageNum < 1) {
            this.pageNum = 1;
        } else {
            this.pageNum = pageNum;
        }
        if (pageSize < 1) {
            this.pageSize = 20;
        } else {
            this.pageSize = pageSize;
        }
    }

    public PageRequest toPageRequest() {
        return PageRequest.of(pageNum - 1, pageSize);
    }

}
