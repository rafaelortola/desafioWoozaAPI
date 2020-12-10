
Feature: Realizar um GET para busca de dados de pessoas

  @teste
  Scenario Outline: Validar dados do cliente com sucesso
    Given que o usuario informo um id <id>
    When submeto a requisição para o id <id>
    Then a API retorna status sucesso 200
    And deve retornar no campo eye_color o valor <eye_color>
    And deve retornar no campo skin_color o valor <skin_color>
    And deve retornar no campo name o valor <name>
    Examples:
    |id|eye_color|skin_color |name |
    |2 |yellow   |gold       |C-3PO|
    |3 |red      |white, blue|R2-D2|
