package com.greatuslabs.batch.util;

import com.greatuslabs.batch.dto.ReplicatorTaskCO;

/**
 * Created by Adrian on 6/28/2017.
 */
public interface ReplicatorTask extends BaseReplicatorTask{
    <RESULT> RESULT execute(ReplicatorTaskCO executorCommand, ReplicationStrategy strategy);
}
