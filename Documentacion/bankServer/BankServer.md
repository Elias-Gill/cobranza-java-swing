La clase cuenta con metodos que modifan los datos de la cuenta de los clientes
Algunas de las funciones utilizan la herramienta de manejo de excepciones de java

# metodos de la clase:
### iniciarBaseDeDatos()
no recibe nada y retorna un objeto Connection que es la coneccion que tenemos con la base de datos

Como su nombre indica, inicia la base de datos
### NuevaTransferencia(transferencia)
Recibe un objeto de tipo Transferencia y retorna los datos del comprobante que se generara.
Valida si el pin de transaccion es valido y si el saldo es suficiente para realizar la transferencia

Si existe un error en la base de datos mientras se realizan estas operaciones se lanza una 
exception de tipo SQLException, ademas de restaurar los cambios realizados a ambas cuentas

### NuevoDeposito(Deposito)
Actualiza el saldo de la cuenta destino.
Recibe un objeto de tipo Deposito y retorna los datos del comprobante que generara el deposito.

### IniciarSesion(contrasena,cedula)
Recibe la contraseña y el numero de cedula del usuario.
Retorna la cuenta de la base de datos si es que se ingresaron los datos correctos.

Si se encontro la cuenta con la misma contraseña, se retorna la cuenta, sino
se lanza una excepcion indicando que las credenciales no son validas

### pagarServicio(pagoServicio)
Recibe un objeto de tipo pagoServicio.
Retorna Datos del comprobante que generara el pago del servicio.

Se paga el servicio que se desea, se paga por medio de una tarjeta de credito o descontando el 
saldo de la cuenta. Lanza una excepcion si se produce un error en las operaciones.

### pagarTarjeta(Cuenta,monto)
Recibe la cuenta que pagara con la tarjeta, el monto que pagara y el pin de transaccion.
Retorna los datos del comprobante.

Se paga las tarjetas con deuda y se actualiza el saldo de la cuenta.
Lanza una excepcion si ocurre un error en la ejecucion del metodo.

### pagarServicio(m,servicio)
Recibe el servicio a pagar y el monto.
Retorna los datos del comprobante.

Lanza una excepcion si ocurre un error en la ejecucion del metodo.

### consultarSaldo(datosComprobante)
recibe un objeto de tipo datosComprobante y no retorna nada

crea un nuevo registro

### getDeudaServicio(idServicio)
recibe el id del servicio y retorna la deuda de ese servicio

retorna la deuda del servicio que se busca dentro de la base de datos

