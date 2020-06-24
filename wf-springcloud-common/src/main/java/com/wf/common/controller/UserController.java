package com.wf.common.controller;

import com.wf.common.dto.Response;
import com.wf.common.entity.User;
import com.wf.common.service.UserService;
import com.wf.common.util.ResponseUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-06-23 14:40:55
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public Response<User> selectOne(Integer id) {
        User user = this.userService.queryById(id);
        return ResponseUtils.success(user);
    }

}