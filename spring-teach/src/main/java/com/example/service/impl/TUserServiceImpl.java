package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.service.TUserService;
import com.example.entity.TUser;
import com.example.mapper.TUserMapper;
import org.springframework.stereotype.Service;

/**
* @author Daniel
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2024-03-10 18:13:47
*/
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
    implements TUserService {

}




