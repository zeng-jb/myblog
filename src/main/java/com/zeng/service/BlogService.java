package com.zeng.service;

import com.zeng.pojo.Blog;
import com.zeng.queryvo.*;

import java.util.List;

public interface BlogService {
    //新增博客
    int saveBlog(Blog blog);
    //查询文章管理列表
    List<BlogQuery> getAllBlogQuery();
    //删除博客
    void deleteBlog(Long id);

    //编辑博客
    int updateBlog(BlogShow blogShow);
    //查询编辑修改的文章
    BlogShow getBlogById(Long id);

    //搜索博客管理列表
    List<BlogQuery> getBlogBySearch(BlogSearch blogSearch);




    //查询首页最新博客列表信息
    List<FirstPageBlog> getAllFirstPageBlog();

    //查询首页最新推荐信息
    List<RecommendBlog> getRecommendedBlog();

    //搜索博客列表
    List<FirstPageBlog> getSearchBlog(String query);

    //统计博客总数
    Integer getBlogTotal();

    //统计访问总数
    Integer getBlogViewTotal();

    //统计评论总数
    Integer getBlogCommentTotal();

    //统计留言总数
    Integer getBlogMessageTotal();


    //博客详情页

    //查询博客详情
    DetailedBlog getDetailedBlog(Long id);


    //根据TypeId查询博客列表，显示在分类页面
    List<FirstPageBlog> getByTypeId(Long typeId);
}
