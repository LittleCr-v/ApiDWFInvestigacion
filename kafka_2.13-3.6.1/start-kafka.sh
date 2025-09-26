#!/bin/bash

KAFKA_DIR="$(pwd)"
CONFIG_FILE="$KAFKA_DIR/config/kraft/server.properties"
DATA_DIR="$KAFKA_DIR/kafka-logs"
TOPIC_NAME="empleados-creados"

echo "🚀 Iniciando Kafka desde: $KAFKA_DIR"

# 1. Si no existe almacenamiento inicializado, lo creamos
if [ ! -d "$DATA_DIR" ]; then
  echo "📦 Inicializando almacenamiento de Kafka..."
  UUID=$($KAFKA_DIR/bin/kafka-storage.sh random-uuid)
  $KAFKA_DIR/bin/kafka-storage.sh format -t $UUID -c $CONFIG_FILE
fi

# 2. Levantamos Kafka en background
echo "⚡ Arrancando el broker..."
$KAFKA_DIR/bin/kafka-server-start.sh -daemon $CONFIG_FILE

# 3. Esperamos unos segundos a que arranque
sleep 5

# 4. Creamos el topic si no existe
if ! $KAFKA_DIR/bin/kafka-topics.sh --list --bootstrap-server localhost:9092 | grep -q $TOPIC_NAME; then
  echo "📝 Creando topic: $TOPIC_NAME"
  $KAFKA_DIR/bin/kafka-topics.sh --create --topic $TOPIC_NAME \
    --bootstrap-server localhost:9092 \
    --partitions 1 \
    --replication-factor 1
else
  echo "✔️ El topic $TOPIC_NAME ya existe"
fi

echo "✅ Kafka está corriendo en localhost:9092"
