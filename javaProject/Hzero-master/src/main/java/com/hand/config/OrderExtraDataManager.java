package com.hand.config;

import io.choerodon.core.swagger.ChoerodonRouteData;
import io.choerodon.swagger.annotation.ChoerodonExtraData;
import io.choerodon.swagger.swagger.extra.ExtraData;
import io.choerodon.swagger.swagger.extra.ExtraDataManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 服务路由配置
 *
 * @author liqun.long@hand-china.com 2019/07/31 8:45
 */
@ChoerodonExtraData
class OrderExtraDataManager implements ExtraDataManager {

	@Autowired
	private org.springframework.core.env.Environment environment;

	@Override
	public ExtraData getData() {
		ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
		choerodonRouteData.setName(environment.getProperty("hzero.service.current.name", "htdo"));
		choerodonRouteData.setPath(environment.getProperty("hzero.service.current.path", "/order-28263/**"));
		choerodonRouteData.setServiceId(environment.getProperty("hzero.service.current.service-name", "hzero-order"));
		extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
		return extraData;
	}
}
