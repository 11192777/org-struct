package pers.common.orgstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Qingyu
 * @Date 2021/2/12 23:02
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {

	/**
	 * 用户名称
	 */
	private String userName;

	/**
	 * 手机号
	 */
	private String phoneNumber;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 登陆密码
	 */
	private String password;

}
