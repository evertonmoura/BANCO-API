package banco.test.app.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import banco.entity.ContaCorrente;

/**
 * Classe de mock para realizar os testes
 * 
 * @author Everton
 *
 */
public class ContaCorrenteMock {

	public ContaCorrente contaTeste1;
	public ContaCorrente contaTeste2;
	public ContaCorrente contaTeste3;
	public ContaCorrente contaTeste4;
	private List<ContaCorrente> listaContas;

	public ContaCorrenteMock() {
		super();
		listaContas = new ArrayList<>();
		initConta1();
		initConta2();
		initConta3();
		initConta4();
	}

	public ContaCorrenteMock(ContaCorrente contaTeste1, ContaCorrente contaTeste2, ContaCorrente contaTeste3,
			ContaCorrente contaTeste4) {
		super();
		this.contaTeste1 = contaTeste1;
		this.contaTeste2 = contaTeste2;
		this.contaTeste3 = contaTeste3;
		this.contaTeste4 = contaTeste4;
	}

	public ContaCorrente getContaTeste1() {
		return contaTeste1;
	}

	public void setContaTeste1(ContaCorrente contaTeste1) {
		this.contaTeste1 = contaTeste1;
	}

	public ContaCorrente getContaTeste2() {
		return contaTeste2;
	}

	public void setContaTeste2(ContaCorrente contaTeste2) {
		this.contaTeste2 = contaTeste2;
	}

	public ContaCorrente getContaTeste3() {
		return contaTeste3;
	}

	public void setContaTeste3(ContaCorrente contaTeste3) {
		this.contaTeste3 = contaTeste3;
	}

	public ContaCorrente getContaTeste4() {
		return contaTeste4;
	}

	public void setContaTeste4(ContaCorrente contaTeste4) {
		this.contaTeste4 = contaTeste4;
	}

	private void initConta1() {
		contaTeste1 = new ContaCorrente();
		contaTeste1.setNomeUsuarioConta("Conta Teste 1");
		contaTeste1.setNroConta(1234L);
		contaTeste1.setSaldo(new BigDecimal(500));
		listaContas.add(contaTeste1);
	}

	private void initConta2() {
		contaTeste2 = new ContaCorrente();
		contaTeste2.setNomeUsuarioConta("Conta Teste 2");
		contaTeste2.setNroConta(5678L);
		contaTeste2.setSaldo(new BigDecimal(300));
		listaContas.add(contaTeste2);

	}

	private void initConta3() {
		contaTeste3 = new ContaCorrente();
		contaTeste3.setNomeUsuarioConta("Conta Teste 3");
		contaTeste3.setNroConta(4321L);
		contaTeste3.setSaldo(new BigDecimal(100));
		listaContas.add(contaTeste3);

	}

	private void initConta4() {
		contaTeste4 = new ContaCorrente();
		contaTeste4.setNomeUsuarioConta("Conta Teste 4");
		contaTeste4.setNroConta(8765L);
		contaTeste4.setSaldo(new BigDecimal(50));
		listaContas.add(contaTeste4);

	}

	public ContaCorrente getContaCorrente(Long nroConta) {
		return listaContas.stream().filter(conta -> conta.getNroConta().equals(nroConta)).findFirst().get();
	}
}
