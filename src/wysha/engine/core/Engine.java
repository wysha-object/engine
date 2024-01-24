package wysha.engine.core;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author wysha
 */
public class Engine {
    private static Engine engine;
    private final Executor executor;
    private Engine(int corePoolSize) {
        executor = Executors.newScheduledThreadPool(corePoolSize);
        engine=this;
    }
    static void execute(Runnable runnable){
        engine.executor.execute(runnable);
    }
}
