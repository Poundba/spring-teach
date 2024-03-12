package com.example.mapper;

import com.example.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Daniel
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2024-03-10 18:13:47
* @Entity com.example.entity.TUser
*/
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

}




