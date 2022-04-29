package com.zeng.service;

import com.zeng.pojo.Message;

import java.util.List;

public interface MessageService {
    //查询留言信息
    List<Message> listMessages();

    //添加保存留言
    int saveMessage(Message message);

    //删除留言
    void deleteMessage(Long id);
}
