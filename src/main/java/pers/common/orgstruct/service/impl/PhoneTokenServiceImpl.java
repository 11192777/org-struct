package pers.common.orgstruct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.common.orgstruct.entity.PhoneToken;
import pers.common.orgstruct.mapper.PhoneTokenMapper;
import pers.common.orgstruct.service.PhoneTokenService;

/**
 * @Author Qingyu
 * @Date 2021/2/13 15:26
 * @Version 1.0
 */
@Service
public class PhoneTokenServiceImpl extends ServiceImpl<PhoneTokenMapper, PhoneToken> implements PhoneTokenService{

	@Autowired
	private PhoneTokenMapper phoneTokenMapper;

	/**
	 * 发送验证码
	 * @param account
	 */
	@Override
	public void sendToken(String account) {
		PhoneToken phoneToken = PhoneToken.builder()
				.code()
	}
}
