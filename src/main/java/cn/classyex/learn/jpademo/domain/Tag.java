package cn.classyex.learn.jpademo.domain;

import cn.classyex.learn.jpademo.common.Const;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author yex
 * @date 2020/4/6 17:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wx_tag")
public class Tag extends BaseEntity {

    private static final long serialVersionUID = 1986925313239802795L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    private String tagName;

    private String appId;

    private Const.Status status;


}
