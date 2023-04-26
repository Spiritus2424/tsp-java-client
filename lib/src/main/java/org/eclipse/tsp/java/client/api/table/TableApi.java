package org.eclipse.tsp.java.client.api.table;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;
import org.eclipse.tsp.java.client.api.table.dto.GetTableLinesRequestDto;
import org.eclipse.tsp.java.client.core.tspclient.TspClientResponse;
import org.eclipse.tsp.java.client.shared.query.Body;
import org.eclipse.tsp.java.client.shared.query.Query;
import org.eclipse.tsp.java.client.shared.response.GenericResponse;

public class TableApi extends AbstractTspApi {
	private final String TABLE_API_URL;

	public TableApi(String baseUrl) {
		super(baseUrl);
		this.TABLE_API_URL = this.getBaseUrl().concat("/experiments/%s/outputs/table/%s");
	}

	@Async
	public TspClientResponse<GenericResponse<List<ColumnHeaderEntry>>> getTableColumns(UUID experimentUuid,
			String outputId,
			Query query) {
		return this.getRestClientSingleton().post(
				String.format(this.TABLE_API_URL.concat("/columns"), experimentUuid, outputId),
				Optional.of(query),
				this.getTypeFactory().constructParametricType(GenericResponse.class,
						this.getTypeFactory().constructCollectionType(List.class,
								ColumnHeaderEntry.class)));
	}

	@Async
	public TspClientResponse<GenericResponse<TableModel>> getTableLines(UUID experimentUuid, String outputId,
			Body<GetTableLinesRequestDto> body) {
		return this.getRestClientSingleton().post(
				String.format(this.TABLE_API_URL.concat("/lines"), experimentUuid, outputId),
				Optional.of(body),
				this.getTypeFactory().constructParametricType(GenericResponse.class, TableModel.class));
	}
}
