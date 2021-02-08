package pers.common.orgstruct.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MapperScan({"pers.common.orgstatus.mapper"})
@Configuration
public class MybatisPlusConfig {
//    @Bean
////    public PaginationInnerInterceptor paginationInterceptor() {
////        PaginationInterceptor paginationInterceptor = new PaginationInnerInterceptor();
////        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
////        // paginationInterceptor.setOverflow(false);
////        // 设置最大单页限制数量，默认 500 条，-1 不受限制
//////         paginationInterceptor.setMaxLimit(500l);
////        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
////        return paginationInterceptor;
////    }

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		// 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
		// paginationInterceptor.setOverflow(false);
		// 设置最大单页限制数量，默认 500 条，-1 不受限制
		// paginationInterceptor.setLimit(500);
		// 开启 count 的 join 优化,只针对部分 left join
		paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
		return paginationInterceptor;
	}

//    /**
//     * SQL执行效率插件
//     */
//    @Bean
//    @Profile({"dev"})// 设置 dev test 环境开启
//    public PerformanceInterceptor performanceInterceptor() {
//        PerformanceInterceptor interceptor = new PerformanceInterceptor();
//        //sql 执行超过500毫秒则停止执行
//        interceptor.setMaxTime(500);
//        return interceptor;
//    }
}
