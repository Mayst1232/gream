package bc1.gream.domain.product.dto.response;

import lombok.Builder;

@Builder
public record ProductPreviewResponseDto(
    Long id,
    String brand,
    String name,
    String imageUrl,
    String description,
    Long price
) {

}
