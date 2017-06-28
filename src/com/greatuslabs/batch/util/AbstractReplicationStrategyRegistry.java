package com.greatuslabs.batch.util;

import java.util.Map;

/**
 * Created by Adrian on 6/29/2017.
 */
public abstract class AbstractReplicationStrategyRegistry implements ReplicationStrategyRegistry{
    private final Map<String, ReplicationStrategy> strategyMap;

    protected AbstractReplicationStrategyRegistry(){
        strategyMap = createStrategyMap();
    }

    public ReplicationStrategy getByCode(String replicationStrategyCode){
        return strategyMap.get(replicationStrategyCode);
    }

    protected abstract Map<String,ReplicationStrategy> createStrategyMap();

}
