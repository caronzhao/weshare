package org.bks.util;

import java.io.Reader;

import com.google.gson.Gson;

/**
 * @author Caron Zhao
 *
 * Feb 24, 2014 10:16:31 PM
 */
public final class JsonTranslation {
	private static Gson gson = new Gson();
	
	private JsonTranslation() {
		throw new AssertionError();
	}
	
	public static String object2JsonString(Object object) {
		return gson.toJson(object);
	}
	
	public static <T> T jsonString2Object(String content, Class<T> clazz) {
		return gson.fromJson(content, clazz);
	}

    public static <T> T jsonString2Object(Reader reader, Class<T> clazz) {
        return gson.fromJson(reader, clazz);
    }
}