package com.PorfolioArgPrograma.Porfolio.Service;

import com.PorfolioArgPrograma.Porfolio.Entity.Persona;
import com.PorfolioArgPrograma.Porfolio.Repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Tests unitarios para PersonaService
 * @author Juan Pablo
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("PersonaService Tests")
class PersonaServiceTest {

    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private PersonaService personaService;

    private Persona persona;

    @BeforeEach
    void setUp() {
        persona = new Persona();
        persona.setId(1L);
        persona.setNombre("Juan");
        persona.setApellido("Pérez");
        persona.setProfesion("Desarrollador");
        persona.setAcercaDe("Desarrollador Full Stack");
        persona.setUrlImagen("http://example.com/image.jpg");
        persona.setUrlImagenBanner("http://example.com/banner.jpg");
    }

    @Test
    @DisplayName("Debe listar todas las personas con paginación")
    void testListWithPagination() {
        // Given
        Pageable pageable = PageRequest.of(0, 10);
        List<Persona> personas = Arrays.asList(persona);
        Page<Persona> page = new PageImpl<>(personas, pageable, personas.size());
        
        when(personaRepository.findAll(pageable)).thenReturn(page);

        // When
        Page<Persona> result = personaService.list(pageable);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getContent()).hasSize(1);
        assertThat(result.getContent().get(0).getNombre()).isEqualTo("Juan");
        verify(personaRepository, times(1)).findAll(pageable);
    }

    @Test
    @DisplayName("Debe listar todas las personas sin paginación")
    void testListAll() {
        // Given
        List<Persona> personas = Arrays.asList(persona);
        when(personaRepository.findAll()).thenReturn(personas);

        // When
        List<Persona> result = personaService.listAll();

        // Then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getNombre()).isEqualTo("Juan");
        verify(personaRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Debe obtener una persona por ID")
    void testGetOne() {
        // Given
        when(personaRepository.findById(1L)).thenReturn(Optional.of(persona));

        // When
        Optional<Persona> result = personaService.getOne(1L);

        // Then
        assertThat(result).isPresent();
        assertThat(result.get().getNombre()).isEqualTo("Juan");
        assertThat(result.get().getApellido()).isEqualTo("Pérez");
        verify(personaRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Debe retornar Optional vacío cuando la persona no existe")
    void testGetOneNotFound() {
        // Given
        when(personaRepository.findById(anyLong())).thenReturn(Optional.empty());

        // When
        Optional<Persona> result = personaService.getOne(999L);

        // Then
        assertThat(result).isEmpty();
        verify(personaRepository, times(1)).findById(999L);
    }

    @Test
    @DisplayName("Debe guardar una persona")
    void testSave() {
        // Given
        when(personaRepository.save(any(Persona.class))).thenReturn(persona);

        // When
        personaService.save(persona);

        // Then
        verify(personaRepository, times(1)).save(persona);
    }

    @Test
    @DisplayName("Debe eliminar una persona por ID")
    void testDelete() {
        // Given
        doNothing().when(personaRepository).deleteById(1L);

        // When
        personaService.delete(1L);

        // Then
        verify(personaRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Debe verificar si existe una persona por ID")
    void testExistsById() {
        // Given
        when(personaRepository.existsById(1L)).thenReturn(true);

        // When
        boolean result = personaService.existsById(1L);

        // Then
        assertThat(result).isTrue();
        verify(personaRepository, times(1)).existsById(1L);
    }

    @Test
    @DisplayName("Debe retornar false cuando la persona no existe")
    void testExistsByIdNotFound() {
        // Given
        when(personaRepository.existsById(999L)).thenReturn(false);

        // When
        boolean result = personaService.existsById(999L);

        // Then
        assertThat(result).isFalse();
        verify(personaRepository, times(1)).existsById(999L);
    }
}
