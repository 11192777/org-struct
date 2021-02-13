package pers.common.orgstruct.controller;

import com.alibaba.druid.sql.dialect.ads.visitor.AdsOutputVisitor;
import com.sun.org.apache.xpath.internal.SourceTreeManager;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.common.orgstruct.dto.ResponseDataDTO;
import pers.common.orgstruct.service.UserInfoService;
import pers.common.orgstruct.service.UserService;

import javax.servlet.http.HttpSession;
import pers.common.orgstruct.enumeration.RegisterType;
import pers.common.orgstruct.service.UserService;

import java.time.OffsetTime;

/**
 * @Author Qingyu
 * @Date 2021/2/12 18:19
 * @Version 1.0
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserInfoService userInfoService;



	/**
	 * 用户邮箱注册
	 */
	@GetMapping("/api/v1/user/register/email")
	public ResponseDataDTO userRegisteredByEmail(@RequestParam(value = "email", required = true) String email,
	                                             @RequestParam(value = "password", required = true) String password,
	                                             @RequestParam(value = "passwordRepeat", required = true) String passwordRepeat) {

		userService.userRegister(email, password, passwordRepeat, null, RegisterType.EMAIL);
		return ResponseDataDTO.ok();
	}

	/**
	 * 用户登录
	 */
	@GetMapping("/api/v1/user/login/phone")
	public ResponseDataDTO userLoginByPhone(@RequestParam(value = "email", required = true) String phoneNumber,
											@RequestParam(value = "password", required = true) String password,
											HttpSession session) {
		userInfoService.userLoginByPhone(phoneNumber, password);


		return ResponseDataDTO.ok();

	}

	/**
	 * 用户手机号注册
	 */
	@GetMapping("/api/v1/user/register/phone")
	public ResponseDataDTO userRegisteredByPhone(@RequestParam(value = "phone", required = true) String phoneNumber,
	                                             @RequestParam(value = "password", required = true) String password,
	                                             @RequestParam(value = "passwordRepeat", required = true) String passwordRepeat,
	                                             @RequestParam(value = "phoneToken", required = false) String token) {
		userService.userRegister(phoneNumber, password, passwordRepeat, token, RegisterType.PHONE_NUMBER);
		return ResponseDataDTO.ok();
	}
}
