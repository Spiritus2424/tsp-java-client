package org.eclipse.tsp.java.client.api.graph;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class VertexDeserializer extends KeyDeserializer {

	@Override
	public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		key = key.replace("[", "");
		key = key.replace("]", "");
		key = key.replace("w", "");
		String[] params = key.split(",");

		return new Vertex(Long.parseLong(params[1]), Integer.parseInt(params[0]));
	}

}
