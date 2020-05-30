# Back-Benice
Este es el back en Java. Ya esta desplegado una aplicación con un servicio dummy y con un servicio prueba:
1.  https://heroku-benice.herokuapp.com/ -> hola mundo en texto plano
2.  https://heroku-benice.herokuapp.com/benice/v1/user/auth/ -> POST con body:
    ```javascript
    { "user": "nombre usuario", "password": "Cualquier cosa"}
    ```
    Este devolverá una respuesta en formaro JSON, se pueda usar 
    [Postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop) o cualquier otra herramienta similar       para consumir el servicio
    
## Despliegue 

### Para poder correr el proyecto desde eclipse por primera vez, se debe hacer :
1.  Importar el proyecto, como proyecto maven existente
2.  click derecho sobre el proyecto ->Run As->Maven Install
2.  click derecho sobre el proyecto ->Run As->Maven Build...
2.  En la opción Goals colocar: spring-boot:run

Esto iniciará el servicio exponiendo el puerto 8080 de la máquina. Cualquier cambio que se haga se podrá ver en local, sin que se reinicie o detenga el proyecto. Si por alguna razón se detuvo el proyecto o se cerró eclipse o lo que sea. La tarea sigue ejecutándose.
Si se requiere detener por completo la tarea de debe buscar el puerto *netstat -ano | findstr :8080* Y con el PID que arroge *taskkill /PID numero_PID /F*



### Para poder crear y desplegar una app en heroku por primera vez:
1. Se debe de tener instalado el CLI de heroku.

2. En el directorio del repositorio se debe autenticar con su cuenta de heroku: *heroku login* o *winpty heroku login*

3. Se debe crear la app en heroku: *heroku create*. Esto crea añade un remoto al repositorio local llamadado *heroku* y tambien crea un app con un nombre random.

4. Si se quiere, se puede cambiar el nombre *random* de la app generada: *heroku apps:rename --app nombre-random nombre_que_quiera*.

5. Se debe de hacer push al repo remoto de heroku para desplegar los cambios que se tienen actualmente:*git push heroku master*. Esto despliega los cambios, puede tomar unos minutos en que se vean reflejados.

6. Para poder ver la URL del despligue: *heroku open*. Esto mostrara un *Hola mundo* como servicio dummy en el navegador para comprobar que el despligue fue exitoso. También se puede consumir el servicio POST *https://nombre_app/benice/v1/user/auth/* con body :
    ```javascript
    { "user": "nombre usuario", "password": "Cualquier cosa"}
    ```
    Este devolvera una respuesta en formaro JSON, se pueda usar 
    [Postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop) o cualquier otra herramienta similar       para consumir el servicio

