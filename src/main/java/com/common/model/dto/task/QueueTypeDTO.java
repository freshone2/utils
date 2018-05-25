package com.common.model.dto.task;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/4/12 上午11:27
 */
public class QueueTypeDTO<T> {
    private Integer type;
    private QueueTaskDTO<T> task;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public QueueTaskDTO<T> getTask() {
        return task;
    }

    public void setTask(QueueTaskDTO<T> task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "QueueTypeDTO{" +
                "type=" + type +
                ", task=" + task +
                '}';
    }
}
