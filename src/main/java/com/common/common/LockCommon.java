package com.common.common;

/**
 * @Package: pecker.service.common
 * @Description:
 * @author: jklofs
 * @date: 2018/3/26 上午9:23
 */
public interface LockCommon {

    /**
     * 锁对象
     *
     * @param prefix
     * @param lockKey
     * @param task
     * @param <V>
     * @param <T>
     */
   <V,T> T lockProcessing(String prefix , String lockKey,LockTask<V,T> task );
}
