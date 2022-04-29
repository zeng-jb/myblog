package com.zeng.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeng.pojo.Type;
import com.zeng.queryvo.FirstPageBlog;
import com.zeng.service.BlogService;
import com.zeng.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeShowController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    //分页查询分类

    /**
     * {id}：当id为-1时，表示从首页导航栏进入分类页面，默认第一个分类显示颜色
     *
     * getAllTypeAndBlog：查询分类名称和博客信息，前端统计出该分类下博客数量
     *
     * getByTypeId：查询博客列表
     * @param pageNum
     * @param id    分类的id
     * @param model
     * @return  types页面
     */
    @GetMapping("/types/{id}")
    public String types(@RequestParam(defaultValue = "1" , value = "pageNum") Integer pageNum, @PathVariable Long id, Model model){
        List<Type> allTypeAndBlog = typeService.getAllTypeAndBlog();

        //id 为 -1 表示从首页导航栏进入分类页面
        if(id == -1){
            id = allTypeAndBlog.get(0).getId();
        }
        model.addAttribute("types",allTypeAndBlog);
        List<FirstPageBlog> byTypeId = blogService.getByTypeId(id);
        PageHelper.startPage(pageNum,100);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(byTypeId);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTypeId", id);
        return "types";
    }
}
