package com.zeng.service;

import com.zeng.dao.MessageDao;
import com.zeng.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageDao messageDao;

    //存放迭代找出的所有子代的集合
    private List<Message> tempReplys = new ArrayList<>();

    @Override
    public List<Message> listMessages() {
        List<Message> messageList = messageDao.findParentIdNull(Long.parseLong("-1"));
        for (Message message : messageList) {
            Long id = message.getId();
            String parentNickname1 = message.getNickname();
            List<Message> childMessages = messageDao.findParentIdNotNull(id);
            //查询出子评论
            combineChildren(childMessages, parentNickname1);
            message.setReplyMessages(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return messageList;
    }


    private void combineChildren( List<Message> childMessages, String parentNickname1) {
        //判断是否有一级子评论
        if(childMessages.size() > 0){
            //循环找出子评论的id
            for(Message childMessage : childMessages){
                String parentNickname = childMessage.getNickname();
                childMessage.setParentNickname(parentNickname1);
                tempReplys.add(childMessage);
                Long childId = childMessage.getId();
                //查询出子二级评论
                recursively( childId, parentNickname);
            }
        }
    }


    private void recursively( Long childId, String parentNickname1) {
        //根据子一级评论的id找到子二级评论
        List<Message> replayMessages = messageDao.findAndReplayId(childId);

        if(replayMessages.size() > 0){
            for(Message replayComment : replayMessages){
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(replayId,parentNickname);
            }
        }
    }

    @Override
    public int saveMessage(Message message) {
        message.setCreateTime(new Date());
        return messageDao.saveMessage(message);
    }

    @Override
    public void deleteMessage(Long id) {
        messageDao.deleteMessage(id);
    }
}
