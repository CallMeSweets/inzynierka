package com.shopapp.clothesservice.dao;

import com.shopapp.clothesservice.model.Jacket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JacketRepository extends JpaRepository<Jacket, Long> {
    Optional<Jacket> findByMark(String mark);
    Optional<Jacket> findBySize(String mark);
    Optional<Jacket> findByProducer(String mark);

}
