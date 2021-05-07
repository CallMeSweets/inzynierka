package com.shopapp.shoesservice.service;

import com.shopapp.shoesservice.dao.ShoeRepository;
import com.shopapp.shoesservice.exception.ElementNotFoundException;
import com.shopapp.shoesservice.model.Shoe;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ShoeService {

    private ShoeRepository shoeRepository;

    public ShoeService(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    public Shoe createShoe(Shoe shoe){
        return shoeRepository.save(shoe);
    }

    public Shoe updateShoe(Shoe shoe){
        return shoeRepository.findById(shoe.getId())
                    .map(shoeFromDB -> {
                        shoeFromDB.setMark(shoe.getMark());
                        shoeFromDB.setPrice(shoe.getPrice());
                        shoeFromDB.setProducer(shoe.getProducer());
                        shoeFromDB.setDescription(shoe.getDescription());
                        return shoeRepository.save(shoeFromDB);
                    }).orElseGet(() -> shoeRepository.save(shoe));
    }

    public Shoe getShoeById(Long id){
        return shoeRepository.findById(id).orElseThrow(() -> new ElementNotFoundException("Not found SHOE with ID: " + id));
    }

    public Shoe getShoeByMark(String mark){
        return shoeRepository.findByMark(mark).orElseThrow(() -> new ElementNotFoundException("Not found SHOE by MARK: " + mark));
    }

    public Shoe getShoeBySize(String size){
        return shoeRepository.findBySize(size).orElseThrow(() -> new ElementNotFoundException("Not found SHOE by SIZE: " + size));
    }

    public Shoe getShoeByProducer(String producer){
        return shoeRepository.findByProducer(producer).orElseThrow(() -> new ElementNotFoundException("Not found SHOE by PRODUCER: " + producer));
    }

    public void deleteShoe(Shoe shoe){
        shoeRepository.delete(shoe);
    }

    public void deleteShoeById(Long id){
        shoeRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initDB(){
        shoeRepository.save(new Shoe(10, "markTest1","sizeTest1", "producerTest1", "descriptionTest1"));
        shoeRepository.save(new Shoe(11, "markTest2", "sizeTest2", "producerTest2", "descriptionTest2"));
    }

}
