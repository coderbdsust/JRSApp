package com.jrsapp.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class RequestResponseFilter implements ContainerRequestFilter, ContainerResponseFilter {

	static Logger log = LoggerFactory.getLogger(RequestResponseFilter.class);

	public void filter(ContainerRequestContext ctx) throws IOException {
		Thread.currentThread().setName("RT" + System.currentTimeMillis());

		log.debug("start/ : filter(ContainerRequestContext ctx)");

		log(ctx.getUriInfo(), ctx.getHeaders());

		String methodOverride = ctx.getHeaderString("X-Http-Method-Override");
		if (methodOverride != null)
			ctx.setMethod(methodOverride);

		log.debug("end/   : filter(ContainerRequestContext ctx)");
	}

	@Override
	public void filter(ContainerRequestContext reqCtx, ContainerResponseContext resCtx) throws IOException {

		log.debug("start/ : filter(ContainerRequestContext reqCtx, ContainerResponseContext resCtx)");

		log(reqCtx.getUriInfo(), resCtx.getHeaders());

		log.debug("end/   : filter(ContainerRequestContext reqCtx, ContainerResponseContext resCtx)");

	}

	private void log(UriInfo uriInfo, MultivaluedMap<String, ?> headers) {
		log.debug("Path: " + uriInfo.getPath());
		headers.entrySet().forEach(h -> log.debug(h.getKey() + ": " + h.getValue()));
	}
}