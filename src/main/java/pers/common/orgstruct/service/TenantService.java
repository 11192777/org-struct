package pers.common.orgstruct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.common.orgstruct.entity.Tenant;
import pers.common.orgstruct.vo.TenantVO;

/**
 * @Author Qingyu
 * @Date 2021/2/8 18:49
 * @Version 1.0
 */
public interface TenantService extends IService<Tenant> {

	/**
	 * 通过租户id获取租户
	 * @param tenantId
	 * @return
	 */
	TenantVO queryTenantById(Long tenantId);
}
