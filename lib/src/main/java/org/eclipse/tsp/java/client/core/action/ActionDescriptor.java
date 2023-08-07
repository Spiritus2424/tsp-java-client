package org.eclipse.tsp.java.client.core.action;

import java.util.Map;

import org.eclipse.tsp.java.client.core.dataprovider.ProviderType;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class ActionDescriptor {
	@NonNull
	private String id;
	@NonNull
	private String name;
	@NonNull
	private String targetProviderId;
	@NonNull
	private ProviderType providerType;
	@NonNull
	private String actionTooltipMessage;
	@Builder.Default
	private ActionType actionType = ActionType.OUTPUT_LOCATION;
	private String description;
	private Map<String, Object> inputParameters;
}
