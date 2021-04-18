package tech.vsj.pagarme.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.CreditCardNumber;
import tech.vsj.pagarme.form.resquests.MetodoPagamento;
import tech.vsj.pagarme.model.Transaction;

public class TransactionVO {

  @NotNull
  @Positive
  private BigDecimal valor;

  @NotBlank
  private String descricao;

  @NotNull
  private MetodoPagamento metodoPagamento;

  @CreditCardNumber(ignoreNonDigitCharacters = true)
  private String cartaoNumber;

  @NotBlank
  private String portadorName;

  @FutureOrPresent
  private LocalDate validadeCartao;

  @NotBlank
  private String cvv;

  private UUID uuidTransaction;
  private LocalDateTime dataDaTransacao;

  public TransactionVO(Transaction transaction) {
    this.valor = transaction.getValor();
    this.descricao = transaction.getDescricao();
    this.metodoPagamento = transaction.getMetodoPagamento();
    this.cartaoNumber = transaction.getCartaoNumber();
    this.portadorName = transaction.getPortadorName();
    this.validadeCartao = transaction.getValidadeCartao();
    this.cvv = transaction.getCvv();
    this.uuidTransaction = transaction.getUuidTransaction();
    this.dataDaTransacao = transaction.getDataDaTransacao();
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

  public UUID getUuidTransaction() {
    return uuidTransaction;
  }

  public LocalDateTime getDataDaTransacao() {
    return dataDaTransacao;
  }



}
