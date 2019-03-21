package banco.validator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import banco.entity.ContaCorrente;
import banco.repository.ContaCorrenteRepository;

/**
 * Classe responsavel pelas validações gerais de Conta Corrente
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
	 * Método para realizar as validações nescessarias para transferência.
	 * 
	 * @param entidade
	 *            contendo a conta origem valor e conta destino
	 */
	public Boolean validar(ContaCorrente entidade) {
		if (Objects.isNull(entidade) || Objects.isNull(entidade.getNroConta())) {
			listaErro.add("Nro da conta é obrigatório.");
		}
		if (Objects.isNull(repository.findByNroConta(entidade.getNroConta()))) {
			listaErro.add("Conta não encontrada. : " + entidade.getNroConta());
		}
		return listaErro.isEmpty();
	}

	/**
	 * Valida se a conta tem saldo para operações de transferência
	 * 
	 * @return Verdadeiro se tiver salvo maior que o valor da transação, falso caso
	 *         contrario
	 */
	public Boolean validarSaldoDisponivel(ContaCorrente entidade, BigDecimal valorTransferencia) {
		if (Objects.nonNull(entidade)
				|| Objects.nonNull(entidade.getSaldo()) && entidade.getSaldo().compareTo(valorTransferencia) == -1) {
			listaErro.add("Conta não tem saldo suficiente para transferência.");
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
