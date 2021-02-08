package pers.common.orgstruct.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import pers.common.orgstruct.entity.Company;

import java.util.List;

public interface CompanyMapper extends BaseMapper<Company> {

	List<Company> selectListByTenantId(Long tenantId);
}