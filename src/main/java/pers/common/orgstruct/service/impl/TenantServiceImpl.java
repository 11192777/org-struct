package pers.common.orgstruct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.common.orgstruct.entity.Tenant;
import pers.common.orgstruct.mapper.TenantMapper;
import pers.common.orgstruct.service.TenantService;
import pers.common.orgstruct.vo.TenantVO;

/**
 * @Author Qingyu
 * @Date 2021/2/8 18:49
 * @Version 1.0
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant>  implements TenantService {

	@Autowired
	private TenantMapper tenantMapper;

	/**
	 * 通过租户id获取租户
	 * @param tenantId
	 * @return
	 */
	@Override
	public TenantVO queryTenantById(Long tenantId) {
		return this.convertEntityToVO(tenantMapper.selectById(tenantId));
	}

	/**
	 * 租户实体转视图
	 * @param tenant 租户实体
	 * @return
	 */
	private TenantVO convertEntityToVO(Tenant tenant) {
		return TenantVO.builder()
				.id(tenant.getId())
				.name(tenant.getName())
				.build();
	}
}
