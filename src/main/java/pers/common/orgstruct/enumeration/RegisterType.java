package pers.common.orgstruct.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author Qingyu
 * @Date 2021/2/12 23:47
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum RegisterType {
	/**
	 * 手机号
	 */
	PHONE_NUMBER("phone"),

	/**
	 * 邮箱
	 */
	EMAIL("email");

	private String type;
}
