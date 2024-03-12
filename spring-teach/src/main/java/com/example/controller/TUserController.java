package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.TUser;
import com.example.service.TUserService;
import com.example.utils.MyResult;
import com.example.utils.MyResultBuilder;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class TUserController {
    @Autowired
    private TUserService userService;

    @Operation(summary = "用户分页")
    @GetMapping("/page")
    public MyResult page(@RequestParam(value = "current", defaultValue = "1") Long current,
                         @RequestParam(value = "size", defaultValue = "10") Long size) {
        Page<TUser> page = userService.page(new Page<>(current, size));
        return MyResultBuilder.success(page);
    }

    @Operation(summary = "用户列表")
    @GetMapping("/list")
    public MyResult list() {
        List<TUser> list = userService.list();
        return MyResultBuilder.success(list);
    }

    @Operation(summary = "根据id查询用户")
    @GetMapping("/{id}")
    public MyResult getById(@PathVariable String id) {
        TUser user = userService.getById(id);
        return MyResultBuilder.success(user);
    }

    @Operation(summary = "添加或修改用户")
    @PostMapping("/saveOrUpdate")
    public MyResult saveOrUpdate(@RequestBody TUser user) {

        if (user.getId() != null && user.getId().length() > 0) {
            userService.saveOrUpdate(user);
            return MyResultBuilder.success("修改成功");
        } else {
            user.setId(UUID.randomUUID().toString());
            userService.saveOrUpdate(user);
            return MyResultBuilder.success("添加成功");
        }
    }

    @Operation(summary = "删除用户")
    @DeleteMapping("/{id}")
    public MyResult delete(@PathVariable String id) {
        boolean remove = userService.removeById(id);
        if (remove) {
            return MyResultBuilder.success("删除用户成功");
        } else {
            return MyResultBuilder.success("删除用户失败");
        }
    }
}
