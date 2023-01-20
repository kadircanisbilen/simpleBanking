package com.eteration.simplebanking.repository;
import com.eteration.simplebanking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Account as a WHERE a.accountNumber =:accountNumber")
    Account getAccountByAccountNumber(String accountNumber);
}
