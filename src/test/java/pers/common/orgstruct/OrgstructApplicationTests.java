package pers.common.orgstruct;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

	@Test
	void contextLoads() {
	}

}
