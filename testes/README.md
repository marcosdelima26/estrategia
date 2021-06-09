# TDD

* Apresentando o Junit 5 - https://junit.org/junit5/docs/current/user-guide/index.pdf
	* JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage
	* https://stackoverflow.com/questions/48448331/difference-between-junit-jupiter-api-and-junit-jupiter-engine/55084036#55084036

## Conta
* Conta e testes em depositar e sacar
* só sacar se tiver saldo
* fazer a transferencia com bug
* nao deve depositar valor negativo: **assertThrows**
```java
Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
assertEquals("/ by zero", exception.getMessage());
```



## Banco
* cadastrar conta
* listar contas negativas
* enviar email para contas negativas
	* email dentro
	* email factory
	* email com InjectMocks
* integracao com a receita federal
	
## Cliente

* validacao de CPF junto a receita



## anotações
@BeforeEach
@ExtendWith(MockitoExtension.class)
@InjectMocks
@DisplayName
@ParemeterizedTest
	* @ParameterizedTest
	* @ValueSource(doubles = {100,30, 40, 0})
@RepeatedTest
@Disable
@TestMethodOrder

https://devqa.io/junit-5-annotations/

```java
  @Test
  void groupedAssertions() {
	  // In a grouped assertion all assertions are executed, and all
	  // failures will be reported together.
	  assertAll("person",
		  () -> assertEquals("Jane", person.getFirstName()),
		  () -> assertEquals("Doe", person.getLastName())
		 );
  }

```

## sugestões

Pensar se entro em Rules
