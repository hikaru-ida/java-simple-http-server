import base.concurrent.WorkerThreadFactory;
import handler.request.RequestHandler;
import handler.response.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.NioHttpServer;
import server.context.NioHttpServerBuilder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerBootstrap {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerBootstrap.class);

    public static void main(String[] args) {
        try {
            NioHttpServer httpServer = NioHttpServerBuilder.of()
                    .inetSocketAddress(new InetSocketAddress(1234))
                    .addHandler(new ResponseHandler())
                    .addHandler(new RequestHandler())
                    .build();
            EXECUTOR_SERVICE.execute(WorkerThreadFactory.of().newThread(httpServer));
        } catch (Exception e) {
            LOGGER.error(e.getCause().getMessage());
        } finally {
            EXECUTOR_SERVICE.shutdown();
        }
    }
}