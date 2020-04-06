package cn.classyex.learn.jpademo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @date 2020/4/6 16:52 <br>
 * @author yex <br>
 * @version 1.0 <br>
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -3490195998349219253L;

    @Version
    @Column(name = "version")
    protected Integer version;
    @Column(name = "create_time")
    protected LocalDateTime createTime;
    @Column(name = "update_time")
    protected LocalDateTime updateTime;

    public BaseEntity() {
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @PrePersist
    void createdAt() {
        this.createTime = this.updateTime = LocalDateTime.now();
    }

    @PreUpdate
    void updatedAt() {
        this.updateTime = LocalDateTime.now();
    }

}
