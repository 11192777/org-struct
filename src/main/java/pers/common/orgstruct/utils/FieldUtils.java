package pers.common.orgstruct.utils;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.common.orgstruct.exception.BusinessException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 必填参数检查
 *
 * @Author Qingyu
 * @Date 2020/12/3 9:22
 * @Version 1.0
 */
public class FieldUtils {

	public static final Logger log = LoggerFactory.getLogger(FieldUtils.class);


	@SneakyThrows
	public static void validateRequiredFields(Object obj, String... fields) {
		if (fields == null) return;
		List<String> fieldList = Arrays.asList(fields);
		List<String> missFieldList = new ArrayList<>();
		try {
			for (Field field : obj.getClass().getDeclaredFields()) {
				if (fieldList.contains(field.getName())) {
					field.setAccessible(true);
					if (field.get(obj) == null || field.get(obj).equals("")) {
						missFieldList.add(field.getName());
					}else if (field.get(obj) instanceof List && ((List) field.get(obj)).size() == 0){
						missFieldList.add(field.getName());
					}
				}
			}
		} catch (Exception e) {
			log.info("必填项校验出错...");
		}
		if (CollectionUtils.isNotEmpty(missFieldList)) {
			StringBuffer sBuffer = new StringBuffer();

			for (int index = 0; index < missFieldList.size(); index++) {
				if (index != 0) {
					sBuffer.append(",");
				}
				sBuffer.append(missFieldList.get(index));
			}

			log.error("缺少必填参数{}", sBuffer.toString());
			throw new BusinessException(String.format("缺少必填参数{%s}",sBuffer.toString()));
		}
	}
}
