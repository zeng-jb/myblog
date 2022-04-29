package com.zeng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String nickname;
    private String email;
    private String avatar;  //头像
    private String username;
    private String password;
    private Integer type;
    private Date createTime;
    private Date updateTime;
}
