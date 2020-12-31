package com.jrsapp.api;

import java.util.Date;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jrsapp.cache.Channel;
import com.jrsapp.cache.ResponseCode;
import com.jrsapp.dto.Bean;

/*
 * Basic Rest-EndPoint
 */
@Path("")
public class JRSController {
	static Logger log = LoggerFactory.getLogger(JRSController.class);

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response home() {
		log.debug("GET /");
		Bean.Response res = new Bean.Response();
		res.setAttribute("responseCode", 0);
		res.setAttribute("reponseMsg", "Welcome JaxRS Home");
		return Response.ok().entity(res.getResponse()).build();
	}

	@POST
	@Path("/AppService")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response appService(Bean.Request req) {

		log.debug("POST /AppService");

		log.debug("" + req);
		Bean.Response res = new Bean.Response();

		res.setAttribute("responseId", UUID.randomUUID());
		res.setAttribute("responseCode", ResponseCode.SUCCESS.getValue());
		res.setAttribute("responseMsg", "Welcome AppService");
		res.setAttribute("response", req);
		res.setAttribute("channelId", Channel.App.getValue());

		return Response.ok().entity(res.getResponse()).build();
	}

	@POST
	@Path("/DesktopService")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response desktopService(Bean.Request req) {
		log.debug("POST /DesktopService");

		log.debug("" + req);
		Bean.Response res = new Bean.Response();
		res.setAttribute("responseId", UUID.randomUUID());
		res.setAttribute("responseCode", ResponseCode.SUCCESS.getValue());
		res.setAttribute("responseMsg", "Welcome DesktopService");
		res.setAttribute("response", req);
		res.setAttribute("channelId", Channel.Desktop.getValue());
		return Response.ok().entity(res.getResponse()).build();
	}

	@POST
	@Path("/WebService")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response webService(Bean.Request req) {
		log.debug("POST /WebService");

		log.debug("" + req);
		Bean.Response res = new Bean.Response();
		res.setAttribute("responseId", UUID.randomUUID());
		res.setAttribute("responseCode", ResponseCode.SUCCESS.getValue());
		res.setAttribute("responseMsg", "Welcome AppService");
		res.setAttribute("response", req);
		res.setAttribute("channelId", Channel.Web.getValue());
		return Response.ok().entity(res.getResponse()).build();
	}

	@GET
	@Path("/ReloadService")
	@Produces(MediaType.APPLICATION_JSON)
	public Response reloadService() {
		log.debug("GET /ReloadService");
		Bean.Response res = new Bean.Response();
		res.setAttribute("responseId", UUID.randomUUID());
		res.setAttribute("responseCode", ResponseCode.SUCCESS.getValue());
		res.setAttribute("responseMsg", "Preferences Reloaded");
		res.setAttribute("response", new Date());
		return Response.ok().entity(res.getResponse()).build();
	}
}
