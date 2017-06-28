package com.greatuslabs.batch.util;

import java.util.List;

/**
 * Created by Adrian on 6/28/2017.
 */
public interface ReplicationRepository<SOURCE, DESTINATION_ID> {
    Long countSourceSize();

    List<SOURCE> findSourceChunk(int offset, int limit);

    void removeAllByIdsIn(List<DESTINATION_ID> ids);

    List<DESTINATION_ID> findExistingRecordsIds();
}
