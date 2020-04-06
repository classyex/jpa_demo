package cn.classyex.learn.jpademo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author yex
 * @date 2020/4/6 17:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wx_user_tag")
public class UserTag extends BaseEntity {

    private static final long serialVersionUID = 2422075884124765667L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userTagId;

    private Long wxUserId;

    private Long tagId;

}
