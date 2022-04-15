package com.itheima.user.service;

import com.itheima.user.pojo.ApUserRealname;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * APP实名认证信息表 服务类
 * </p>
 *
 * @author xh
 * @since 2022-04-10
 */
public interface ApUserRealnameService extends IService<ApUserRealname> {


    void pass(Integer id);

    void reject(Integer id, String reason);
}
