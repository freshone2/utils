package com.common.model.dto.task;

import java.util.UUID;

public class TaskDTO<T> {
    private String taskId;
    private int taskType;
    private long timeoutAt;
    private T data;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public long getTimeoutAt() {
        return timeoutAt;
    }

    public void setTimeoutAt(long timeoutAt) {
        this.timeoutAt = timeoutAt;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskId='" + taskId + '\'' +
                ", taskType=" + taskType +
                ", timeoutAt=" + timeoutAt +
                ", data=" + data +
                '}';
    }
}
