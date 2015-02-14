Feature:
	como cliente 
	quiero tener un formulario
	para agendar las citas que desee con el asesor juridico principal
	
Scenario:
	Given ingreso al formulario de agendamento
	When ingrese mi nombre "edwin", mi apellido "perez", mi correo electronico "eperez@hotmail.com", dia de la cita "25/02/2015", hora de la cita "08:00"
	And clic en el boton de agendar
	Then debo ver "Su cita ha sido agendada el dia "25/02/2015" 08:00 puede verificar esta informacion al correo "eperez@hotmail.com"
	
	