package pers.common.orgstruct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import pers.common.orgstruct.entity.User;
import pers.common.orgstruct.vo.UserVO;

public interface UserMapper extends BaseMapper<User> {

    UserVO selectUserByConcatId(Long id);
}