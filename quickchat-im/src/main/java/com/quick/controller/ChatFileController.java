package com.quick.controller;

import com.quick.enums.ResponseEnum;
import com.quick.response.R;
import com.quick.service.QuickChatFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author 徐志斌
 * @Date: 2024/3/3 16:29
 * @Version 1.0
 * @Description: 文件控制器
 */
@Controller
@RequestMapping("/file")
public class ChatFileController {
    @Autowired
    private QuickChatFileService fileService;

    /**
     * 上传文件
     *
     * @param type 文件类型
     * @param file 文件实体信息
     * @return 响应信息
     */
    @ResponseBody
    @PostMapping("/upload/{type}")
    public R uploadFile(@PathVariable int type, MultipartFile file) throws Exception {
        String url = fileService.uploadFile(type, file);
        return R.out(ResponseEnum.SUCCESS, url);
    }

    /**
     * 文件下载功能
     *
     * @param type 文件类型
     * @param url  文件url
     * @return 响应信息
     */
    @GetMapping("/download/{type}")
    public R downloadFile(@PathVariable int type, String url) {
        fileService.downloadFile(type, url);
        return R.out(ResponseEnum.SUCCESS);
    }
}
