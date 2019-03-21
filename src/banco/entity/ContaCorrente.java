package banco.entity;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContaCorrente {

	private String nomeUsuarioConta;
	private Long nroConta;
	private BigDecimal saldo;

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String nomeUsuarioConta, Long nroConta, BigDecimal saldo) {
		super();
		this.nomeUsuarioConta = nomeUsuarioConta;
		this.nroConta = nroConta;
		this.saldo = saldo;
	}

	public String getNomeUsuarioConta() {
		return nomeUsuarioConta;
	}

	public void setNomeUsuarioConta(String nomeUsuarioConta) {
		this.nomeUsuarioConta = nomeUsuarioConta;
	}

	public Long getNroConta() {
		return nroConta;
	}

	public void setNroConta(Long nroConta) {
		this.nroConta = nroConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nroConta == null) ? 0 : nroConta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCorrente other = (ContaCorrente) obj;
		if (nroConta == null) {
			if (other.nroConta != null)
				return false;
		} else if (!nroConta.equals(other.nroConta))
			return false;
		return true;
	}

}
