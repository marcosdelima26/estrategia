package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.CNPJInvalidoException;
import exception.CPFInvalidoException;

class ClienteTest {

	private static final String CNPJ_VALIDO = "46536460000130";
	private static final String CPF_VALIDO_2 = "92468831012";
	private static final String CPF_VALIDO = "01117588157";

	@Test
	void deve_criar_cliente_quando_cpf_for_valido() {

		Cliente cliente = criarClienteComCPF(CPF_VALIDO);
		assertEquals(CPF_VALIDO, cliente.getCpf());

		cliente = criarClienteComCPF(CPF_VALIDO_2);
		assertEquals(CPF_VALIDO_2, cliente.getCpf());

	}

	@Test
	void nao_deve_criar_cliente_quando_cpf_for_invalido() {

		assertThrows(CPFInvalidoException.class, () -> criarClienteComCPF(""));

		assertThrows(CPFInvalidoException.class, () -> criarClienteComCPF(null));

		assertThrows(CPFInvalidoException.class, () -> criarClienteComCPF("123123321"));

		assertThrows(CPFInvalidoException.class, () -> criarClienteComCPF("01117588158"));

	}
	
	@Test
	void deve_criar_cliente_quando_cnpj_for_valido() {

		Cliente cliente = criarClienteComCNPJ(CNPJ_VALIDO);
		assertEquals(CNPJ_VALIDO, cliente.getCnpj());

	}
	
	@Test
	void nao_deve_criar_cliente_quando_cnpj_for_invalido() {

		assertThrows(CNPJInvalidoException.class, () -> criarClienteComCNPJ(""));
		assertThrows(CNPJInvalidoException.class, () -> criarClienteComCNPJ(null));
		assertThrows(CNPJInvalidoException.class, () -> criarClienteComCNPJ("123123321"));
		assertThrows(CNPJInvalidoException.class, () -> criarClienteComCNPJ("01117588158"));

	}

	private Cliente criarClienteComCPF(String cpf) {
		return Cliente.getClienteComCPF(cpf);
	}

	private Cliente criarClienteComCNPJ(String cnpj) {
		return Cliente.getClienteComCNPJ(cnpj);
	}
}
