package tech.vsj.pagarme.model;

import static javax.persistence.EnumType.STRING;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.CreditCardNumber;
import tech.vsj.pagarme.form.resquests.MetodoPagamento;

@Entity
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_ID_SEQ")
  @SequenceGenerator(name = "TRANSACTION_ID_SEQ", sequenceName = "TRANSACTION_ID_SEQ",
      allocationSize = 1)
  private Long idTransaction;

  private UUID uuidTransaction;

  private @NotNull @Positive BigDecimal valor;

  private @NotBlank String descricao;

  @Enumerated(STRING)
  private @NotNull MetodoPagamento metodoPagamento;

  private @CreditCardNumber String cartaoNumber;

  private @NotBlank String portadorName;

  private @FutureOrPresent LocalDate validadeCartao;

  private @NotBlank String cvv;

  private LocalDateTime dataDaTransacao;

  public Transaction() {
    // Auto-generated constructor stub
  }

  public Transaction(@NotNull @Positive BigDecimal valor, @NotBlank String descricao,
      @NotNull MetodoPagamento metodoPagamento, @CreditCardNumber String cartaoNumber,
      @NotBlank String portadorName, @FutureOrPresent LocalDate validadeCartao,
      @NotBlank String cvv) {
    this.valor = valor;
    this.descricao = descricao;
    this.metodoPagamento = metodoPagamento;
    this.cartaoNumber = cartaoNumber;
    this.portadorName = portadorName;
    this.validadeCartao = validadeCartao;
    this.cvv = cvv;
    this.uuidTransaction = UUID.randomUUID();
    this.dataDaTransacao = LocalDateTime.now();
  }

  public Long getIdTransaction() {
    return idTransaction;
  }

  public UUID getUuidTransaction() {
    return uuidTransaction;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public String getDescricao() {
    return descricao;
  }

  public MetodoPagamento getMetodoPagamento() {
    return metodoPagamento;
  }

  public String getCartaoNumber() {
    return cartaoNumber;
  }

  public String getPortadorName() {
    return portadorName;
  }

  public LocalDate getValidadeCartao() {
    return validadeCartao;
  }

  public String getCvv() {
    return cvv;
  }

  public LocalDateTime getDataDaTransacao() {
    return dataDaTransacao;
  }

  @Override
  public String toString() {
    return String.format(
        "Transaction [idTransaction=%s, uuidTransaction=%s, valor=%s, descricao=%s, metodoPagamento=%s, cartaoNumber=%s, portadorName=%s, validadeCartao=%s, cvv=%s, dataDaTransacao=%s]",
        idTransaction, uuidTransaction, valor, descricao, metodoPagamento, cartaoNumber,
        portadorName, validadeCartao, cvv, dataDaTransacao);
  }



}
