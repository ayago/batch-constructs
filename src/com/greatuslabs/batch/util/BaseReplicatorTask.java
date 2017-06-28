package com.greatuslabs.batch.util;

/**
 * Created by Adrian on 6/28/2017.
 */
public interface BaseReplicatorTask {
    <COMMAND, RESULT> RESULT execute(COMMAND executorCommand, ReplicationStrategy strategy);
}
