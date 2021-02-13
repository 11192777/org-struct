package pers.common.orgstruct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import pers.common.orgstruct.entity.Tenant;
import pers.common.orgstruct.entity.UserInfo;

public interface UserInfoMapper extends BaseMapper<UserInfo> {
    UserInfo queryUser(String account, String password);
}
