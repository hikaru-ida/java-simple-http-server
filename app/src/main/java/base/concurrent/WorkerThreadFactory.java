package base.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;

public class WorkerThreadFactory implements ThreadFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerThreadFactory.class);

    private WorkerThreadFactory() {}

    public static WorkerThreadFactory of() {
        return new WorkerThreadFactory();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(
                (t, e) -> {
                    LOGGER.error(
                            String.format(
                                    "Unexpected error has been occured in %s: %s",
                                    t.getName(), e.getCause().getMessage()));
                });
        return thread;
    }
}
