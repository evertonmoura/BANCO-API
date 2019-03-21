package banco.test.app;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import banco.test.app.mock.ContaCorrenteMock;
import banco.validator.ContaCorrenteValidator;
import banco.validator.OperacaoValidator;
import junit.framework.TestCase;

public class ContaCorrenteOperacoesTest extends TestCase {

	private ContaCorrenteMock mock;
	private ContaCorrenteValidator contaCorrenteValidator;
	private OperacaoValidator operacaoValidator;

	@BeforeClass
	public void setUp() {
		mock = new ContaCorrenteMock();
		contaCorrenteValidator = new ContaCorrenteValidator();
		operacaoValidator = new OperacaoValidator();
	}

	@Test
	public void testValidaValorPositivoOperacao() {
		operacaoValidator.validaValorOperacao(BigDecimal.ONE);
		assertEquals(true, operacaoValidator.getListaErro().isEmpty());
	}

	@Test
	public void testValidaValorNegativoOperacao() {
		operacaoValidator.validaValorOperacao(BigDecimal.ZERO);
		assertEquals(true, !operacaoValidator.getListaErro().isEmpty());
	}

	@Test
	public void testContaCorrente() {
		contaCorrenteValidator.validar(mock.getContaTeste1());
		assertEquals(true, contaCorrenteValidator.getListaErro().isEmpty());
	}

	@Test
	public void testContaCorrenteErro() {
		contaCorrenteValidator.validar(mock.contaTeste2);
		assertEquals(true, !contaCorrenteValidator.getListaErro().isEmpty());
	}

	@Test
	public void testContaCorrenteErroSemSaldo() {
		contaCorrenteValidator.validarSaldoDisponivel(mock.contaTeste4, new BigDecimal(50000));
		assertEquals(true, !contaCorrenteValidator.getListaErro().isEmpty());
	}

	public ContaCorrenteMock getMock() {
		return mock;
	}

	public void setMock(ContaCorrenteMock mock) {
		this.mock = mock;
	}

	public ContaCorrenteValidator getContaCorrenteValidator() {
		return contaCorrenteValidator;
	}

	public void setContaCorrenteValidator(ContaCorrenteValidator contaCorrenteValidator) {
		this.contaCorrenteValidator = contaCorrenteValidator;
	}

	public OperacaoValidator getOperacaoValidator() {
		return operacaoValidator;
	}

	public void setOperacaoValidator(OperacaoValidator operacaoValidator) {
		this.operacaoValidator = operacaoValidator;
	}

}
