# Academia Lab

Projeto criado para praticar conceitos básicos de observabilidade em uma API Spring Boot.

O domínio de academia foi usado apenas como contexto para implementar alunos e treinos. O objetivo principal não foi criar um produto completo, mas entender como uma aplicação pode ser executada, monitorada e investigada.

## Conceitos praticados

- Logs com níveis `INFO` e `ERROR`
- Tratamento global de exceptions
- Health check com Spring Boot Actuator
- Métricas com Micrometer
- Coleta de métricas com Prometheus
- Visualização de métricas no Grafana
- Tracing e `traceId` com Zipkin
- Execução da API e da infraestrutura com Docker Compose

## Tecnologias

- Java 17
- Spring Boot
- PostgreSQL
- Flyway
- Docker
- Actuator e Micrometer
- Prometheus e Grafana
- Zipkin

## Aprendizado principal

Logs explicam o que aconteceu dentro da aplicação, métricas mostram o comportamento do sistema ao longo do tempo e traces acompanham o caminho de uma requisição.

Esses recursos ajudam a identificar falhas, lentidão e comportamentos anormais, sendo ainda mais importantes em arquiteturas de microserviços.
