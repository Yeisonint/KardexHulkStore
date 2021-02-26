### Pre-requisitos 📋

Asegurate de tener una version de Java (11 en adelante) en el equipo, luego descarga este repositorio.

```
git clone https://github.com/Yeisonint/KardexHulkStore
```

### Iniciar el servidor 🔧

Ejecuta una terminal en la carpeta donde esta el repositorio y ejecuta:

Linux
```
./mvnw spring-boot:run 
```
Windows
```
./mvnw.cmd spring-boot:run 
```
Cuando termine de iniciar, abre el navegador en http://localhost:8080/, puedes acceder a la consola de H2 para visualizar la base de datos en http://localhost:8080/h2-console, los datos de acceso son admin (usuario y contraseña)

