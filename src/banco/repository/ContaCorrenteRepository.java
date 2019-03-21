package banco.repository;

import java.math.BigDecimal;

import banco.entity.ContaCorrente;

/**
 * Classe DAO responsavel pelo acesso a "banco"
 * 
 * @author Everton
 *
 */
public class ContaCorrenteRepository {
	
	/**
	 * Método para realizar a operação de transferencia
	 * 
	 * @param origem
	 *            Conta de origem da transferência
	 * @param destino
	 *            Conta de destino
	 * @param one
	 *            valor da transferencia
	 */
	public void transferenciaContaBancaria(ContaCorrente conta, BigDecimal valor) {
		this.atualizaSaldoTransferenciaRecebimento(conta.getNroConta(), valor);
	}

	public BigDecimal consultaSaldoContaCorrente(Long nroContaCorrente) {
		return BigDecimal.ONE;
	}

	/**
	 * Atualiza saldo da conta que está recebendo
	 * 
	 * @param nroContaCorrente
	 *            Conta
	 * @param valor
	 */
	private void atualizaSaldoTransferenciaRecebimento(Long nroContaCorrente, BigDecimal valor) {
		// TODO aqui atualiza o saldo da contade destino com o valor.
	}

	/**
	 * Atualiza saldo da conta que realizou a transferência
	 * 
	 * @param nroContaCorrente
	 * @param valor
	 */
	public void atualizaSaldoPosTransferencia(Long nroContaCorrente, BigDecimal valor) {
		// TODO aqui atualiza a conta de origem removendo do saldo valor transferido
	}

	public ContaCorrente findByNroConta(Long nroConta) {
		//MOCK teste
		if(nroConta.equals(1234L)) {
			return new ContaCorrente();
		}
		// TODO aqui valida se a conta existe na base
		return null;
	}
}
