Feature:
  Como cliente o administrador
  quiero ingresar a un formulario
  para registrarme como usuario del sistema y poder identificarme e interactuar con la aplicación

  Scenario: hago click en la opcion de crear usuario
    Given ingreso al formulario de creacion
    When ingrese mi nombre "admin", mi apellido "admin", mi usuario "edwin" y mi password "87654321"
    And hago click en crear
    Then debo ver "Usuario Creado Corretamente, edwin"