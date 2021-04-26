package com.shopapp.shoesservice.dao;

import com.shopapp.shoesservice.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Long> {
    Optional<Shoe> findByMark(String mark);
    Optional<Shoe> findBySize(String mark);
    Optional<Shoe> findByProducer(String mark);

}
