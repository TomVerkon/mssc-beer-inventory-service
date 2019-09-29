package guru.sfg.beer.inventory.service.services;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import guru.sfg.beer.inventory.service.config.JMSConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import guru.sfg.beer.inventory.service.web.model.BeerInventoryDto;
import guru.sfg.common.events.InventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class NewInventoryListener {
    
    private final BeerInventoryRepository repository;
    
    @JmsListener(destination = JMSConfig.NEW_INVENTORY_QUEUE)
    public void listen(InventoryEvent event) {
	
	log.debug("Got inventory: " + event.toString());
	
	repository.save(BeerInventory.builder()
		.id(event.getBeerDto().getId())
		.upc(event.getBeerDto().getUpc())
		.quantityOnHand(event.getBeerDto().getQuantityOnHand())
		.build());
	
    }

}
