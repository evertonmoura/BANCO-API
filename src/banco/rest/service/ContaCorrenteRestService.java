package banco.rest.service;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import banco.controller.ContaCorrenteController;
import banco.entity.ContaCorrente;
import banco.entity.Lancamento;
import banco.validator.ContaCorrenteValidator;
import banco.validator.OperacaoValidator;

/**
 * 
 * @author Everton
 *
 */
@Path("/contacorrente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContaCorrenteRestService {

	private ContaCorrenteValidator validator;
	private OperacaoValidator operacaoValidator;
	private ContaCorrenteController contaCorrenteController;

	@PostConstruct
	private void init() {
		validator = new ContaCorrenteValidator();
		operacaoValidator = new OperacaoValidator();
		contaCorrenteController = new ContaCorrenteController();
	}

	/**
	 * Métdodo realiza a transferência entre contas.
	 * 
	 * @return sucesso no caso de transferência ok.
	 */
	@POST
	@Path("/contaorigem/{nroContaOrigem}/transferencia/valor/{valor}/contadestino/{nroContaDestino}")
	public Response transferenciaBancaria(@PathParam("nroContaOrigem") Long nroContaOrigem,
			@PathParam("valor") BigDecimal valor, @PathParam("nroContaDestino") Long nroContaDestino) {
		ContaCorrente origem = new ContaCorrente();
		origem.setNroConta(nroContaOrigem);
		ContaCorrente destino = new ContaCorrente();
		destino.setNroConta(nroContaDestino);
		Lancamento lancamento = new Lancamento();
		if (operacaoValidator.validaValorOperacao(valor) && validator.validar(origem) && validator.validar(destino)
				&& validator.validarSaldoDisponivel(origem, valor)) {
			lancamento = contaCorrenteController.transferenciaContaBancaria(origem, destino, valor);
		} else {
			// TODO gerar exceções
			return Response.status(500).entity(
					new String(operacaoValidator.getListaErro().toString() + validator.getListaErro().toString()))
					.build();
		}
		return Response.status(200).entity(lancamento).build();
	}
}
