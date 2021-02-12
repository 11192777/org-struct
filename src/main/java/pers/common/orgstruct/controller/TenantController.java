package pers.common.orgstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pers.common.orgstruct.dto.ResponseDataDTO;
import pers.common.orgstruct.service.TenantService;

/**
 *
 * 租户控制器
 *
 * @Author Qingyu
 * @Date 2021/2/8 21:12
 * @Version 1.0
 */
@RestController
public class TenantController {

	@Autowired
	private TenantService tenantService;

	/**
	 * 根据id获取租户
	 * @param tenantId
	 * @return
	 */
	@GetMapping("/api/v1/tenant")
	public ResponseDataDTO getTenant(@RequestParam(value = "id", required = true) Long tenantId){
		return ResponseDataDTO.ok(tenantService.queryTenantById(tenantId));
	}

}
