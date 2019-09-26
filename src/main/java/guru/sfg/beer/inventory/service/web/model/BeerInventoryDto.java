package guru.sfg.beer.inventory.service.web.model;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jt on 2019-05-31.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerInventoryDto {
    private Long id;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
    private Integer quantityOnHand;
    private String upc;
}
