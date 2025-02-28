package com.kata.kata.test;

import com.kata.kata.service.StudioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class StudioServiceTest {
    @Mock
    private com.kata.kata.repository.StudioRepository studioRepository;

    @InjectMocks
    private StudioService studioService;

    @Test
    void getAllStudios() {
        when(studioRepository.findAll()).thenReturn(List.of(
                new com.kata.kata.model.Studio(1, "Engineering"),
                new com.kata.kata.model.Studio(2, "Agile Delivery")
        ));

        List<com.kata.kata.dto.StudioDTO> result = studioService.getAllStudios();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).name()).isEqualTo("Engineering");
    }
}
