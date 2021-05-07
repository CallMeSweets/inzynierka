package com.shopapp.clothesservice.service;


import com.shopapp.clothesservice.dao.TshirtRepository;
import com.shopapp.clothesservice.exception.ElementNotFoundException;
import com.shopapp.clothesservice.model.Tshirt;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class TshirtService {

    private TshirtRepository tshirtRepository;

    public TshirtService(TshirtRepository tshirtRepository) {
        this.tshirtRepository = tshirtRepository;
    }

    public Tshirt createTshirt(Tshirt tshirt){
        return tshirtRepository.save(tshirt);
    }

    public Tshirt updateTshirt(Tshirt tshirt){
        return tshirtRepository.findById(tshirt.getId())
                    .map(tshirtFromDB -> {
                        tshirtFromDB.setMark(tshirt.getMark());
                        tshirtFromDB.setPrice(tshirt.getPrice());
                        tshirtFromDB.setProducer(tshirt.getProducer());
                        tshirtFromDB.setDescription(tshirt.getDescription());
                        return tshirtRepository.save(tshirtFromDB);
                    }).orElseGet(() -> tshirtRepository.save(tshirt));
    }

    public Tshirt getTshirtById(Long id){
        return tshirtRepository.findById(id).orElseThrow(() -> new ElementNotFoundException("Not found Tshirt with ID: " + id));
    }

    public Tshirt getTshirtByMark(String mark){
        return tshirtRepository.findByMark(mark).orElseThrow(() -> new ElementNotFoundException("Not found Tshirt by MARK: " + mark));
    }

    public Tshirt getTshirtBySize(String size){
        return tshirtRepository.findBySize(size).orElseThrow(() -> new ElementNotFoundException("Not found Tshirt by SIZE: " + size));
    }

    public Tshirt getTshirtByProducer(String producer){
        return tshirtRepository.findByProducer(producer).orElseThrow(() -> new ElementNotFoundException("Not found Tshirt by PRODUCER: " + producer));
    }

    public void deleteTshirt(Tshirt Tshirt){
        tshirtRepository.delete(Tshirt);
    }

    public void deleteTshirtById(Long id){
        tshirtRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initDB(){
        tshirtRepository.save(new Tshirt( 34, "markTest1", "sizeTest1", "producerTest1", "descriptionTest1"));
        tshirtRepository.save(new Tshirt(35, "markTest2", "sizeTest2", "producerTest2", "descriptionTest2"));
    }

}
