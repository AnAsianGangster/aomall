package com.anasiangangster.aomall001.service.impl;

import com.anasiangangster.aomall001.entity.User;
import com.anasiangangster.aomall001.mapper.UserMapper;
import com.anasiangangster.aomall001.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 奥博
 * @since 2021-07-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
