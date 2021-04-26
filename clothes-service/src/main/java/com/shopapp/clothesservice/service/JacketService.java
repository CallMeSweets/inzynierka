package com.shopapp.clothesservice.service;

import com.shopapp.clothesservice.dao.JacketRepository;
import com.shopapp.clothesservice.exception.ElementNotFoundException;
import com.shopapp.clothesservice.model.Jacket;
import org.springframework.stereotype.Service;

@Service
public class JacketService {

    private JacketRepository jacketRepository;

    public JacketService(JacketRepository jacketRepository) {
        this.jacketRepository = jacketRepository;
    }

    public Jacket createJacket(Jacket jacket){
        return jacketRepository.save(jacket);
    }

    public Jacket updateJacket(Jacket jacket){
        return jacketRepository.findById(jacket.getId())
                    .map(jacketFromDB -> {
                        jacketFromDB.setMark(jacket.getMark());
                        jacketFromDB.setPrice(jacket.getPrice());
                        jacketFromDB.setProducer(jacket.getProducer());
                        jacketFromDB.setDescription(jacket.getDescription());
                        return jacketRepository.save(jacketFromDB);
                    }).orElseGet(() -> jacketRepository.save(jacket));
    }

    public Jacket getJacketById(Long id){
        return jacketRepository.findById(id).orElseThrow(() -> new ElementNotFoundException("Not found Jacket with ID: " + id));
    }

    public Jacket getJacketByMark(String mark){
        return jacketRepository.findByMark(mark).orElseThrow(() -> new ElementNotFoundException("Not found Jacket by MARK: " + mark));
    }

    public Jacket getJacketBySize(String size){
        return jacketRepository.findBySize(size).orElseThrow(() -> new ElementNotFoundException("Not found Jacket by SIZE: " + size));
    }

    public Jacket getJacketByProducer(String producer){
        return jacketRepository.findByProducer(producer).orElseThrow(() -> new ElementNotFoundException("Not found Jacket by PRODUCER: " + producer));
    }

    public void deleteJacket(Jacket jacket){
        jacketRepository.delete(jacket);
    }

    public void deleteJacketById(Long id){
        jacketRepository.deleteById(id);
    }

}
