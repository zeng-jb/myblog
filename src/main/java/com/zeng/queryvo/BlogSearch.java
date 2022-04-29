package com.zeng.queryvo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查找博客列表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogSearch {
    private String title;
    private Long typeId;
}
