package pers.common.orgstruct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.common.orgstruct.entity.User;

/**
 * @Author Qingyu
 * @Date 2021/2/8 18:48
 * @Version 1.0
 */
public interface UserService extends IService<User> {

	/**
	 * 用户注册
	 * @param account
	 * @param password
	 * @param passwordRepeat
	 */
	void userRegister(String account, String password, String passwordRepeat);

}
