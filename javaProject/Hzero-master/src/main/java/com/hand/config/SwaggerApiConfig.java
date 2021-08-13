package com.hand.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger Api 描述配置
 *
 * @author liqun.long@hand-china.com 2019/07/30 20:43
 */
@Configuration
public class SwaggerApiConfig {

	public static final String COMPANY = "Company";
	public static final String CUSTOMER = "Customer";
	public static final String ITEM = "Item";
	public static final String SOHEADGER = "SoHeader";
	public static final String SOLINE = "SoLine";
	public static final String ORDER = "ORDER";
	public static final String ORDERDETAILS = "OrderDetalis";
	public static final String LOVLIST = "LovList";


	@Autowired
	public SwaggerApiConfig(Docket docket) {
		docket.tags(
				new Tag(COMPANY, "公司"),
				new Tag(CUSTOMER, "客户"),
				new Tag(ITEM, "物料"),
				new Tag(SOHEADGER, "销售订单头"),
				new Tag(SOLINE, "销售订单行"),
				new Tag(ORDER, "订单汇总操作"),
				new Tag(ORDERDETAILS, "订单明细"),
				new Tag(LOVLIST, "LOV测试")
		);
	}
}
