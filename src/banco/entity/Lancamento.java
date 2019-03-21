package banco.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Lancamento {

	private Long nroContaOrigem;
	private BigDecimal valorTransferencia;
	private Long nroContaDestino;
	private LocalDateTime dataHoraTransacao;

	public Lancamento() {
		super();
	}

	public Lancamento(Long nroContaOrigem, BigDecimal valorTransferencia, Long nroContaDestino,
			LocalDateTime dataHoraTransacao) {
		super();
		this.nroContaOrigem = nroContaOrigem;
		this.valorTransferencia = valorTransferencia;
		this.nroContaDestino = nroContaDestino;
		this.dataHoraTransacao = dataHoraTransacao;
	}

	public Long getNroContaOrigem() {
		return nroContaOrigem;
	}

	public void setNroContaOrigem(Long nroContaOrigem) {
		this.nroContaOrigem = nroContaOrigem;
	}

	public BigDecimal getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(BigDecimal valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public Long getNroContaDestino() {
		return nroContaDestino;
	}

	public void setNroContaDestino(Long nroContaDestino) {
		this.nroContaDestino = nroContaDestino;
	}

	public LocalDateTime getDataHoraTransacao() {
		return dataHoraTransacao;
	}

	public void setDataHoraTransacao(LocalDateTime dataHoraTransacao) {
		this.dataHoraTransacao = dataHoraTransacao;
	}

	@Override
	public String toString() {
		return "Lancamento [nroContaOrigem=" + nroContaOrigem + ", valorTransferencia=" + valorTransferencia
				+ ", nroContaDestino=" + nroContaDestino + ", dataHoraTransacao=" + dataHoraTransacao + "]";
	}

}
