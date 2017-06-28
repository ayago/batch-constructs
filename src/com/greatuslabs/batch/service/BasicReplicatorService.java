package com.greatuslabs.batch.service;

import com.greatuslabs.batch.dto.ReplicatorCO;
import com.greatuslabs.batch.util.ReplicationRepository;
import com.greatuslabs.batch.util.ReplicationStrategy;
import com.greatuslabs.batch.util.ReplicationStrategyRegistry;

/**
 * Framework independent Basic Replicator Construct
 * Created by Adrian on 6/28/2017.
 */
public abstract class BasicReplicatorService<SOURCE, DESTINATION_ID, DESTINATION> extends AbstractReplicatorService {

    private final ReplicationRepository<SOURCE, DESTINATION_ID> repository;

    private Class<DESTINATION> destinationClass;

    protected BasicReplicatorService(
            ReplicationRepository<SOURCE, DESTINATION_ID> repository,
            ReplicationStrategyRegistry replicationStrategyRegistry
    ) {
        super(replicationStrategyRegistry);
        this.repository = repository;
        destinationClass = determineDestinationClass();
    }

    protected abstract Class<DESTINATION> determineDestinationClass();

    /**
     *
     * @param command - global values
     * @param replicationStrategy - replication strategy
     * @see com.greatuslabs.batch.util.ReplicationStrategy
     * @param <COMMAND> - global values type
     */
    public <COMMAND extends ReplicatorCO> void executeActualReplication(
            COMMAND command, ReplicationStrategy replicationStrategy){
        replicationStrategy.replicateRecords(command, repository, destinationClass);
    }
}
