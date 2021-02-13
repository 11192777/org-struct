package pers.common.orgstruct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.common.orgstruct.entity.User;
import pers.common.orgstruct.exception.BusinessException;
import pers.common.orgstruct.mapper.UserInfoMapper;
import pers.common.orgstruct.mapper.UserMapper;
import pers.common.orgstruct.service.UserService;
import pers.common.orgstruct.utils.StringUtils;

/**
 * @Author Qingyu
 * @Date 2021/2/8 18:49
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



	/**
	 * 用户注册
	 * @param account
	 * @param password
	 * @param passwordRepeat
	 */
	@Override
	public void userRegister(String account, String password, String passwordRepeat) {
		if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password) || StringUtils.isEmpty(passwordRepeat)) {
			throw new BusinessException("缺少必填参数");
		}

		if (!password.equals(passwordRepeat)){
			throw new BusinessException("密码不一致");
		}

	}

}
