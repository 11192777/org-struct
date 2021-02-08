package pers.common.orgstruct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.common.orgstruct.entity.Department;
import pers.common.orgstruct.mapper.DepartmentMapper;
import pers.common.orgstruct.service.DepartmentService;

/**
 * @Author Qingyu
 * @Date 2021/2/8 18:49
 * @Version 1.0
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
}
