package pers.common.orgstruct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.common.orgstruct.dto.UserInfoDTO;
import pers.common.orgstruct.entity.UserInfo;
import pers.common.orgstruct.mapper.UserInfoMapper;
import pers.common.orgstruct.service.UserInfoService;
import pers.common.orgstruct.utils.SecurityUtil;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Author Qingyu
 * @Date 2021/2/12 23:18
 * @Version 1.0
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {


	@Autowired
	private UserInfoMapper userInfoMapper;


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
