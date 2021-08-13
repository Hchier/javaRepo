package com.hand.app.service.impl;

import com.hand.api.utils.PrincipalUtil;
import com.hand.app.remote.RemoteRoleService;
import com.hand.app.service.SoHeaderService;
import com.hand.domain.entity.SoHeader;
import com.hand.domain.repository.SoHeaderRepository;
import io.choerodon.core.oauth.CustomUserDetails;
import org.hzero.core.util.Results;
import org.hzero.iam.domain.entity.Role;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * 应用服务默认实现
 *
 * @author sh1101315853@163.com 2020-07-27 15:21:08
 */
@Service
public class SoHeaderServiceImpl implements SoHeaderService {
    @Autowired
    private SoHeaderRepository soHeaderRepository;
    @Autowired
    private RemoteRoleService remoteRoleService;

    /**
     * 新建
     */
    public static final String NEW = "NEW";

    /**
     * 已提交
     */
    public static final String SUBMITED = "SUBMITED";

    /**
     * 已审批
     */
    public static final String APPROVED = "APPROVED";

    /**
     * 已拒绝
     */
    public static final String REJECTED = "REJECTED";

    /**
     * 已关闭
     */
    public static final String CLOSED = "CLOSED";

    /**
     * 更改订单的状态
     * @param soHeader 订单头消息
     * @param principal
     * @return
     */
    @Override
    public ResponseEntity<String> updateStatus(SoHeader soHeader, Principal principal) {
        //通过传过来要修改的ID查询原始的订单头数据
        SoHeader soHeader1 = soHeaderRepository.selectByPrimaryKey(soHeader.getSoHeaderId());
        PrincipalUtil principalUtil = new PrincipalUtil(principal);
        CustomUserDetails details = principalUtil.getDetails();
        Role role = remoteRoleService.queryRoleDetails(details.getOrganizationId(), details.getRoleId());
        switch (soHeader.getOrderStatus()) {
            case SUBMITED:
                if (soHeader1 == null) {
                    throw new RuntimeException("当前订单不存在");
                }
                if (!soHeader1.getCreatedBy().equals(details.getUserId())) {
                    throw new RuntimeException("当前用户与创建人不一致");
                }
                if (!REJECTED.equals(soHeader1.getOrderStatus()) && !NEW.equals(soHeader1.getOrderStatus())) {
                    throw new RuntimeException("当前订单状态不是NEW或REJECTED");
                }
                break;
            case APPROVED:

            case REJECTED:
                if (soHeader1 == null) {
                    throw new RuntimeException("当前订单不存在");
                }
                if (!"SALE_MANAGER_28263".equals(role.getName())) {
                    throw new RuntimeException("当前角色无法更改订单状态");
                }
                if (!SUBMITED.equals(soHeader1.getOrderStatus())) {
                    throw new RuntimeException("当前订单状态不是SUBMITED，无法更改为APPROVED");
                }
                break;
            default:
                break;
        }
        //不可以对订单编号进行更改
        soHeader.setOrderNumber(soHeader1.getOrderNumber());
        //不必再输入tokenID
        soHeader.set_token(soHeader1.get_token());
        //set相应的Status状态
        //tokenId数据验证
        SecurityTokenHelper.validToken(soHeader);
        soHeaderRepository.updateByPrimaryKeySelective(soHeader);
        return Results.success("修改订单头成功！");

    }

}
