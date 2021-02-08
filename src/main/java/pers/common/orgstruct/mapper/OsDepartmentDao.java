package pers.common.orgstruct.mapper;

import pers.common.orgstruct.entity.Department;

public interface OsDepartmentDao {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}