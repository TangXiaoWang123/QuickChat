package com.quick.controller;

import com.quick.enums.ResponseEnum;
import com.quick.pojo.vo.ChatSessionVO;
import com.quick.response.R;
import com.quick.service.QuickChatSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 徐志斌
 * @Date: 2023/11/19 11:11
 * @Version 1.0
 * @Description: 聊天会话
 */
@RestController
@RequestMapping("/chat/session")
public class ChatSessionController {
    @Autowired
    private QuickChatSessionService sessionService;

    /**
     * 查询聊天会话列表
     */
    @GetMapping("/list")
    public R getSessionList() {
        List<ChatSessionVO> result = sessionService.getSessionList();
        return R.out(ResponseEnum.SUCCESS, result);
    }

    /**
     * 未读数清 0
     */
    @PutMapping("/clearUnread/{sessionId}")
    public R clearUnread(@PathVariable Long sessionId) {
        sessionService.clearUnread(sessionId);
        return R.out(ResponseEnum.SUCCESS);
    }

    /**
     * 删除聊天会话
     */
    @DeleteMapping("/delete/{sessionId}")
    public R deleteSession(@PathVariable Long sessionId) {
        sessionService.deleteSession(sessionId);
        return R.out(ResponseEnum.SUCCESS);
    }

    /**
     * 置顶聊天会话
     */
    @PostMapping("/top/{id}")
    public R topSession(@PathVariable Long id) {
        return R.out(ResponseEnum.SUCCESS);
    }
}