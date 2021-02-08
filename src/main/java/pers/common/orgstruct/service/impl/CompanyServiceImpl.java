package pers.common.orgstruct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.common.orgstruct.entity.Company;
import pers.common.orgstruct.mapper.CompanyMapper;
import pers.common.orgstruct.service.CompanyService;
import pers.common.orgstruct.vo.CompanyVO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Qingyu
 * @Date 2021/2/8 18:49
 * @Version 1.0
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService{

	@Autowired
	private CompanyMapper companyMapper;

	/**
	 * 获取租户下的公司列表
	 * @param tenantId
	 * @return
	 */
	@Override
	public List<CompanyVO> queryListByTenantId(Long tenantId) {
		return companyMapper.selectListByTenantId(tenantId).stream()
				.map(this::convertEntityToVO)
				.collect(Collectors.toList());
	}


	/**
	 * 公司实体转视图
	 * @param company 公司实体
	 * @return
	 */
	private CompanyVO convertEntityToVO(Company company) {
		return CompanyVO.builder()
				.id(company.getId())
				.name(company.getName())
				.build();
	}
}
