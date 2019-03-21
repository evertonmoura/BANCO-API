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
	 * Método para gerar um lançamento realizado no dia
	 * 
	 * @param origem
	 *            Conta corrente
	 * @param tipooperacao
	 *            Tipo da operação realizada
	 * @param valor
	 *            da operação
	 */
	public Lancamento atualizaLancamentoDiario(ContaCorrente origem, TipoOperacao tipooperacao, BigDecimal valor,
			ContaCorrente destino) {
		// TODO aqui realiza a opração de lançamento diario da operação de transferencia
		// entre as contas
		return new Lancamento();
	}

}
