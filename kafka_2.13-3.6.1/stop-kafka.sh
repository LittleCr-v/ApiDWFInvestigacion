#!/bin/bash

KAFKA_DIR="$(pwd)"
CONFIG_FILE="$KAFKA_DIR/config/kraft/server.properties"

echo "🛑 Deteniendo Kafka..."

$KAFKA_DIR/bin/kafka-server-stop.sh $CONFIG_FILE

# Esperamos un poco para que cierre
sleep 3

# Verificamos si aún sigue corriendo
PID=$(jps -l | grep kafka.Kafka | awk '{print $1}')

if [ -n "$PID" ]; then
  echo "⚠️ Kafka aún sigue corriendo (PID: $PID), forzando kill..."
  kill -9 $PID
else
  echo "✅ Kafka detenido correctamente"
fi
