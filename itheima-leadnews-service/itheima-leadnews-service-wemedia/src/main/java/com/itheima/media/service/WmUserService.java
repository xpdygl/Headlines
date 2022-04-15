package com.itheima.media.service;

import com.itheima.common.exception.LeadNewsException;
import com.itheima.media.pojo.WmUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 自媒体用户信息表 服务类
 * </p>
 *
 * @author xh
 * @since 2022-04-10
 */
public interface WmUserService extends IService<WmUser> {

    Map<String, Object> login(WmUser wmUser) throws LeadNewsException;
}
