package com.greatuslabs.batch.service;

import com.greatuslabs.batch.dto.ReplicatorCO;
import com.greatuslabs.batch.dto.ReplicatorTaskCO;
import com.greatuslabs.batch.util.BaseReplicatorTask;
import com.greatuslabs.batch.util.ReplicationStrategy;
import com.greatuslabs.batch.util.ReplicationStrategyRegistry;
import com.greatuslabs.batch.util.ReplicatorTask;

import java.util.List;

/**
 * Created by Adrian on 6/28/2017.
 */
public abstract class MultiStepReplicatorService extends AbstractReplicatorService{

    private final BaseReplicatorTask initialTask;
    private final List<ReplicatorTask> taskList;

    protected MultiStepReplicatorService(
            BaseReplicatorTask initialTask,
            List<ReplicatorTask> taskList,
            ReplicationStrategyRegistry replicationStrategyRegistry
    ) {
        super(replicationStrategyRegistry);
        this.initialTask = initialTask;
        this.taskList = taskList;
    }

    public <PARENT_CO extends ReplicatorCO> void executeActualReplication(
            PARENT_CO parentCO, ReplicationStrategy replicationStrategy){
        runTasks(parentCO, replicationStrategy);
    }

    private <PARENT_CO extends ReplicatorCO, TASK_COMMANDS> void runTasks(
            PARENT_CO parentCO,
            ReplicationStrategy replicationStrategy
    ){
        final TASK_COMMANDS commandForTasks = createCommandForTasks(parentCO);
        ReplicatorTaskCO taskCO = initialTask.execute(commandForTasks, replicationStrategy);
        for(ReplicatorTask replicatorTask: taskList){
            taskCO = replicatorTask.execute(taskCO, replicationStrategy);
        }
    }

    protected abstract <COMMAND, PARENT_CO extends ReplicatorCO> COMMAND createCommandForTasks(PARENT_CO parentCO);
}
