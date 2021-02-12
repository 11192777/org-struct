package pers.common.orgstruct.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.common.orgstruct.vo.UserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Qingyu
 * @Date 2021/2/12 22:33
 * @Version 1.0
 */
public class SecurityUtil {

	public static Long getTenantId(){
		return getCurrentUser().getTenantId();
	}

	public static Long getCurrentUserId(){
		return getCurrentUser().getId();
	}

	public static UserVO getCurrentUser(){
		Object user = getRequest().getSession().getAttribute("currentUser");
		if (user == null){
			return UserVO.builder()
					.id(-1L)
					.tenantId(-1L)
					.build();
		}else{
			return (UserVO) user;
		}
	}

	public static ServletRequestAttributes getRequestAttributes() {
		return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	}

	public static HttpServletRequest getRequest() {
		return getRequestAttributes().getRequest();
	}
}
