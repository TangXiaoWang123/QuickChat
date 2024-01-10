package com.quick.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author 徐志斌
 * @Date: 2023/11/25 12:47
 * @Version 1.0
 * @Description: 聊天会话VO
 */
@Data
public class ChatSessionVO {
    /**
     * 目标账号id
     */
    private String toId;
    /**
     * 名称
     */
    private String name;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 在线状态（针对用户）
     */
    private String lineStatus;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
