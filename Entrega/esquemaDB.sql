CREATE TABLE sqlite_sequence(name,seq);
CREATE TABLE registro (
    "id_registro" INTEGER NOT NULL,
    "cuenta_destino" INTEGER,
    "monto" INTEGER NOT NULL,
    "fecha_transaccion" DATE NOT NULL,
    "forma_pago" INTEGER,
    "concepto" TEXT NOT NULL,
    "id_Servicio" TEXT,
    "cuenta_origen" INTEGER NOT NULL
);
CREATE TABLE "cuentas" (
	"nro_cuenta"	INTEGER NOT NULL,
	"cedula"	INTEGER NOT NULL,
	"apellido"	TEXT NOT NULL,
	"nombre"	TEXT NOT NULL,
	"direccion"	TEXT NOT NULL,
	"telefono"	TEXT NOT NULL,
	"saldo"	INTEGER NOT NULL,
	"contrasena"	TEXT NOT NULL,
	"pin_transaccion"	INTEGER NOT NULL,
	"nro_tarjeta"	INTEGER NOT NULL,
	"pin_Tarjeta"	INTEGER NOT NULL,
	"cVV"	INTEGER NOT NULL,
	"saldo_Tarjeta"	INTEGER NOT NULL,
	"saldo_Base_Tarjeta"	INTEGER NOT NULL DEFAULT (2000000),
	"deuda_Tarjeta"	INTEGER NOT NULL DEFAULT (0),
	PRIMARY KEY("nro_cuenta" AUTOINCREMENT)
);
CREATE TABLE servicios (
    "id_Servicio" TEXT NOT NULL,
    "descripcion" TEXT NOT NULL
, "deuda" INTEGER   DEFAULT (4000));

BEGIN TRANSACTION;
insert into cuentas ("nro_cuenta", "cedula", "apellido", "nombre", "direccion", "telefono", "saldo", "contrasena", "pin_transaccion", "nro_tarjeta", "pin_Tarjeta", "cVV", "saldo_Tarjeta", "saldo_Base_Tarjeta", "deuda_Tarjeta") values ('1', '5223084', 'Elias', 'Gill', 'Tapiracuai', '0985-8585', '1100004', 'elias', '1', '1970201187', '1234', '321', '1000000', '2500', '0');
insert into cuentas ("nro_cuenta", "cedula", "apellido", "nombre", "direccion", "telefono", "saldo", "contrasena", "pin_transaccion", "nro_tarjeta", "pin_Tarjeta", "cVV", "saldo_Tarjeta", "saldo_Base_Tarjeta", "deuda_Tarjeta") values ('2', '5711576', 'Rodri', 'Anrnaldo', 'Asuncion', '0985-8585', '4129877', 'rodri', '2', '120706635', '1234', '321', '1001000', '2500', '0');
insert into cuentas ("nro_cuenta", "cedula", "apellido", "nombre", "direccion", "telefono", "saldo", "contrasena", "pin_transaccion", "nro_tarjeta", "pin_Tarjeta", "cVV", "saldo_Tarjeta", "saldo_Base_Tarjeta", "deuda_Tarjeta") values ('3', '5404806', 'Abel', 'Diaz', 'Carapegua', '0985-8585', '6000123', 'abel', '3', '506843774', '1234', '321', '1000000', '2500', '1000');
insert into cuentas ("nro_cuenta", "cedula", "apellido", "nombre", "direccion", "telefono", "saldo", "contrasena", "pin_transaccion", "nro_tarjeta", "pin_Tarjeta", "cVV", "saldo_Tarjeta", "saldo_Base_Tarjeta", "deuda_Tarjeta") values ('4', '5436434', 'Andres', 'Andres', 'Itaugua', '0985-8585', '4994000', 'andres', '4', '1722108130', '1234', '321', '1001000', '2500', '0');
COMMIT;

BEGIN TRANSACTION;
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1398052591', '2', '1234', '2022-11-23', NULL, 'Transferencia de dinero', NULL, '5223084');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('2045960562', '1', '12', '2022-11-23', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1449882410', '2', '123', '2022-11-23', NULL, 'Transferencia de dinero', NULL, '1');
COMMIT;

BEGIN TRANSACTION;
insert into servicios ("id_Servicio", "descripcion", "deuda") values ('FPUNA', 'qofaebuIK', '4000');
insert into servicios ("id_Servicio", "descripcion", "deuda") values ('CLARO', 'yNvMaSE cc', '4000');
insert into servicios ("id_Servicio", "descripcion", "deuda") values ('TIGO', 'x jo gqaXq', '4000');
insert into servicios ("id_Servicio", "descripcion", "deuda") values ('ANDE', 'SouvXSxjZh', '4000');
COMMIT;
