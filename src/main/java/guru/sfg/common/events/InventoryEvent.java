package guru.sfg.common.events;

import guru.sfg.beer.inventory.service.web.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InventoryEvent extends BeerEvent {

    private static final long serialVersionUID = -4943933801359231762L;

    public InventoryEvent(BeerDto beerDto) {
	super(beerDto);
    }

}
