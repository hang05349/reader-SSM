package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Member)实体类
 *
 * @author makejava
 * @since 2021-11-22 22:50:39
 */
public class Member implements Serializable {
    private static final long serialVersionUID = -93161243204705142L;
    /**
     * 会员编号
     */
    private Long memberId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐值
     */
    private Integer salt;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 昵称
     */
    private String nickname;


    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}

