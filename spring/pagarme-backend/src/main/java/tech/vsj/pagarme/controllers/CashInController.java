package tech.vsj.pagarme.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.vsj.pagarme.domain.TransactionVO;
import tech.vsj.pagarme.form.resquests.TransactionRequestForm;
import tech.vsj.pagarme.model.Transaction;
import tech.vsj.pagarme.repositories.TransacitionRepository;

@RestController
@RequestMapping("/cash-in")
public class CashInController {


  private static final Logger LOG = LoggerFactory.getLogger(CashInController.class);

  @Autowired
  private TransacitionRepository repository;

  @PostMapping
  @Transactional
  public ResponseEntity<TransactionVO> processaTransacao(
      @Valid @RequestBody TransactionRequestForm transactionRequest) {
    Transaction transaction = transactionRequest.mapToModel();
    repository.save(transaction);
    return ResponseEntity.ok(new TransactionVO(transaction));
  }


  @GetMapping()
  public ResponseEntity<List<TransactionVO>> getListaPorData(
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate dataDaTransacao) {

    LocalDateTime data = dataDaTransacao.atStartOfDay();
    List<TransactionVO> list = repository.findByDataDaTransacaoAfter(data).stream().map(TransactionVO::new).collect(Collectors.toList());
    

    return ResponseEntity.ok(list);
  }



}
