package server;

import org.eclipse.jetty.server.Server;

public class JettyServer implements AutoCloseable {
    private final Server server;

    JettyServer(final Server server) {
        this.server = server;
    }

    public void start() throws Exception {
        server.start();
        server.join();
    }

    @Override
    public void close() {
        server.destroy();
    }
}
