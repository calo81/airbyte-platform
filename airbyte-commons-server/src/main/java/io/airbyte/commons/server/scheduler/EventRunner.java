/*
 * Copyright (c) 2023 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.commons.server.scheduler;

import io.airbyte.commons.temporal.TemporalClient.ManualOperationResult;
import io.airbyte.protocol.models.StreamDescriptor;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Client for triggering events on connections.
 */
public interface EventRunner {

  void createConnectionManagerWorkflow(final UUID connectionId);

  ManualOperationResult startNewManualSync(final UUID connectionId);

  ManualOperationResult startNewCancellation(final UUID connectionId);

  ManualOperationResult resetConnection(final UUID connectionId, final List<StreamDescriptor> streamsToReset, final boolean runSyncImmediately);

  void forceDeleteConnection(final UUID connectionId);

  // TODO: Delete
  @Deprecated(forRemoval = true)
  void migrateSyncIfNeeded(final Set<UUID> connectionIds);

  void update(final UUID connectionId);

  void sendSchemaChangeNotification(final UUID connectionId, final String connectionName, final String url, final boolean containsBreakingChange);

}
