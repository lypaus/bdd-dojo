Feature:
	como comprador
	quiero hacer login
	para que el sistema identifique mis datos de comprador
	
Scenario:
	Given ingreso a la pagina web
	When ingrese mi usuario "hernando" y mi password "12345678"
	And hago login
	Then debo ver "Bienvenido a MiAbog.com, hernando"
	
Scenario:
	Given ingreso a la tienda virtual
	When ingrese mi usuario "edwin" y mi password "87654321"
	And hago login
	Then debo ver "Bienvenido a MiAbog.com, edwin"