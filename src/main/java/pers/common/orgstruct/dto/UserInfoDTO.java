package pers.common.orgstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

/**
 * @Author Qingyu
 * @Date 2021/2/12 22:32
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserInfoDTO {

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
	 * 登陆账号
	 */
	private String loginAccount;

	/**
	 * 登陆密码
	 */
	private String loginPassword;

	/**
	 * 创建时间
	 */
	private LocalDateTime createdDate;

	/**
	 * 创建人
	 */
	private Long createdBy;

	/**
	 * 最后更新日期
	 */
	private LocalDateTime lastModifiedDate;

	/**
	 * 更新人
	 */
	private Long lastModifiedBy;


}
