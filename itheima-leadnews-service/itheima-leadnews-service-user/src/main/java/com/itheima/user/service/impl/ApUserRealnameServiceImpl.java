package com.itheima.user.service.impl;

import com.itheima.article.feign.ApAuthorFeign;
import com.itheima.article.pojo.ApAuthor;
import com.itheima.common.constants.BusinessConstants;
import com.itheima.common.pojo.Result;
import com.itheima.media.feign.WmUserFegin;
import com.itheima.media.pojo.WmUser;
import com.itheima.user.mapper.ApUserMapper;
import com.itheima.user.pojo.ApUser;
import com.itheima.user.pojo.ApUserRealname;
import com.itheima.user.mapper.ApUserRealnameMapper;
import com.itheima.user.service.ApUserRealnameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * APP实名认证信息表 服务实现类
 * </p>
 *
 * @author xh
 * @since 2022-04-10
 */
@Service
public class ApUserRealnameServiceImpl extends ServiceImpl<ApUserRealnameMapper, ApUserRealname> implements ApUserRealnameService {

    @Autowired
    private ApUserRealnameMapper apUserRealnameMapper;

    @Autowired
    private WmUserFegin wmUserFegin;

    @Autowired
    private ApUserMapper apUserMapper;

    @Autowired
    private ApAuthorFeign apAuthorFeign;



    @Override
    public void pass(Integer id) {
        //更新 设置字段的状态值为9 就是审核通过
        //update biao set status where id = ?
        ApUserRealname entity = new ApUserRealname();
        entity.setId(id);
        entity.setStatus(BusinessConstants.ApUserRealnameConstants.SHENHE_SUCESS);
        apUserRealnameMapper.updateById(entity);

        Integer apUserId = apUserRealnameMapper.selectById(id).getUserId();
        ApUser apUser = apUserMapper.selectById(apUserId);

        WmUser wmUser = wmUserFegin.getByApUserId(apUserId);


        if (wmUser==null) {
            //通过feign远程调用 自媒体微服务 创建自媒体账号
            wmUser = new WmUser();
            wmUser.setApUserId(apUserId);

            BeanUtils.copyProperties(apUser,wmUser);

            wmUser.setNickname(apUser.getName());

            wmUser.setStatus(BusinessConstants.ApUserRealnameConstants.SHENHE_SUCESS);

            wmUser.setType(BusinessConstants.ApUserRealnameConstants.SHENHE_WARTING);
            wmUser.setCreatedTime(LocalDateTime.now());
            //生成自媒体对象
            Result<WmUser> result = wmUserFegin.save(wmUser);
            wmUser = result.getData();
        }
//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

        //通过feign远程调用 文章微服务 创建作者
        ApAuthor apAuthor = apAuthorFeign.getByApUserId(apUserId);

        if (apAuthor==null) {
//        ApAuthor apAuthor = apAuthorFeign.getByApUserId(apUserId);
//        if (apUser == null) {
            apAuthor = new ApAuthor();
            apAuthor.setCreatedTime(LocalDateTime.now());
            apAuthor.setName(apUser.getName());
            apAuthor.setUserId(apUserId);
            apAuthor.setType(BusinessConstants.ApUserRealnameConstants.SHENHE_FAILE);
            apAuthor.setWmUserId(wmUser.getId());
            apAuthorFeign.save(apAuthor);
        }

    }

    @Override
    public void reject(Integer id, String reason) {
        //更新 设置字段的状态值为1 就是审核通过
        //update biao set status = 1 where id = ?
        ApUserRealname entity = new ApUserRealname();
        entity.setId(id);
        entity.setReason(reason);
        entity.setStatus(BusinessConstants.ApUserRealnameConstants.SHENHE_FAILE);
        apUserRealnameMapper.updateById(entity);
    }
}
