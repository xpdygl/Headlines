package com.itheima.dfs.strategy;

import com.itheima.dfs.pojo.DFSType;
import com.itheima.dfs.service.AbstractDfsTemplate;
import com.itheima.dfs.service.IFileService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

/**
 * 策略类
 */
@Component
public class FileServiceStrategyContext implements ApplicationContextAware {

    //key  就是某一个类型 value 就是接口对应的具体子类对象、
    //map  key: 某一个枚举（代表某一个类型  oss）---->对应的OSS对应的实例对象（service的OSS实现类）
    //map value: 实例对象  比如OSS 对应的就是 service的OSS实现类
    private static final Map<DFSType, IFileService> dfsServices = new EnumMap<DFSType, IFileService>(DFSType.class);

    /**
     *
     * @param applicationContext 容器本身对象
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //抽闲类的所有的子类对象 从容器中获取所有的子类对象 key: beanName value bean对象  key: ossFileTemplate value: new OssFileTemplate
        Map<String, AbstractDfsTemplate> types = applicationContext.getBeansOfType(AbstractDfsTemplate.class);

        //循环抽象类的子类
        for (AbstractDfsTemplate value : types.values()) {
            DFSType support = value.support();//获取子类支持的具体的枚举对象
            dfsServices.put(support, value);//对应的实例对象
        }
    }

    /**
     * 提供方法获取具体实现类
     * @param key
     * @return
     */
    public IFileService getIFleService(DFSType key) {
        return dfsServices.get(key);
    }

}