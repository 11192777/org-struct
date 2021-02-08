package pers.common.orgstruct.mapper;

import pers.common.orgstruct.entity.Tenant;

public interface OsTenantDao {
    int deleteByPrimaryKey(Long id);

    int insert(Tenant record);

    int insertSelective(Tenant record);

    Tenant selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tenant record);

    int updateByPrimaryKey(Tenant record);
}