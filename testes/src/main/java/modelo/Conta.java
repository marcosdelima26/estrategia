package modelo;

import exception.SaldoInsuficienteException;

public class Conta {

	private double saldo;
	private Cliente cliente;
	
	public Conta (Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getSaldo() {

		return this.saldo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public Conta depositar(double valor) {

		validarSeValorInformadoEhMenorOuIgualAZero(valor);
		this.saldo += valor;
		return this;

	}

	public Conta sacar(double valor) {
		
		validarSeValorInformadoEhMenorOuIgualAZero(valor);
		validarSeContaPossuiSaldoSuficiente(valor);
		this.saldo -= valor;
		
		return this;

	}

	private void validarSeContaPossuiSaldoSuficiente(double valor) {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("valor do saldo " + this.saldo);
		}
	}

	private void validarSeValorInformadoEhMenorOuIgualAZero(double valor) {
		if(valor<=0) {
			throw new IllegalArgumentException("Valor inválido " + valor + " foi informado");
		}
	}

	public void transferirPara(Conta contaDestino, double valor) {

		this.sacar(valor);
		contaDestino.depositar(valor);
		
	}

}
