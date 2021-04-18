package tech.vsj.pagarme.form.resquests;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.CreditCardNumber;
import com.fasterxml.jackson.annotation.JsonCreator;
import tech.vsj.pagarme.model.Transaction;

public class TransactionRequestForm {

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

  @JsonCreator
  public TransactionRequestForm(@NotNull @Positive BigDecimal valor, @NotBlank String descricao,
      @NotNull MetodoPagamento metodoPagamento, @CreditCardNumber String cartaoNumber,
      @NotBlank String portadorName, @FutureOrPresent LocalDate validadeCartao,
      @NotBlank String cvv) {
    super();
    this.valor = valor;
    this.descricao = descricao;
    this.metodoPagamento = metodoPagamento;
    this.cartaoNumber = cartaoNumber;
    this.portadorName = portadorName;
    this.validadeCartao = validadeCartao;
    this.cvv = cvv;
  }

  public final BigDecimal getValor() {
    return valor;
  }

  public final String getDescricao() {
    return descricao;
  }

  public final MetodoPagamento getMetodoPagamento() {
    return metodoPagamento;
  }

  public final String getCartaoNumber() {
    return cartaoNumber;
  }

  public final String getPortadorName() {
    return portadorName;
  }

  public final LocalDate getValidadeCartao() {
    return validadeCartao;
  }

  public final String getCvv() {
    return cvv;
  }

  @Override
  public String toString() {
    return String.format(
        "TransactionRequestForm [valor=%s, descricao=%s, metodoPagamento=%s, cartaoNumber=%s, portadorName=%s, validaCartao=%s, cvv=%s]",
        valor, descricao, metodoPagamento, cartaoNumber, portadorName, validadeCartao, cvv);
  }

  public Transaction mapToModel() {

    return new Transaction(valor, descricao, metodoPagamento, cartaoNumber, portadorName,
        validadeCartao, cvv);
  }



}
