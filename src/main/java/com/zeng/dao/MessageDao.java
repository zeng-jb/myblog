package com.zeng.dao;


import com.zeng.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageDao {

    //查询父级留言
    List<Message> findParentIdNull( @Param("blogParentId") Long blogParentId);

    //查询一级回复
    List<Message> findParentIdNotNull( @Param("id") Long id);

    //查询二级回复
    List<Message> findAndReplayId(@Param("childId") Long childId);

    //添加一个留言
    int saveMessage(Message message);

    //删除留言
    void deleteMessage(Long id);

}
