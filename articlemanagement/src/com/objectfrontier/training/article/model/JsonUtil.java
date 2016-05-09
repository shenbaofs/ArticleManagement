package com.objectfrontier.training.article.model;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	public static String toJSON(Object input) {
	    try {
			return mapper.writeValueAsString(input);
		} catch (Exception e) {
			throw new AppException(e);
		}
	}

	public static <T> T fromJSON(String json, Class<T> clazz) {
	    try {
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new AppException(e);
		}
	}
}
 