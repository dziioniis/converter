package com.chat.demo.repository;

import com.chat.demo.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange,Long> {
    @Query("SELECT name FROM Currency")
    Iterable<String> findAllNames();

    @Modifying
    @Query("update Currency u set u.value=:value where u.name=:name")
    void updateValueOfCurrency(@Param("value")Double value,String name);
}
