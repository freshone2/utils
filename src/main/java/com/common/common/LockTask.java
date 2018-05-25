package com.common.common;

/**
 * @Package: com.common.service.common
 * @Description:
 * @author: jklofs
 * @date: 2018/5/4 下午2:07
 */
public interface LockTask<RUN_OUT,RESULT_OUT> {
    /**
     * 锁数据操作
     *
     * @return
     */
    RUN_OUT run();

    /**
     * 结果返回值操作
     *
     * @param out
     * @return
     */
    RESULT_OUT result(RUN_OUT out);

    /**
     * 无法获取锁操作
     *
     * @return
     */
    RESULT_OUT unLock();

    /**
     * 发生异常时处理
     *
     * @param e
     */
    RESULT_OUT exception(Throwable e);
}
