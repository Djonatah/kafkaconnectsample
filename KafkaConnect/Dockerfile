FROM bitnami/kafka:latest
LABEL name="KafkaConnectSample"
USER root:root
RUN mkdir -p /opt/bitnami/kafka/plugins \
    && apt-get update -y  \
    && apt-get install -y curl
COPY ./debezium-connector-sqlserver /opt/bitnami/kafka/plugins/debezium-connector-sqlserver
COPY ./debezium-connector-jdbc /opt/bitnami/kafka/plugins/debezium-connector-jdbc
COPY ./connect-standalone.properties /opt/bitnami/kafka/config
RUN echo "plugin.path=/opt/bitnami/kafka/plugins" >> "/opt/bitnami/kafka/config/kraft/server.properties"
USER 1001