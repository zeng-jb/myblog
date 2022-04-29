package com.zeng.dao;

import com.zeng.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeDao {

    //新增分类
    int saveType(Type type);
    //删除分类
    void deleteType(Long id);
    //更新分类
    int updateType(Type type);
    //返回所有分类
    List<Type> getAllType();
    //根据id获取分类
    Type getType(Long id);
    //根据分类名获取分类
    Type getTypeByName(String name);

    //查询所有博客的分类
    List<Type> getAllTypeAndBlog();
}
