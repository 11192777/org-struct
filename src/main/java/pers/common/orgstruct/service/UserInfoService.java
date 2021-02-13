package pers.common.orgstruct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.common.orgstruct.entity.Tenant;
import pers.common.orgstruct.entity.UserInfo;
import pers.common.orgstruct.dto.UserInfoDTO;
import pers.common.orgstruct.entity.UserInfo;

/**
 * @Author Qingyu
 * @Date 2021/2/12 23:17
 * @Version 1.0
 */
public interface UserInfoService extends IService<UserInfo> {

	void userLoginByPhone(String phoneNumber, String password);

	/**
	 * 保存用户信息
	 * @param userInfoDTO
	 */
	Long saveUserInfo(UserInfoDTO userInfoDTO);

	/**
	 * 通过账户查询用户信息
	 * @param account
	 * @return
	 */
	UserInfo queryByAccount(String account);
}
