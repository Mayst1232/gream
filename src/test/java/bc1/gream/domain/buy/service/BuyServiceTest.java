package bc1.gream.domain.buy.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import bc1.gream.domain.buy.dto.request.BuyBidRequestDto;
import bc1.gream.domain.buy.dto.response.BuyBidResponseDto;
import bc1.gream.domain.buy.entity.Buy;
import bc1.gream.domain.buy.repository.BuyRepository;
import bc1.gream.domain.product.repository.ProductRepository;
import bc1.gream.test.BuyTest;
import bc1.gream.test.ProductTest;
import bc1.gream.test.UserTest;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BuyServiceTest implements UserTest, ProductTest, BuyTest {

    @Mock
    BuyRepository buyRepository;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    BuyService buyService;

    @Test
    void buyBidProductTest() {

        // given
        BuyBidRequestDto requestDto = BuyBidRequestDto.builder()
            .price(TEST_BUY_PRICE)
            .build();

        given(productRepository.findById(TEST_PRODUCT_ID)).willReturn(Optional.of(TEST_PRODUCT));
        given(buyRepository.save(any(Buy.class))).willReturn(TEST_BUY);

        // when
        BuyBidResponseDto responseDto = buyService.buyBidProduct(TEST_USER, requestDto, TEST_PRODUCT_ID);

        // then
        assertThat(responseDto.price()).isEqualTo(TEST_BUY_PRICE);
    }
}