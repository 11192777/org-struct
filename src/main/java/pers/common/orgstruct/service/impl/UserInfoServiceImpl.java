package pers.common.orgstruct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.common.orgstruct.entity.UserInfo;
import pers.common.orgstruct.exception.BusinessException;
import pers.common.orgstruct.mapper.UserInfoMapper;
import pers.common.orgstruct.mapper.UserMapper;
import pers.common.orgstruct.service.UserInfoService;
import pers.common.orgstruct.service.UserService;
import pers.common.orgstruct.utils.MD5Util;
import pers.common.orgstruct.utils.SecurityUtil;
import pers.common.orgstruct.vo.UserVO;
import pers.common.orgstruct.dto.UserInfoDTO;
import pers.common.orgstruct.entity.UserInfo;
import pers.common.orgstruct.mapper.UserInfoMapper;
import pers.common.orgstruct.service.UserInfoService;
import pers.common.orgstruct.utils.SecurityUtil;
import pers.common.orgstruct.utils.StringUtils;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private UserService userService;

	@Override
	public void userLoginByPhone(String phoneNumber, String password, HttpSession session) {
		UserInfo userInfo = userInfoMapper.queryUserByPhoneNumberAndPassword(phoneNumber, MD5Util.digest(password));
		if (userInfo == null) {
			throw new BusinessException("账号或者密码错误");
		}
		UserVO userVO = userService.queryUserByConcatId(userInfo.getId());
		userVO.setUserInfo(userInfo);

		session.setAttribute("currentUser", userVO);

	}

	/**
	 * 通过账户查询用户信息
	 * @param account
	 * @return
	 */
	@Override
	public UserInfo queryByAccount(String account) {
		if (StringUtils.isEmpty(account)){
			return null;
		}
		return userInfoMapper.selectByAccount(account);
	}

	/**
	 * 保存用户信息
	 * @param userInfoDTO
	 */
	@Override
	public Long saveUserInfo(UserInfoDTO userInfoDTO) {

		LocalDateTime nowTime = LocalDateTime.now();

		UserInfo userInfo = UserInfo.builder()
				.phoneNumber(userInfoDTO.getPhoneNumber())
				.email(userInfoDTO.getEmail())
				.loginAccount(userInfoDTO.getLoginAccount())
				.loginPassword(userInfoDTO.getLoginPassword())
				.userName(userInfoDTO.getUserName())
				.createdBy(SecurityUtil.getCurrentUserId())
				.createdDate(nowTime)
				.lastModifiedBy(SecurityUtil.getCurrentUserId())
				.lastModifiedDate(nowTime)
				.build();

		userInfoMapper.insert(userInfo);

		return userInfo.getId();
	}
}

