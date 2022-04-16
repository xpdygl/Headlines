package com.itheima.dfs.pojo;

/**
 * 枚举用来限制我们使用的分布式文件系统的类型
 */
public enum DFSType {
    /**
     * fastdfs
     */
    FASTDFS,
    /**
     * 七牛
     */
    QINIUDFS,
    /**
     * 阿里云oss
     */
    OSSDFS;

}