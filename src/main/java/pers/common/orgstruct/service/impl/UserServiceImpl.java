package pers.common.orgstruct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.common.orgstruct.dto.UserDTO;
import pers.common.orgstruct.dto.UserInfoDTO;
import pers.common.orgstruct.entity.PhoneToken;
import pers.common.orgstruct.entity.User;
import pers.common.orgstruct.entity.UserInfo;
import pers.common.orgstruct.enumeration.RegisterType;
import pers.common.orgstruct.exception.BusinessException;
import pers.common.orgstruct.mapper.UserInfoMapper;
import pers.common.orgstruct.mapper.UserMapper;
import pers.common.orgstruct.service.PhoneTokenService;
import pers.common.orgstruct.service.UserInfoService;
import pers.common.orgstruct.service.UserService;
import pers.common.orgstruct.utils.MD5Util;
import pers.common.orgstruct.utils.SecurityUtil;
import pers.common.orgstruct.utils.StringUtils;
import pers.common.orgstruct.vo.UserVO;

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
	@Autowired
	private PhoneTokenService phoneTokenService;

	/**
	 * 用户注册
	 * @param account
	 * @param password
	 * @param passwordRepeat
	 * @param token             验证码
	 * @param registerType      注册方式
	 */
	@Override
	@Transactional
	public void userRegister(String account, String password, String passwordRepeat, String token, RegisterType registerType) {
		if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password) || StringUtils.isEmpty(passwordRepeat)) {
			throw new BusinessException("缺少必填参数");
		}

		if (!password.equals(passwordRepeat)){
			throw new BusinessException("密码不一致");
		}

		UserInfo userInfo = userInfoService.queryByAccount(account);
		if (userInfo != null){
			throw new BusinessException("该用户已经被注册！");
		}

		if (RegisterType.PHONE_NUMBER.equals(registerType)){
			PhoneToken phoneToken = phoneTokenService.queryByAccount(account);
			if (phoneToken == null || !phoneToken.getTokenValue().equals(token)){
				throw new BusinessException("验证码错误");
			}
		}

		UserDTO userDTO = UserDTO.builder()
				.email(registerType.equals(RegisterType.EMAIL) ? account : null)
				.phoneNumber(registerType.equals(RegisterType.PHONE_NUMBER) ? account : null)
				.password(password)
				.build();

		this.saveUser(userDTO);

	}

	@Override
	public UserVO queryUserByConcatId(Long id) {
		return userMapper.selectUserByConcatId(id);

			/*Maper : select insert delete update
			Service: query save remove update	*/

	}

	/**
	 * 保存用户信息
	 */
	@Override
	@Transactional
	public Long saveUser(UserDTO userDTO) {

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

		return user.getId();
	}

}
