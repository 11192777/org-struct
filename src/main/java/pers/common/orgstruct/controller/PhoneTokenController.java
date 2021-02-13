package pers.common.orgstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.common.orgstruct.dto.ResponseDataDTO;
import pers.common.orgstruct.entity.PhoneToken;
import pers.common.orgstruct.service.PhoneTokenService;

/**
 * @Author Qingyu
 * @Date 2021/2/13 15:57
 * @Version 1.0
 */
@RestController
public class PhoneTokenController {

	@Autowired
	private PhoneTokenService phoneTokenService;

	@GetMapping(value = "/api/v1/phone/token")
	public ResponseDataDTO getPhoneToken(@RequestParam(value = "account", required = true) String account){
		return ResponseDataDTO.ok(phoneTokenService.generateToken(account));
	}
}
