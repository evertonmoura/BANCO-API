package banco.controller;

import java.math.BigDecimal;

import banco.entity.ContaCorrente;
import banco.entity.Lancamento;
import banco.entity.TipoOperacao;
import banco.repository.ContaCorrenteRepository;
import banco.repository.LancamentoReporitory;

/**
 * Classe de controle para executar as operações
 * 
 * @author Everton
 *
 */
public class ContaCorrenteController {

	private ContaCorrenteRepository contaCorrenteRepository;
	private LancamentoReporitory lancamentoRepository;

	public ContaCorrenteController() {
		super();
		contaCorrenteRepository = new ContaCorrenteRepository();
		lancamentoRepository = new LancamentoReporitory();
	}

	/**
	 * Método para encapsular as operações de transferencia
	 * 
	 * @param origem
	 *            Conta
	 * @param destino
	 *            Conta
	 * @param valor
	 *            Valor
	 * @return Lançamento da transferencia
	 */
	public Lancamento transferenciaContaBancaria(ContaCorrente origem, ContaCorrente destino, BigDecimal valor) {
		contaCorrenteRepository.transferenciaContaBancaria(destino, valor);
		contaCorrenteRepository.atualizaSaldoPosTransferencia(origem.getNroConta(), valor);
		Lancamento lancamento = lancamentoRepository.atualizaLancamentoDiario(origem, TipoOperacao.TRANSFERENCIA, valor,
				destino);
		return lancamento;
	}
}
