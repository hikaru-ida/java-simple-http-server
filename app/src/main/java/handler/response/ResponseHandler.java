package handler.response;

import base.data.Request;
import base.data.Response;
import base.data.Status;
import base.exception.NioHttpServerException;
import handler.HttpServerHandler;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class ResponseHandler implements HttpServerHandler<Request, Response> {
    @Override
    public Response apply(Request request) throws NioHttpServerException {
        if (!Objects.equals(request.getMethod(), "GET")) {
            return new Response(
                    Status.BAD_REQUEST,
                    "text/html;charset=utf8",
                    String.format("Cannot handle %s method", request.getMethod())
                            .getBytes(StandardCharsets.UTF_8));
        }

        if (Objects.equals(request.getPath(), "/hello")) {
            return new Response(
                    Status.OK,
                    "text/html;charset=utf8",
                    "Hello, NioHttpServer!".getBytes(StandardCharsets.UTF_8));
        }

        return new Response(
                Status.NOT_FOUND, "text/html;charset=utf8","NotFound".getBytes(StandardCharsets.UTF_8));
    }
}
