package tech.vsj.pagarme.repositories;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.vsj.pagarme.model.Transaction;

@Repository
public interface TransacitionRepository extends JpaRepository<Transaction, Long>{

  List<Transaction> findByDataDaTransacaoAfter(LocalDateTime dataDaTransacao);
  
  

}
