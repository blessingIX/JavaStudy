package com.yzj.redis;

/**
 * Redis 枚举类
 *
 * @author yclimb
 * @date 2018/4/19
 */
public enum RedisEnum {

    /**
     * 数据字典Service - 根据字典类型查询字典数据
     */
    MDM_MSTDATADICTIONARYSERVICE_QUERYLISTBYENTITYREDIS(
            RedisUtils.KEY_PREFIX, "MstDataDictionaryService", "queryListByEntityRedis", "数据字典Redis缓存");

    /**
     * 系统标识
     */
    private String keyPrefix;
    /**
     * 模块名称
     */
    private String module;
    /**
     * 方法名称
     */
    private String func;
    /**
     * 描述
     */
    private String remark;

    RedisEnum(String keyPrefix, String module, String func, String remark) {
        this.keyPrefix = keyPrefix;
        this.module = module;
        this.func = func;
        this.remark = remark;
    }

    // getter and setter....


    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
