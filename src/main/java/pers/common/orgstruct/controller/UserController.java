package pers.common.orgstruct.controller;

import com.alibaba.druid.sql.dialect.ads.visitor.AdsOutputVisitor;
import com.sun.org.apache.xpath.internal.SourceTreeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.common.orgstruct.dto.ResponseDataDTO;
import pers.common.orgstruct.enumeration.RegisterType;
import pers.common.orgstruct.service.UserService;

/**
 * @Author Qingyu
 * @Date 2021/2/12 18:19
 * @Version 1.0
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**ata
	 * 用户注册
	 */
	@GetMapping("/api/v1/user/register/email")
	public ResponseDataDTO userRegistered(@RequestParam(value = "email", required = true) String account,
	                                      @RequestParam(value = "password", required = true) String password,
	                                      @RequestParam(value = "passwordRepeat", required = true) String passwordRepeat) {

		userService.userRegister(account, password, passwordRepeat, RegisterType.EMAIL);

		return ResponseDataDTO.ok();
	}

}
