package com.common.model.dto.task;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/4/9 下午2:24
 */
public class QueueTaskDTO<T> {
    private Integer taskType;
    private T data;

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "QueueTaskDTO{" +
                "taskType=" + taskType +
                ", data=" + data +
                '}';
    }
}
