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
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('957424531', '1', '1', '61629390000000', NULL, 'Deposito de dinero', NULL, '0');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('906969923', '0', '0', '61629390000000', NULL, 'Pago de deuda Tarjeta de credito.', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1144167410', '1', '123456798', '61629390000000', NULL, 'Deposito de dinero', NULL, '0');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1683905778', '0', '0', '61629390000000', NULL, 'Pago de deuda Tarjeta de credito.', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1359778048', '1', '12345678', '61629390000000', NULL, 'Deposito de dinero', NULL, '0');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('679149688', '1', '123445567', '61629390000000', NULL, 'Deposito de dinero', NULL, '0');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1657500422', '182605794', '123', '61629390000000', NULL, 'Transferencia de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('383342535', '0', '-12', '61629735600000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1176923594', '0', '1000', '61629735600000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('814353537', '0', '-1000', '61629735600000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('2054295512', '0', '1000', '61629735600000', NULL, 'Pago de deuda Tarjeta de credito.', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('55022277', '2', '1000', '61629735600000', NULL, 'Transferencia de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1889196024', '0', '1000', '61629735600000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1782648913', '0', '4000', '61629735600000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('310735442', '2', '1', '61629822000000', NULL, 'Transferencia de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('308487493', '0', '1212', '61629822000000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('310735442', '0', '4545', '61629822000000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('635979354', '0', '545', '61629822000000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1678558280', '2', '4', '61629822000000', NULL, 'Transferencia de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1548151004', '2', '123', '61629822000000', NULL, 'Transferencia de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('89550702', '0', '213', '61629822000000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1164778959', '0', '2', '61629822000000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('2090683785', '0', '123', '61629822000000', NULL, 'Pago de serivicio: FPUNA con javax.swing.JToggleButton$ToggleButtonModel@6c664f6e', 'FPUNA', '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('124321491', '0', '1000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1925544046', '0', '1000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1596257265', '0', '4500', '61629908400000', NULL, 'Pago de deuda Tarjeta de credito.', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('891466625', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('843329940', '0', '4000', '61629908400000', NULL, 'Pago de deuda Tarjeta de credito.', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('382922674', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('2107410143', '0', '4000', '61629908400000', NULL, 'Pago de deuda Tarjeta de credito.', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1051361862', '0', '16000', '61629908400000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('2139571814', '2', '1000', '61629908400000', NULL, 'Transferencia de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('926009782', '0', '200', '61629908400000', NULL, 'Pago de serivicio: CLARO', 'CLARO', '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1992209929', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('2073020905', '0', '4000', '61629908400000', NULL, 'Pago de deuda Tarjeta de credito.', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1559247743', '0', '12', '61629908400000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('936171368', '1', '12', '61629908400000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('2022458340', '1', '1000', '61629908400000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('980529895', '2', '1000', '61629908400000', NULL, 'Deposito de dinero', NULL, '2');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('245854181', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('124260984', '2', '1', '61629908400000', NULL, 'Transferencia de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('380448008', '1', '1', '61629908400000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('856611340', '0', '4000', '61629908400000', 'pagoTarjeta', 'Pago de deuda Tarjeta de credito.', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('869086859', '0', '8090', '61629908400000', NULL, 'Consulta de Saldo', NULL, '0');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('537875572', '0', '8090', '61629908400000', 'consultaSaldo', 'Consulta de Saldo', NULL, '0');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('369329309', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('682709071', '1', '12', '61629908400000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('856611340', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1346095158', '0', '4000', '61629908400000', 'pagoTarjeta', 'Pago de deuda Tarjeta de credito.', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('807468591', '0', '102', '61629908400000', 'consultaSaldo', 'Consulta de Saldo', NULL, '0');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1602219455', '0', '102', '61629908400000', 'consultaSaldo', 'Consulta de Saldo', NULL, '0');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1292792845', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('632653531', '0', '4000', '61629908400000', 'pagoTarjeta', 'Pago de deuda Tarjeta de credito.', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1921082534', '1', '1', '61629908400000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1942972153', '3', '1000000', '61629908400000', NULL, 'Transferencia de dinero', NULL, '5711576');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1613864381', '0', '4000000', '61629908400000', 'consultaSaldo', 'Consulta de Saldo', NULL, '0');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('625405246', '2', '500000', '61629908400000', NULL, 'Transferencia de dinero', NULL, '5404806');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1398359625', '3', '1000000', '61629908400000', NULL, 'Transferencia de dinero', NULL, '5711576');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1833298975', '2', '1000', '61629908400000', NULL, 'Transferencia de dinero', NULL, '5436434');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1962293959', '0', '1000', '61629908400000', 'pagoTarjeta', 'Pago de deuda Tarjeta de credito.', NULL, '5711576');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('2107789080', '0', '1000', '61629908400000', 'pagoTarjeta', 'Pago de deuda Tarjeta de credito.', NULL, '5436434');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('778250813', '2', '2', '61629908400000', NULL, 'Deposito de dinero', NULL, '2');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1063653877', '1', '4', '61629908400000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1975864756', '1', '4', '61629908400000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1631924879', '0', '1000000', '61629908400000', 'consultaSaldo', 'Consulta de Saldo', NULL, '0');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1885304013', '1', '4', '61629908400000', NULL, 'Deposito de dinero', NULL, '1');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('278856806', '2', '1000000', '61629908400000', NULL, 'Deposito de dinero', NULL, '2');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('915793247', '2', '200000', '61629908400000', NULL, 'Deposito de dinero', NULL, '2');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('517158413', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '5711576');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('559982314', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '5711576');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('462415562', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '5436434');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1993095965', '2', '50000', '61629908400000', NULL, 'Deposito de dinero', NULL, '2');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1097057691', '0', '4246000', '61629908400000', 'consultaSaldo', 'Consulta de Saldo', NULL, '0');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1623231205', '3', '123', '61629908400000', NULL, 'Transferencia de dinero', NULL, '5711576');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('442271436', '1', '100000', '61629908400000', NULL, 'Transferencia de dinero', NULL, '5711576');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('42866121', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '5711576');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('503623870', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '5711576');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1530152142', '0', '4000', '61629908400000', NULL, 'Pago de serivicio: FPUNA', 'FPUNA', '5711576');
insert into registro ("id_registro", "cuenta_destino", "monto", "fecha_transaccion", "forma_pago", "concepto", "id_Servicio", "cuenta_origen") values ('1016521260', '0', '8000', '61629908400000', 'pagoTarjeta', 'Pago de deuda Tarjeta de credito.', NULL, '5711576');
COMMIT;

BEGIN TRANSACTION;
insert into servicios ("id_Servicio", "descripcion", "deuda") values ('FPUNA', 'qofaebuIK', '4000');
insert into servicios ("id_Servicio", "descripcion", "deuda") values ('CLARO', 'yNvMaSE cc', '4000');
insert into servicios ("id_Servicio", "descripcion", "deuda") values ('TIGO', 'x jo gqaXq', '4000');
insert into servicios ("id_Servicio", "descripcion", "deuda") values ('ANDE', 'SouvXSxjZh', '4000');
COMMIT;
