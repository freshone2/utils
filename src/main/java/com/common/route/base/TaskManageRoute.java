package com.common.route.base;

import com.common.model.dto.ResultDTO;
import com.common.model.dto.task.TaskDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @Package: pecker.rest
 * @Description:
 * @author: jklofs
 * @date: 2018/4/13 下午7:08
 */
@RequestMapping("/v1")
public interface TaskManageRoute {

    /**
     * 添加任务
     *
     * @param taskDTO
     * @return
     */
    @PostMapping(value = "/task")
    ResultDTO addTask(@RequestHeader("requestId") String requestId,@RequestBody TaskDTO taskDTO);

    /**
     * 移除任务
     *
     * @param taskId
     * @return
     */
    @DeleteMapping(value = "/task")
    ResultDTO removeTask(@RequestHeader("requestId") String requestId,@RequestParam("taskId") String taskId);

    /**
     * 立即运行任务
     *
     * @param taskId
     * @return
     */
    @PutMapping(value = "/task/starting")
    ResultDTO advanceStartTask(@RequestHeader("requestId") String requestId,@RequestParam("taskId") String taskId);
}
