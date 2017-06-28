package com.greatuslabs.batch.util;

/**
 * Created by Adrian on 6/28/2017.
 */
public interface ReplicationStrategyRegistry {
    ReplicationStrategy getByCode(String replicationStrategyCode);

}
