Feature:
  Como cliente
  quiero acceder al chat online
  para contactarme con un asesor 

  Scenario: hago click en la opcion de chat
    Given ingreso al chat de la pagina
    When ingrese mi consulta
    And haga click en enviar
    Then debo ver "Mensaje enviado"