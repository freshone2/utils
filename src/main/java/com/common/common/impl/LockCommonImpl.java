package com.common.common.impl;

import com.common.common.LockTask;
import com.common.model.dao.redis.AssemblyRedisDao;
import com.common.common.LockCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

/**
 * @Package: pecker.service.common.impl
 * @Description:
 * @author: jklofs
 * @date: 2018/3/26 上午11:33
 */
@ConditionalOnClass(AssemblyRedisDao.class)
@ConditionalOnBean(AssemblyRedisDao.class)
public class LockCommonImpl implements LockCommon {
    private static final Logger LOGGER = LoggerFactory.getLogger(LockCommonImpl.class);

    private AssemblyRedisDao assemblyRedisDao;


    @Override
    public <V, T> T lockProcessing(String prefix, String lockKey, LockTask<V, T> task) {
        if (null == prefix || null == lockKey || null == task){
            throw new NullPointerException();
        }
        lockKey = prefix + AssemblyRedisDao.LOCK_SPLIT_CODE + lockKey;
        String lockValue = String.valueOf(System.currentTimeMillis());
        try {
            if (assemblyRedisDao.lock(lockKey, lockValue)) {
                V out = task.run();
                return task.result(out);
            }
            return task.unLock();
        }catch (Throwable throwable){
          return task.exception(throwable);
        } finally {
            assemblyRedisDao.unlock(lockKey, lockValue);
        }
    }

    public AssemblyRedisDao getAssemblyRedisDao() {
        return assemblyRedisDao;
    }

    public void setAssemblyRedisDao(AssemblyRedisDao assemblyRedisDao) {
        this.assemblyRedisDao = assemblyRedisDao;
    }
}
