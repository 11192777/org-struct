package pers.common.orgstruct.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 公司视图
 *
 * @Author Qingyu
 * @Date 2021/2/8 21:26
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompanyVO {
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 公司名称
	 */
	private String name;
}
