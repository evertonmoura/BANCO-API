package banco.validator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe responsavel pela validação geral nas operações
 * 
 * @author Everton
 *
 */
public class OperacaoValidator {

	private List<String> listaErro = new ArrayList<>();

	public OperacaoValidator() {
		super();
	}

	public OperacaoValidator(List<String> listaErro) {
		super();
		this.listaErro = listaErro;
	}

	/**
	 * Valida o valor passado em qualquer das transações
	 * 
	 * @return True caso != null e/ou > 0
	 */
	public Boolean validaValorOperacao(BigDecimal valor) {
		listaErro.clear();
		if (Objects.isNull(valor)) {
			listaErro.add("Valor é obrigatorio.");
		} else if (Objects.nonNull(valor) && valor.compareTo(BigDecimal.ONE) == -1) {
			listaErro.add("Valor deve ser maior que zero.");
		}
		return listaErro.isEmpty();
	}

	public List<String> getListaErro() {
		return listaErro;
	}

	public void setListaErro(List<String> listaErro) {
		this.listaErro = listaErro;
	}

}
