# ApiDWFInvestigacion
# Instrucciones para el inicio de la API

Para comenzar debes levantar kafka mediante la terminal, abre una terminal en la carpeta de "kafka_2.13-3.6.1" y ejecuta el comando 
# ./start-kafka.sh
De esta manera veras que el servicio comezara a levantarse, al estar arriba veras un mensaje de aviso el cual te dira que el servicio esta corriendo.

Una vez realizado esto ya puede iniciar la API desde el ID, ejecutando la clase principal.

Las pruebas se pueden realizar mediante Postman o cualquier otro programa parecido para el Test de API's.

# Formas de prueba:

# GET http://localhost:8080/api/empleados
Se obtendran todos los empleado ingresados desde que se inicio la API teniendo en cuenta que esta tiene una bdd de H2.

# GET http://localhost:8080/api/empleados/{id}
Se obtendra el empleado buscado por su id, si dicho id no existe se nos dara un mensaje de error.

# POST http://localhost:8080/api/empleados
# {
#  "nombre": "Fatima Ruiz",
#  "puesto": "Facturador",
#  "salario": 2500.50
# }

De esta manera podremos ingresar empleado a nuestra base de datos de H2.

# PUT http://localhost:8080/api/empleados/{id}
# {
#  "nombre": "Fatima Ruiz",
#  "puesto": "Líder Cuentas",
#  "salario": 1800.75
# }

Actualizar empleado mediante su id.

# DELETE http://localhost:8080/api/empleados/{id}

Eliminaremos al empleado mediante su id.

Creadores:
Daniel Alexander Girón Cornejo
Cristian Gerardo Ventura Rendón
Francisco Armando Morales Flores
Diego Fernando Ruiz Valle
