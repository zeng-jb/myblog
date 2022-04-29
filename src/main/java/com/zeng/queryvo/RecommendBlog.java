package com.zeng.queryvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 首页推荐文章实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendBlog {
    private Long id;
    private String title;
    private String firstPicture;
    private boolean recommend;  //推荐
}
