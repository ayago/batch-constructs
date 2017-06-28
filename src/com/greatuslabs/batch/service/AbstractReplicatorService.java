package com.greatuslabs.batch.service;

import com.greatuslabs.batch.dto.ReplicatorCO;
import com.greatuslabs.batch.util.ReplicationStrategy;
import com.greatuslabs.batch.util.ReplicationStrategyRegistry;

/**
 * Framework independent base Replicator Construct
 * Created by Adrian on 6/28/2017.
 */
public abstract class AbstractReplicatorService implements ReplicatorService{

    private final ReplicationStrategyRegistry replicationStrategyRegistry;

    protected AbstractReplicatorService(ReplicationStrategyRegistry replicationStrategyRegistry) {
        this.replicationStrategyRegistry = replicationStrategyRegistry;
    }


    public <COMMAND extends ReplicatorCO> void replicate(COMMAND command){
        ReplicationStrategy replicationStrategy = getStrategy(command.getReplicationStrategyCode());
        executeActualReplication(command, replicationStrategy);
    }

    protected abstract <COMMAND extends ReplicatorCO> void executeActualReplication(
            COMMAND command, ReplicationStrategy replicationStrategy);

    private ReplicationStrategy getStrategy(String replicationStrategyCode){
        return replicationStrategyRegistry.getByCode(replicationStrategyCode);
    }
}
