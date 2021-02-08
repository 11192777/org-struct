package pers.common.orgstruct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.common.orgstruct.entity.Company;
import pers.common.orgstruct.vo.CompanyVO;

import java.util.List;

/**
 * @Author Qingyu
 * @Date 2021/2/8 18:48
 * @Version 1.0
 */
public interface CompanyService extends IService<Company>{

	/**
	 * 获取租户下的公司列表
	 * @param tenantId
	 * @return
	 */
	List<CompanyVO> queryListByTenantId(Long tenantId);
}
