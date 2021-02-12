package pers.common.orgstruct.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.common.orgstruct.dto.ResponseDataDTO;

/**
 * @Author Qingyu
 * @Date 2021/2/12 18:19
 * @Version 1.0
 */
@RestController
public class UserController {


	/**
	 * 用户注册
	 */
	@GetMapping("/api/v1/user/register/email")
	public ResponseDataDTO userRegistered(@RequestParam(value = "email", required = true) String account,
	                                      @RequestParam(value = "password", required = true) String password,
	                                      @RequestParam(value = "passwordRepeat", required = true) String passwordRepeat) {
		System.out.println(account);

		return ResponseDataDTO.ok();
	}

	@GetMapping("/api/v1/test")
	public ResponseDataDTO test(){
		return ResponseDataDTO.ok();
	}
}
