package servico;

import modelo.Banco;

public class BacenStub extends Bacen {

	@Override
	public long cadastrarBanco(Banco banco) {
		return 1;
	}

}
