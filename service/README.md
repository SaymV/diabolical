Diobolical
==========================

To build and deploy:

1. Copy SAMPLE-build.properties to build.properties.

2. Fill in the database username, password and any other missing properties that
   don't get checked into the repository.

3. `mvn clean package`

4. Your war file is in `target/`: deploy as you wish.  Install a `log4j.xml` in
   your web server or app server's classpath.

5. Configure your app server for authentication, if needed.

6. For PUTs and POSTs, you'll want to get Poster or other graphical client.

7. If you are using Eclipse, designate the following as "source folders":

   * `src/main/java`
   * `src/main/resources`
   * `src/test/java`
   * `target/generated-sources/jaxb`
