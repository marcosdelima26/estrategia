package servico;

import modelo.Banco;

public class SistemaBancario {

	private Bacen bacen;

	public SistemaBancario(Bacen bacen) {
		super();
		this.bacen = bacen;
	}

	public long registrarBanco(Banco banco) {

		// outras regras de negocio

		return bacen.cadastrarBanco(banco);
	}
}
