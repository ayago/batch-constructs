package com.greatuslabs.batch.util;

import java.util.List;

/**
 * Handles replication steps
 * focused on improving memory and time complexity
 * Created by Adrian on 6/28/2017.
 */
public interface ReplicationStrategy {
    <REPOSITORY extends ReplicationRepository<?, ?>, DESTINATION, COMMAND> List<DESTINATION> replicateRecords(
            COMMAND replicatorCommands, REPOSITORY sourceRepository, Class<DESTINATION> destinationClass);


}
