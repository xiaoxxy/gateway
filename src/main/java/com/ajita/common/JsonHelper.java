package com.ajita.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JsonHelper {
	private static final ObjectMapper mapperStrengh = new ObjectMapper();
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final SimpleModule module = new SimpleModule("JSONModule", new Version(2, 0, 0, null,null,null));
	private static final JsonSerializer<Long> LONG_DESERIALIZER = new JsonSerializer<Long>() {

		@Override
		public void serialize(Long arg0, JsonGenerator arg1, SerializerProvider arg2)
				throws IOException, JsonProcessingException {
			if (arg0 > 9007199254740990L) {
				arg1.writeString(arg0.toString());
			} else {
				arg1.writeNumber(arg0);
			}
		}

	};
	static {
		module.addSerializer(Long.class, LONG_DESERIALIZER);
		mapperStrengh.registerModule(module);
	}

	public static String toJSON(Object obj) {
		StringWriter writer = new StringWriter();
		try {
			mapperStrengh.writeValue(writer, obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return writer.toString();
	}

	@SuppressWarnings("unchecked")
	public static <T> T fromJSON(String json, Class<?> clazz) {
		try {
			 mapper.configure(Feature.ALLOW_MISSING_VALUES, true);
			return (T) mapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T fromJSON(InputStream json, Class<?> clazz) {
		try {
			return (T) mapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJSON(String json, TypeReference<T> valueTypeRef) {
		try {
			return mapper.readValue(json, valueTypeRef);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
