Feature:
  Como Comprador
  quiero que el la tienda virtual me de la bienvenida
  para saber que voy a comprar en la mejor tienda virtual del pais.

  Scenario: veo la pantalla de bienvenida
    Given ingreso a la tienda virtual
    Then veo el mensaje "Bienvenido a MiAbog.com el mejor sitio de asesorias"
