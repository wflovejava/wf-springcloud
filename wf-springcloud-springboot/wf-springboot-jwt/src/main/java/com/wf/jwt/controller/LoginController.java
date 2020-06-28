package com.wf.jwt.controller;

import com.wf.common.dto.Response;
import com.wf.common.entity.User;
import com.wf.common.service.UserService;
import com.wf.common.util.ResponseUtils;
import com.wf.jwt.dto.UserDto;
import com.wf.jwt.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：wf
 * @Date ：2020/6/24 14:06
 * @Describe：
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @RequestMapping("/login")
    public Response login(@RequestBody UserDto userDto) {
        User user = userService.queryById(userDto.getUserId());
        if (user == null) {
            return ResponseUtils.failure("用户不存在！");
        }
        if (!user.getPwd().equals(userDto.getPwd())) {
            return ResponseUtils.failure("用户密码不正确！");
        } else {
            String token = jwtTokenUtil.getToken(user);
            return ResponseUtils.success(token);
        }
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("/get")
    public Response<User> get(Integer id) {
        User user = this.userService.queryById(id);
        return ResponseUtils.success(user);
    }

}
