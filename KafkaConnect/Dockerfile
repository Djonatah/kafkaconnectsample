FROM bitnami/kafka:latest
LABEL name="KafkaConnectSample"
USER root:root
RUN mkdir -p /opt/bitnami/kafka/plugins
RUN apt-get update -y && apt-get install -y curl
COPY ./debezium-connector-sqlserver /opt/bitnami/kafka/plugins
COPY ./debezium-connector-jdbc /opt/bitnami/kafka/plugins
COPY ./debezium-connector-jdbc /opt/bitnami/kafka/libs
RUN echo "plugin.path=/opt/bitnami/kafka/plugins" >> "/opt/bitnami/kafka/config/kraft/server.properties"
USER 1001