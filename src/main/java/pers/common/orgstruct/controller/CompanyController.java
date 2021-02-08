package pers.common.orgstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.common.orgstruct.dto.ResponseDataDTO;
import pers.common.orgstruct.service.CompanyService;

/**
 * @Author Qingyu
 * @Date 2021/2/8 21:23
 * @Version 1.0
 */
@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	/**
	 * 获取租住下的公司列表
	 * @return
	 */
	@GetMapping(value = "/api/v1/companys")
	public ResponseDataDTO getTenantCompanys(@RequestParam(value = "id", required = true) Long tenantId){
		return ResponseDataDTO.ok(companyService.queryListByTenantId(tenantId));
	}

}
