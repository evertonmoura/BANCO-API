package banco.validator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import banco.entity.ContaCorrente;
import banco.repository.ContaCorrenteRepository;

/**
 * Classe responsavel pelas valida��es gerais de Conta Corrente
 * 
 * @author Everton
 *
 */
public class ContaCorrenteValidator {

	private Boolean erros;
	private List<String> listaErro = new ArrayList<>();
	ContaCorrenteRepository repository;

	public ContaCorrenteValidator() {
		super();
		repository = new ContaCorrenteRepository();
	}

	public ContaCorrenteValidator(Boolean erros) {
		super();
		this.erros = erros;
	}

	/**
	 * M�todo para realizar as valida��es nescessarias para transfer�ncia.
	 * 
	 * @param entidade
	 *            contendo a conta origem valor e conta destino
	 */
	public Boolean validar(ContaCorrente entidade) {
		if (Objects.isNull(entidade) || Objects.isNull(entidade.getNroConta())) {
			listaErro.add("Nro da conta � obrigat�rio.");
		}
		if (Objects.isNull(repository.findByNroConta(entidade.getNroConta()))) {
			listaErro.add("Conta n�o encontrada. : " + entidade.getNroConta());
		}
		return listaErro.isEmpty();
	}

	/**
	 * Valida se a conta tem saldo para opera��es de transfer�ncia
	 * 
	 * @return Verdadeiro se tiver salvo maior que o valor da transa��o, falso caso
	 *         contrario
	 */
	public Boolean validarSaldoDisponivel(ContaCorrente entidade, BigDecimal valorTransferencia) {
		if (Objects.nonNull(entidade)
				|| Objects.nonNull(entidade.getSaldo()) && entidade.getSaldo().compareTo(valorTransferencia) == -1) {
			listaErro.add("Conta n�o tem saldo suficiente para transfer�ncia.");
		}
		return listaErro.isEmpty();
	}

	public Boolean getErros() {
		return erros;
	}

	public void setErros(Boolean erros) {
		this.erros = erros;
	}

	public List<String> getListaErro() {
		return listaErro;
	}

	public void setListaErro(List<String> listaErro) {
		this.listaErro = listaErro;
	}
}
