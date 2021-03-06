package com.hand.config;

import io.choerodon.core.swagger.ChoerodonRouteData;
import io.choerodon.swagger.annotation.ChoerodonExtraData;
import io.choerodon.swagger.swagger.extra.ExtraData;
import io.choerodon.swagger.swagger.extra.ExtraDataManager;
import org.springframework.beans.factory.annotation.Autowired;

@ChoerodonExtraData
class OrderExtraDataManager implements ExtraDataManager {

	@Autowired
	private org.springframework.core.env.Environment environment;

	@Override
	public ExtraData getData() {
		ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
		choerodonRouteData.setName(environment.getProperty("hzero.service.current.name", "hodr"));
		choerodonRouteData.setPath(environment.getProperty("hzero.service.current.path", "/hodr/**"));
		choerodonRouteData.setServiceId(environment.getProperty("hzero.service.current.service-name", "hzero-order"));
		extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
		return extraData;

//		ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
//		choerodonRouteData.setName(environment.getProperty("hzero.service.current.name", "htdo"));
//		choerodonRouteData.setPath(environment.getProperty("hzero.service.current.path", "/todo/**"));
//		choerodonRouteData.setServiceId(environment.getProperty("hzero.service.current.service-name", "hzero-todo-service"));
//		extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
//		return extraData;


	}
}
