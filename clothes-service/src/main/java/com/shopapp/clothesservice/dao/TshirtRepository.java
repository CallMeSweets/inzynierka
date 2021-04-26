package com.shopapp.clothesservice.dao;

import com.shopapp.clothesservice.model.Tshirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TshirtRepository extends JpaRepository<Tshirt, Long> {
    Optional<Tshirt> findByMark(String mark);
    Optional<Tshirt> findBySize(String mark);
    Optional<Tshirt> findByProducer(String mark);

}
