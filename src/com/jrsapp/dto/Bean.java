package com.jrsapp.dto;

import java.util.HashMap;

public class Bean {

	public static class Base {
		public HashMap<String, Object> container = new HashMap<String, Object>();

		public Base() {
		}

		public Base(HashMap<String, Object> container) {

			this.container = container;
		}

		public void setCAttribute(String key, Object value) {
			this.container.put(key, value);
		}

		public Object getCAttribute(String key) {
			return this.container.get(key);
		}

		public HashMap<String, Object> getContainer() {
			return container;
		}

		public void setContainer(HashMap<String, Object> container) {
			this.container = container;
		}

		@Override
		public String toString() {
			return "Base [container=" + container + "]";
		}
	}

	public static class Request {

		public HashMap<String, Object> request = new HashMap<String, Object>();

		public Request() {
		}

		public Request(HashMap<String, Object> request) {
			this.request = request;
		}

		public HashMap<String, Object> getRequest() {
			return request;
		}

		public void setRequest(HashMap<String, Object> request) {
			this.request = request;
		}

		@Override
		public String toString() {
			return "Request [request=" + request + "]";
		}

	}

	public static class Response {

		public HashMap<String, Object> response = new HashMap<String, Object>();

		public Response() {
		}

		public Response(HashMap<String, Object> response) {
			this.response = response;
		}

		public HashMap<String, Object> getResponse() {
			return response;
		}

		public void setResponse(HashMap<String, Object> response) {
			this.response = response;
		}

		public void setAttribute(String key, Object value) {
			this.response.put(key, value);
		}

		public Object getAttribute(Object key) {
			return this.response.get(key);
		}

		@Override
		public String toString() {
			return "Response [response=" + response + "]";
		}

	}

}
