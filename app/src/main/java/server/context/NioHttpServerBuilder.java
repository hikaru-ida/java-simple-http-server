package server.context;

import handler.request.RequestHandler;
import handler.response.ResponseHandler;
import server.NioHttpServer;
import server.impl.NioHttpServerImpl;

import java.net.InetSocketAddress;

public class NioHttpServerBuilder {
    private InetSocketAddress inetSocketAddress;

    private RequestHandler requestHandler;

    private ResponseHandler responseHandler;

    public static final NioHttpServerBuilder of() {
        return new NioHttpServerBuilder();
    }

    private NioHttpServerBuilder() {}

    public NioHttpServerBuilder inetSocketAddress(InetSocketAddress inetSocketAddress) {
        this.inetSocketAddress = inetSocketAddress;
        return this;
    }

    public NioHttpServerBuilder addHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
        return this;
    }

    public NioHttpServerBuilder addHandler(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
        return this;
    }

    public NioHttpServer build() throws Exception {
        return new NioHttpServerImpl(inetSocketAddress, requestHandler, responseHandler);
    }
}
