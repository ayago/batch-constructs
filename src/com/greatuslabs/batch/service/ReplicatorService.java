package com.greatuslabs.batch.service;

import com.greatuslabs.batch.dto.ReplicatorCO;

/**
 * Created by Adrian on 6/28/2017.
 */
public interface ReplicatorService {
    <COMMAND extends ReplicatorCO> void replicate(COMMAND command);
}
