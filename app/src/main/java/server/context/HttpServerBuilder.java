package server.context;

import handler.request.RequestHandler;
import handler.response.ResponseHandler;
import server.HttpServer;
import server.impl.HttpServerImpl;

public class HttpServerBuilder {
    private int port;

    private RequestHandler requestHandler;

    private ResponseHandler responseHandler;

    public static final HttpServerBuilder of() {
        return new HttpServerBuilder();
    }

    private HttpServerBuilder() {}

    public HttpServerBuilder port(int port) {
        this.port = port;
        return this;
    }

    public HttpServerBuilder addHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
        return this;
    }

    public HttpServerBuilder addHandler(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
        return this;
    }

    public HttpServer build() {
        return new HttpServerImpl(port, requestHandler, responseHandler);
    }
}
