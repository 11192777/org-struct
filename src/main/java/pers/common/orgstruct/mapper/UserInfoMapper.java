package pers.common.orgstruct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import pers.common.orgstruct.entity.Tenant;
import pers.common.orgstruct.entity.UserInfo;
import pers.common.orgstruct.entity.UserInfo;




/**
 * @Author Qingyu
 * @Date 2021/2/12 23:18
 * @Version 1.0
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo queryUserByPhoneNumberAndPassword(String account, String password);
	UserInfo selectByAccount(String account);
}
