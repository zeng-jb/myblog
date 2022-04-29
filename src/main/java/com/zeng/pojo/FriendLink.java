package com.zeng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendLink {
    private Long id;
    private String blogaddress;
    private String blogname;
    private String pictureaddress;
    private Date createTime;
}
