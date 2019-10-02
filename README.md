# Neo4J Example Unmanaged Extension

This is an example of an unmanaged extension following the
[example](https://neo4j.com/docs/java-reference/current/extending-neo4j/http-server-extensions/) 
from Neo4J documentation.

The test does not pass when trying to use `javax.ws.rs-api:2.0` as a dependency as suggested by the 
documentation for an unmanaged extension. I believe this has to do with the fact that `neo4j` 
depends on a [8 year old fork of the `jsr311-api`](https://github.com/neo4j/jsr311-api).

If instead you use the forked `jsr311` dependency for the javax annotations the tests pass fine.
