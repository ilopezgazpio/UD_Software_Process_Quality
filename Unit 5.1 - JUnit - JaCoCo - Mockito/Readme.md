Useful maven commands
=====================

- Run JUnit tests: ```mvn test```
- Run code coverage test: ```mvn jacoco:check```
- Run checkstyle plugin: ```mvn checkstyle:checkstyle```
- Run java dependency: ```mvn jdepend:generate```

Also possible to run combinations, e.g.: ```mvn test jacoco:check```

Integrate specific reports on the dashboard: ```mvn dashboard:dashboard```

Generate full project dashboard: ```mvn site```
