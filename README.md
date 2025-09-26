# ApiDWFInvestigacion

## Descripción
Este proyecto es una API para la gestión de empleados, construida con **Java y Spring Boot**. La API utiliza **H2 Database** para almacenar los datos y **Kafka** para la comunicación de eventos.  

Permite realizar operaciones CRUD sobre los empleados y se puede probar mediante herramientas como **Postman**.

---

## Requisitos previos
- Java 17 o superior
- Maven
- Kafka (versión 3.6.1)
- IDE compatible con Java (IntelliJ IDEA, Eclipse, etc.)
- Postman o cualquier herramienta para test de APIs

---

## Configuración y ejecución

### 1. Levantar Kafka
1. Abre una terminal en la carpeta `kafka_2.13-3.6.1`.
2. Ejecuta el script de inicio:

#### ./start-kafka.sh

3. Espera a que Kafka indique que el servicio está corriendo correctamente.

### 2. Ejecutar la API
1. Abre tu IDE y carga el proyecto.
2. Ejecuta la clase principal:
   
com.dwfin.ApiDwfTeoApplication

3. La API se levantará en http://localhost:8080/

### Endpoints de la API
1. Obtener todos los empleado:
   GET /api/empleados
Devuelve una lista de todos los empleados almacenados en la base de datos H2.

2. Obtener un empleado por ID
   GET /api/empleados/{id}
Devuelve el empleado correspondiente al ID proporcionado.
Si el ID no existe, retorna un mensaje de error.

3. Crear un nuevo empleado
  POST /api/empleados
  Content-Type: application/json
  {
    "nombre": "Fatima Ruiz",
    "puesto": "Facturador",
    "salario": 2500.50
  }
Inserta un nuevo empleado en la base de datos.

4. Actualizar un empleado
  PUT /api/empleados/{id}
  Content-Type: application/json
  {
    "nombre": "Fatima Ruiz",
    "puesto": "Líder Cuentas",
    "salario": 1800.75
  }
Actualiza los datos del empleado identificado por el ID.

5. Eliminar un empleado
  DELETE /api/empleados/{id}
Elimina el empleado identificado por el ID.

### Notas
- La base de datos utilizada es H2 (en memoria). Los datos se perderán al reiniciar la aplicación.
- Kafka debe estar corriendo antes de iniciar la API para que los eventos se gestionen correctamente.

### Creadores

- Daniel Alexander Girón Cornejo
- Cristian Gerardo Ventura Rendón
- Francisco Armando Morales Flores
- Diego Fernando Ruiz Valle
