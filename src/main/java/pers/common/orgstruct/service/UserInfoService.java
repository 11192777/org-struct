package pers.common.orgstruct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.common.orgstruct.entity.Tenant;
import pers.common.orgstruct.entity.UserInfo;

public interface UserInfoService extends IService<UserInfo> {
    void userLoginByPhone(String phoneNumber, String password);
}
