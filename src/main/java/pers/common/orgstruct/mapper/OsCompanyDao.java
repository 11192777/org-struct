package pers.common.orgstruct.mapper;

import pers.common.orgstruct.entity.Company;

public interface OsCompanyDao {
    int deleteByPrimaryKey(Long id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}