package pers.common.orgstruct.mapper;

import pers.common.orgstruct.entity.User;

public interface OsUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}