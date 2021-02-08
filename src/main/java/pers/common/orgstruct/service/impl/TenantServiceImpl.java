package pers.common.orgstruct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.common.orgstruct.entity.Tenant;
import pers.common.orgstruct.mapper.TenantMapper;
import pers.common.orgstruct.service.TenantService;

/**
 * @Author Qingyu
 * @Date 2021/2/8 18:49
 * @Version 1.0
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant>  implements TenantService {
}
