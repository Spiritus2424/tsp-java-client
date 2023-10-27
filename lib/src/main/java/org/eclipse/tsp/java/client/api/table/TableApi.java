package org.eclipse.tsp.java.client.api.table;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.api.table.dto.GetTableLinesRequestDto;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLog;
import org.eclipse.tsp.java.client.shared.tracecompass.TraceCompassLogUtils.FlowScopeLogBuilder;

public class TableApi extends AbstractTspApi {
	private final @NonNull Logger logger;
	private final String TABLE_API_URL;

	public TableApi(String baseUrl) {
		super(baseUrl);
		this.logger = TraceCompassLog.getLogger(TableApi.class);
		this.TABLE_API_URL = this.getBaseUrl().concat("/experiments/%s/outputs/table/%s");
	}

	@Async
	public TspClientResponse<GenericResponse<List<ColumnHeaderEntry>>> getTableColumns(
			final UUID experimentUuid,
			final String outputId,
			final Query query) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"TableApi#getTableColumns").setCategory(outputId).build()) {
			return this.getRestClientSingleton().post(
					String.format(this.TABLE_API_URL.concat("/columns"), experimentUuid, outputId),
					Optional.of(query),
					Optional.empty(),
					this.getTypeFactory().constructParametricType(GenericResponse.class,
							this.getTypeFactory().constructCollectionType(List.class,
									ColumnHeaderEntry.class)));
		}
	}

	@Async
	public TspClientResponse<GenericResponse<TableModel>> getTableLines(
			final UUID experimentUuid,
			final String outputId,
			final Body<GetTableLinesRequestDto> body) {
		try (FlowScopeLog flowScopeLog = new FlowScopeLogBuilder(this.logger, Level.FINE,
				"TableApi#getTableLines").setCategory(outputId).build()) {
			return this.getRestClientSingleton().post(
					String.format(this.TABLE_API_URL.concat("/lines"), experimentUuid, outputId),
					Optional.of(body),
					Optional.empty(),
					this.getTypeFactory().constructParametricType(GenericResponse.class, TableModel.class));
		}
	}
}
