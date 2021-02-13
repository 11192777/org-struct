package pers.common.orgstruct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.common.orgstruct.entity.PhoneToken;

/**
 * @Author Qingyu
 * @Date 2021/2/13 15:26
 * @Version 1.0
 */
public interface PhoneTokenService extends IService<PhoneToken> {

	/**
	 * 发送验证码
	 * @param account
	 */
	void sendToken(String account);
}
