package com.example.check;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.check.model.Account;
import com.example.check.repository.AccountRepository;
import com.example.check.request_pojo.TransferBalanceRequest;
import com.example.check.serviceImpl.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class CreditDebitWalletTests {

	@InjectMocks
	private AccountServiceImpl service;
	
	@Mock
	private AccountRepository repository;
	
	
	@Test
    public void sendMoneyTest() {
        Account account1 = new Account(0L, "1001", new BigDecimal(50000));
        Account account2 = new Account(0L, "2002", new BigDecimal(2000));
        service.save(account1);
        service.save(account2);
        System.out.println(account1.getAccountNumber());
        System.out.println(account2.getAccountNumber());
        TransferBalanceRequest transferBalanceRequest =
                new TransferBalanceRequest(
                        account1.getAccountNumber(),
                        account2.getAccountNumber(),
                        new BigDecimal(3000)
                );
        service.sendMoney(transferBalanceRequest);
        assertThat(service.findByAccountNumber(account1.getAccountNumber())
                .getCurrentBalance())
                .isEqualTo(new BigDecimal(47000));
        assertThat(service.findByAccountNumber(account2.getAccountNumber())
                .getCurrentBalance())
                .isEqualTo(new BigDecimal(5000));

    }
}
