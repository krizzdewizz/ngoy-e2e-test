# ngoy-e2e-test

[ngoy](https://github.com/krizzdewizz/ngoy) is a template engine for the JVM, based on the Angular component architecture.

This repo contains a ngoy web app served with Spring Boot to run JMeter tests against.

Tests:
- Single ngoy instance with session state
- Load test (planned)

Clone the repo to get started:

```
git clone https://github.com/krizzdewizz/ngoy-e2e-test
```

```
cd ngoy-e2e-test
```

Run the web server:

```
gradle run
```

Run the test:

```
$ jmeter\session-state-test
```
