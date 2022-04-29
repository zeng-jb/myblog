package com.zeng.controller;


import com.zeng.pojo.Message;
import com.zeng.pojo.User;
import com.zeng.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 留言控制类
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Value("${message.avatar}")
    private String avatar;

    //查询评论列表
    @GetMapping("/messages")
    public String messages(Model model) {
        List<Message> messages = messageService.listMessages();
        model.addAttribute("messages", messages);
        return "message";
    }

//    //局部刷新
//    @GetMapping("/messagecomment")
//    public String messagecomment(Model model){
//        List<Message> messages = messageService.listMessages();
//        model.addAttribute("messages", messages);
//        return "message :: messageList";
//    }


    //新增评论
    @PostMapping("/messages")
    public String post(Message message , HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");
        if (user != null) {
            message.setAvatar(user.getAvatar());
            message.setAdminMessage(true);
        } else {
            //设置头像
            message.setAvatar(avatar);
        }

        if (message.getParentMessage().getId() != null) {
            message.setParentMessageId(message.getParentMessage().getId());
        }
        messageService.saveMessage(message);
        List<Message> messages = messageService.listMessages();
        model.addAttribute("messages", messages);
        return "message :: messageList";
    }

    //删除评论
    @GetMapping("/messages/{id}/delete")
    public String delete(@PathVariable Long id ,RedirectAttributes attributes, Model model){
        messageService.deleteMessage(id);
        return "message";
    }
}
