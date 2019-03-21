package banco.repository;

import java.math.BigDecimal;

import banco.entity.ContaCorrente;
import banco.entity.Lancamento;
import banco.entity.TipoOperacao;

/**
 * Classe DAO responsavel pelo acesso a "banco"
 * 
 * @author Everton
 *
 */
public class LancamentoReporitory {

	/**
	 * M�todo para gerar um lan�amento realizado no dia
	 * 
	 * @param origem
	 *            Conta corrente
	 * @param tipooperacao
	 *            Tipo da opera��o realizada
	 * @param valor
	 *            da opera��o
	 */
	public Lancamento atualizaLancamentoDiario(ContaCorrente origem, TipoOperacao tipooperacao, BigDecimal valor,
			ContaCorrente destino) {
		// TODO aqui realiza a opra��o de lan�amento diario da opera��o de transferencia
		// entre as contas
		return new Lancamento();
	}

}
