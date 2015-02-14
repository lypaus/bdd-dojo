Feature:
	como cliente 
	quiero hacer mis pagos con tarjeta credito
	para poder acceder a los servicios de la asesoria
	
Scenario:
	Given ingreso a la opcion de pago
	When ingrese mi nombre "edwin", mi cedula "1101992192", mi fecha de vencimiento "31/12/2015", mi numero de tarjeta "1234567890", mi codigo de seguridad "edwin"
	And seleccione pagar
	Then debo ve "El pago se ha realizado exitosamente"