package org.weshare.web.rest.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.weshare.model.RegisterProfile;
import org.weshare.util.JsonTranslation;

/**
 * @author Caron Zhao
 *
 * Mar 16, 2014 11:18:43 PM
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JsonRegisterProfileProvider implements MessageBodyReader<RegisterProfile> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return RegisterProfile.class.isAssignableFrom(type);
	}

	@Override
	public RegisterProfile readFrom(
			Class<RegisterProfile> object,
			Type type,
			Annotation[] annotations,
			MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders,
			InputStream inputStream) throws IOException, WebApplicationException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i = -1;
		while ((i = inputStream.read()) != -1) {
			baos.write(i);
		}

		return JsonTranslation.jsonString2Object(baos.toString(), RegisterProfile.class);
	}
}