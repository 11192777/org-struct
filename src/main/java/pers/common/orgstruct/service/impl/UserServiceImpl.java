package pers.common.orgstruct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.common.orgstruct.dto.UserDTO;
import pers.common.orgstruct.dto.UserInfoDTO;
import pers.common.orgstruct.entity.User;
import pers.common.orgstruct.enumeration.RegisterType;
import pers.common.orgstruct.exception.BusinessException;
import pers.common.orgstruct.mapper.UserMapper;
import pers.common.orgstruct.service.UserInfoService;
import pers.common.orgstruct.service.UserService;
import pers.common.orgstruct.utils.MD5Util;
import pers.common.orgstruct.utils.SecurityUtil;
import pers.common.orgstruct.utils.StringUtils;

import java.time.LocalDateTime;

/**
 * @Author Qingyu
 * @Date 2021/2/8 18:49
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 用户注册
	 * @param account
	 * @param password
	 * @param passwordRepeat
	 * @param registerType      注册方式
	 */
	@Override
	public void userRegister(String account, String password, String passwordRepeat, RegisterType registerType) {
		if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password) || StringUtils.isEmpty(passwordRepeat)) {
			throw new BusinessException("缺少必填参数");
		}

		if (!password.equals(passwordRepeat)){
			throw new BusinessException("密码不一致");
		}

		UserDTO userDTO = UserDTO.builder()
				.email(registerType.equals(RegisterType.EMAIL) ? account : null)
				.phoneNumber(registerType.equals(RegisterType.PHONE_NUMBER) ? account : null)
				.build();

		this.saveUser(userDTO);
	}

	/**
	 * 保存用户信息
	 */
	@Override
	public void saveUser(UserDTO userDTO) {

		UserInfoDTO userInfoDTO = UserInfoDTO.builder()
				.phoneNumber(userDTO.getPhoneNumber())
				.email(userDTO.getEmail())
				.loginAccount(userDTO.getPhoneNumber() != null ? userDTO.getPhoneNumber() : userDTO.getEmail())
				.loginPassword(MD5Util.digest(userDTO.getPassword()))
				.build();

		Long concatId = userInfoService.saveUserInfo(userInfoDTO);

		LocalDateTime nowTime = LocalDateTime.now();

		User user = User.builder()
				.isActivated(true)
				.isEnabled(true)
				.isDeleted(false)
				.createdBy(SecurityUtil.getCurrentUserId())
				.lastModifiedBy(SecurityUtil.getCurrentUserId())
				.activatedDate(nowTime)
				.createdDate(nowTime)
				.lastModifiedDate(nowTime)
				.tenantId(SecurityUtil.getTenantId())
				.concatId(concatId)
				.build();

		userMapper.insert(user);

	}
}
