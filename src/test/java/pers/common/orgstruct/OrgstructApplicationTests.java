package pers.common.orgstruct;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.common.orgstruct.entity.Department;
import pers.common.orgstruct.entity.User;
import pers.common.orgstruct.service.DepartmentService;
import pers.common.orgstruct.service.UserService;

/**
 * @Author Qingyu
 * @Date 2021/2/8 17:08
 * @Version 1.0
 */
@SpringBootTest
public class OrgstructApplicationTests {

	@Autowired
	UserService userService;
	@Autowired
	DepartmentService departmentService;

	@Test
	void contextLoads() {
	}


	/**
	 * 增加部门
	 */
	@Test
	public void insertDepartment(){
		Department department = Department.builder()
				.name("新的部门")
				.code("XMS0001")
				.build();

		departmentService.save(department);

	}
}
