# MQTEST

This test library is intended to be used to test the MQ Connectivity for connecting to a TLS secured Queue Manager

This test application is a Spring Boot application and is setup to mimic the existing REDList MQ publishing code that's
seen in Rio Trickle Server.

This test has been run against the latest IBM Provided WebSphere MQ Docker Image found on Docker:

```bash
docker pull ibmcom/mq:latest
```

We followed the instructions found here to test TLS on WebSphere MQ:

```bash
https://developer.ibm.com/messaging/learn-mq/mq-tutorials/secure-mq-tls/
```
We created a self signed certificate and added that to a keystore just like the instructions showed.

The keystore password we created is:  changeme

The uid/pwd for the DEV.APP.SVRCONN works out to app/MQ-TLS-TEST!
  
You should be able to use the JAR build from this test
## Cipher Suite
We have successfully tested this app using the following Cipher Suite:

TLS_RSA_WITH_AES_256_CBC_SHA256

Change the IBM_MQ_CIPHER_SUITE environment variable to use different Cipher Suites to test with
  
## Build

To build the executable jar, run:

mvn package -Dmaven.test.skip=true

We indicate to maven to skip the tests as it tries to bring up the Spring Context, which can fail if the MQ Connectivity is not correct


## Environment Variables

The following environment variable **MUST** be set for this mqtest app to work correctly:

```bash
For Unix/OSX bash shells use:

export IBM_MQ_QUEUEMANAGER=QM1
export IBM_MQ_PASSWORD=MQ-TLS-TEST!
export IBM_MQ_HOSTNAME=localhost
export IBM_MQ_CHANNEL=DEV.APP.SVRCONN
export IBM_MQ_QUEUENAME=DEV.QUEUE.3
export IBM_MQ_USER=app
export IBM_MQ_PORT=1414
export IBM_MQ_SESSION_CACHE_SIZE=10
export IBM_MQ_CIPHER_SUITE=TLS_RSA_WITH_AES_256_CBC_SHA256

and for Windows Use:

setenv IBM_MQ_QUEUEMANAGER=QM1
setenv IBM_MQ_PASSWORD=MQ-TLS-TEST!
setenv IBM_MQ_HOSTNAME=localhost
setenv IBM_MQ_CHANNEL=DEV.APP.SVRCONN
setenv IBM_MQ_QUEUENAME=DEV.QUEUE.3
setenv IBM_MQ_USER=app
setenv IBM_MQ_PORT=1414
setenv IBM_MQ_SESSION_CACHE_SIZE=10
setenv IBM_MQ_CIPHER_SUITE=TLS_RSA_WITH_AES_256_CBC_SHA256

```

## Usage

The mqtest application is built as a "runnable" jar.

To run the app on our system we used the following command:

```bash
java -Dspring.profiles.active=prod  -Djavax.net.ssl.trustStoreType=jks -Djavax.net.ssl.trustStore=/Users/jboyle/Downloads/albertsons/mqtest/cert/clientkey.jks -Djavax.net.ssl.trustStorePassword=changeme -Dcom.ibm.mq.cfg.useIBMCipherMappings=false -jar target/mqtest-0.0.1-SNAPSHOT.jar
```

Note: for our testing we use the dev profile:  -Dspring.profiles.active=prod

## Sample Output

Below is the sample output from our run

```bash
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.5.RELEASE)

2020-02-28 08:46:06.369  INFO 89556 --- [           main] com.rls.mqtest.MqtestApplication         : Starting MqtestApplication v0.0.1-SNAPSHOT on Jeffs-MacBook-Pro-2.local with PID 89556 (/Users/jboyle/Downloads/albertsons/mqtest/target/mqtest-0.0.1-SNAPSHOT.jar started by jboyle in /Users/jboyle/Downloads/albertsons/mqtest)
2020-02-28 08:46:06.371  INFO 89556 --- [           main] com.rls.mqtest.MqtestApplication         : The following profiles are active: dev
2020-02-28 08:46:07.170  INFO 89556 --- [           main] com.rls.mqtest.MqtestApplication         : Started MqtestApplication in 1.059 seconds (JVM running for 1.381)
2020-02-28 08:46:07.171  INFO 89556 --- [           main] com.rls.mqtest.MqtestApplication         : EXECUTING : mqtest starting
2020-02-28 08:46:07.679  INFO 89556 --- [           main] com.rls.mqtest.MqtestApplication         : EXECUTING : mqtest completed

```
## Contributing
Pull requests are welcome.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)