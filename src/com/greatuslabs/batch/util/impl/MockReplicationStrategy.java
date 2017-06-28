package com.greatuslabs.batch.util.impl;

import com.greatuslabs.batch.util.ReplicationRepository;
import com.greatuslabs.batch.util.ReplicationStrategy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Adrian on 6/28/2017.
 */
public class MockReplicationStrategy implements ReplicationStrategy {

    /**
     * Can be externalised
     */
    private static final long PAGE_SIZE = 1000;


    @Override
    public <REPOSITORY extends ReplicationRepository<?, ?>, DESTINATION, COMMAND> List<DESTINATION> replicateRecords(
            COMMAND replicatorCommands, REPOSITORY sourceRepository, Class<DESTINATION> destinationClass) {
        return sourceRepository.findSourceChunk(1,1).stream().map(destinationClass::cast).collect(Collectors.toList());
    }
}
