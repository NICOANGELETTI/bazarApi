# Proyecto de Bazar API 📝

## Descripción

Este proyecto es una API desarrollada con Spring Boot que gestiona las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de un sistema de ventas de un bazar. Permite realizar operaciones sobre clientes, productos y ventas.

## Funcionalidades

- Crear, leer, actualizar y eliminar clientes.
- Crear, leer, actualizar y eliminar productos.
- Crear, leer, actualizar y eliminar ventas.
- Obtener datos de ventas por fecha.
- Obtener la venta con el monto mayor.
- Obtener productos con bajo stock.

## Uso

### Cliente

- `POST /clientes/crear`: Crea un nuevo cliente.
- `GET /clientes`: Obtiene la lista de todos los clientes.
- `GET /clientes/{id_cliente}`: Obtiene un cliente por su ID.
- `DELETE /clientes/eliminar/{id_cliente}`: Elimina un cliente por su ID.
- `PUT /clientes/editar/{id_cliente}`: Edita un cliente por su ID.

### Producto

- `POST /productos/crear`: Crea un nuevo producto.
- `GET /productos`: Obtiene la lista de todos los productos.
- `GET /productos/{codigo_producto}`: Obtiene un producto por su código.
- `DELETE /productos/eliminar/{codigo_producto}`: Elimina un producto por su código.
- `PUT /productos/editar/{id_producto}`: Edita un producto por su ID.
- `GET /productos/falta_stock`: Obtiene los productos con bajo stock.

### Venta

- `POST /ventas/crear`: Crea una nueva venta.
- `GET /ventas`: Obtiene la lista de todas las ventas.
- `GET /ventas/{codigo_venta}`: Obtiene una venta por su código.
- `DELETE /clientes/ventas/eliminar/{codigo_venta}`: Elimina una venta por su código.
- `PUT /clientes/ventas/editar/{codigo_venta}`: Edita una venta por su código.
- `GET /ventas/productos/{codigo_venta}`: Obtiene los productos de una venta por su código.
- `GET /ventas/traerDatos/{fecha_venta}`: Obtiene los datos de las ventas por fecha.
- `GET /ventas/mayor_venta`: Obtiene la venta con el monto mayor.

## Tecnologías Utilizadas

- Spring Boot
- Java
- MySQL
- Hibernate

## Instalación y Configuración

1. Clona este repositorio.
2. Importa el proyecto en tu IDE.
3. Configura la conexión a la base de datos MySQL en `application.properties`.
4. Ejecuta la aplicación.

