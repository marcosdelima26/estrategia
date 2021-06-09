package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import exception.CPFNegativadoException;
import exception.SistemaIndisponivelException;
import servico.Email;
import servico.ReceitaFederal;
import servico.ReceitaFederalTosca;

public class Banco {

	private List<Conta> contas = new ArrayList<>();

	private ReceitaFederal receitaFederal;
	private Email email;

	

	//default constructor
	public Banco() {
		super();
	}

	public Banco(ReceitaFederal receitaFederal, Email email) {
		this.receitaFederal = receitaFederal;
		this.email = email;
	}

	public void adicionarConta(Conta conta) {

		try {
			if (verificarSeCPFEstaNegativado(conta.getCliente().getCpf())) {

				throw new CPFNegativadoException();
			}
			contas.add(conta);
		} catch (IllegalStateException e) {
			throw new SistemaIndisponivelException(e);
		}

	}

	boolean verificarSeCPFEstaNegativado(String cpf) {
		return ReceitaFederalTosca.isCPFNegativado(cpf);
	}

	public int getTotalDeContas() {
		return contas.size();
	}

	public Optional<Conta> getContaDoCliente(String cpfValido) {
		return contas.stream().filter(c -> c.getCliente().getCpf().equals(cpfValido)).findFirst();
	}

	public List<Conta> listarContasAltaRenda() {
		return filtrarContas(c -> c.getSaldo() >= 10000);
	}

	public List<Conta> listarContasBaixaRenda() {
		return filtrarContas(c -> c.getSaldo() <= 1000);
	}

	private List<Conta> filtrarContas(Predicate<Conta> filtro) {
		return contas.stream().filter(filtro).collect(Collectors.toList());
	}

	public void oferecerTitulosDeCapitalizacao() {

		List<Conta> contasAltaRenda = listarContasAltaRenda();

		StringBuilder a = new StringBuilder();
		
		for (int i = 0; i < 300; i++) {
			a.append("mensagenova" + i);
		}

		contasAltaRenda.forEach(c -> {
			email.enviar("compre titulo " + c.getCliente().getCpf());
		});

	}

}
