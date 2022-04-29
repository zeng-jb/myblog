package com.zeng.queryvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 编辑博客时在前台显示内容实体类
 * 查询出需要编辑的博客信息，并使用getBlogById(id)查询出需要编辑修改的博客
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogShow {
    private Long id;
    private String flag;
    private String title;
    private String content;
    private Long typeId;
    private String firstPicture;
    private String description;
    private boolean recommend;
    private boolean published;
    private boolean shareStatement;
    private boolean appreciation;
    private boolean commentabled;
    private Date updateTime;
}
