package pers.common.orgstruct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.common.orgstruct.entity.UserInfo;
import pers.common.orgstruct.exception.BusinessException;
import pers.common.orgstruct.mapper.UserInfoMapper;
import pers.common.orgstruct.mapper.UserMapper;
import pers.common.orgstruct.service.UserInfoService;
import pers.common.orgstruct.utils.SecurityUtil;
import pers.common.orgstruct.vo.UserVO;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void userLoginByPhone(String phoneNumber, String password) {
        UserInfo userInfo = userInfoMapper.queryUser(phoneNumber, password);
        if (userInfo == null) {
            throw new BusinessException("账号或者密码错误");
        }else {
            UserVO userVO = SecurityUtil.getCurrentUser();
            if (userVO != null) {
                throw new BusinessException("该用户已登录");
            }
        }

    }
}
