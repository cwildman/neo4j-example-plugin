package com.cwildman.neo4j;

import org.junit.Test;
import org.neo4j.harness.ServerControls;
import org.neo4j.harness.TestServerBuilder;
import org.neo4j.harness.TestServerBuilders;
import org.neo4j.kernel.configuration.ssl.LegacySslPolicyConfig;
import org.neo4j.server.ServerTestUtils;
import org.neo4j.test.server.HTTP;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.neo4j.server.ServerTestUtils.getSharedTestTemporaryFolder;

public class Neo4JExamplePluginTest {
    @Test
    public void testMyExtension() throws Exception {
        try (final ServerControls server = getServerBuilder()
                .withExtension("/myExtension", Neo4JExamplePlugin.class)
                .newServer()) {
            final HTTP.Response response = HTTP.GET(
                    HTTP.GET(server.httpURI().resolve("myExtension").toString()).location());
            assertEquals(200, response.status());
        }
    }

    private TestServerBuilder getServerBuilder() throws IOException {
        final TestServerBuilder serverBuilder = TestServerBuilders.newInProcessBuilder();
        final String path = ServerTestUtils.getRelativePath(
                getSharedTestTemporaryFolder(), LegacySslPolicyConfig.certificates_directory);
        serverBuilder.withConfig(LegacySslPolicyConfig.certificates_directory.name(), path);
        return serverBuilder;
    }
}
