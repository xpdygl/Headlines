package com.itheima.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.admin.mapper.AdUserMapper;
import com.itheima.admin.pojo.AdUser;
import com.itheima.admin.service.AdUserService;
import com.itheima.common.exception.LeadNewsException;
import com.itheima.common.util.AppJwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 管理员用户信息表 服务实现类
 * </p>
 *
 * @author xh
 * @since 2022-04-10
 */
@Service
public class AdUserServiceImpl extends ServiceImpl<AdUserMapper, AdUser> implements AdUserService {

    @Autowired
    private AdUserMapper adUserMapper;

    @Override
    public Map<String, Object> login(AdUser adUser) throws LeadNewsException {
        //获取用户名密码
        String nickname = adUser.getName();
        String password = adUser.getPassword();

        if (StringUtils.isEmpty(nickname)||StringUtils.isEmpty(password)){
            throw new LeadNewsException(("用户名或者密码不能为空"));

        }

        //根据用户名查询数据库，查询的记录是一条或者没有。如果没有就抛出异常

        QueryWrapper<AdUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",nickname);
        queryWrapper.eq("status","9");
        AdUser adUserFromDb = adUserMapper.selectOne(queryWrapper);
        //如果有就根据数据库对应的密码进行校验
        if (adUserFromDb==null){
            throw new LeadNewsException(("用户名或者密码不能为空"));
        }
        //根据页面拿到的密码机型md5进行加密+数据库的盐值  --》密文
        String s = password+adUserFromDb.getSalt();
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(s.getBytes());

        //对比数据库中的密码和页面中的，如果不正确，抛出异常，如果正确就生成token给用户
        if (!md5DigestAsHex.equals(adUserFromDb.getPassword())){
            throw new LeadNewsException(("密码错误"));
        }
        //生成token
        String token = AppJwtUtil.createToken(Long.valueOf(adUserFromDb.getId()));
        HashMap<String, Object> info = new HashMap<>();
        info.put("token",token);
        info.put("name",adUserFromDb.getName());
        info.put("image",adUserFromDb.getImage());
        return info;

    }
}
