package com.PorfolioArgPrograma.Porfolio.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.PorfolioArgPrograma.Porfolio.Dto.PersonaDto;
import com.PorfolioArgPrograma.Porfolio.Entity.Persona;
import com.PorfolioArgPrograma.Porfolio.Service.PersonaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests de integración para PersonaController
 * @author Juan Pablo
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("PersonaController Integration Tests")
class PersonaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PersonaService personaService;

    private Persona persona;
    private PersonaDto personaDto;

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

        personaDto = new PersonaDto();
        personaDto.setNombre("Juan");
        personaDto.setApellido("Pérez");
        personaDto.setProfesion("Desarrollador");
        personaDto.setAcercaDe("Desarrollador Full Stack");
        personaDto.setUrlImagen("http://example.com/image.jpg");
        personaDto.setUrlImagenBanner("http://example.com/banner.jpg");
    }

    @Test
    @DisplayName("GET /persona/lista - Debe retornar lista paginada de personas")
    void testListPersonas() throws Exception {
        // Given
        List<Persona> personas = Arrays.asList(persona);
        Page<Persona> page = new PageImpl<>(personas, PageRequest.of(0, 10), personas.size());
        when(personaService.list(any())).thenReturn(page);

        // When & Then
        mockMvc.perform(get("/persona/lista")
                .param("page", "0")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(1)))
                .andExpect(jsonPath("$.content[0].nombre", is("Juan")))
                .andExpect(jsonPath("$.content[0].apellido", is("Pérez")));

        verify(personaService, times(1)).list(any());
    }

    @Test
    @DisplayName("GET /persona/detalle/{id} - Debe retornar persona por ID")
    void testGetPersonaById() throws Exception {
        // Given
        when(personaService.existsById(1L)).thenReturn(true);
        when(personaService.getOne(1L)).thenReturn(Optional.of(persona));

        // When & Then
        mockMvc.perform(get("/persona/detalle/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Juan")))
                .andExpect(jsonPath("$.apellido", is("Pérez")))
                .andExpect(jsonPath("$.profesion", is("Desarrollador")));

        verify(personaService, times(1)).existsById(1L);
        verify(personaService, times(1)).getOne(1L);
    }

    @Test
    @DisplayName("GET /persona/detalle/{id} - Debe retornar 404 cuando persona no existe")
    void testGetPersonaByIdNotFound() throws Exception {
        // Given
        when(personaService.existsById(999L)).thenReturn(false);

        // When & Then
        mockMvc.perform(get("/persona/detalle/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.mensaje", is("La persona no existe")));

        verify(personaService, times(1)).existsById(999L);
        verify(personaService, never()).getOne(anyLong());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    @DisplayName("POST /persona/crear - Debe crear persona con rol ADMIN")
    void testCrearPersona() throws Exception {
        // Given
        doNothing().when(personaService).save(any(Persona.class));

        // When & Then
        mockMvc.perform(post("/persona/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(personaDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje", is("Persona creada")));

        verify(personaService, times(1)).save(any(Persona.class));
    }

    @Test
    @DisplayName("POST /persona/crear - Debe retornar 403 sin autenticación")
    void testCrearPersonaSinAuth() throws Exception {
        // When & Then
        mockMvc.perform(post("/persona/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(personaDto)))
                .andExpect(status().isForbidden());

        verify(personaService, never()).save(any(Persona.class));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    @DisplayName("PUT /persona/actualizar/{id} - Debe actualizar persona")
    void testActualizarPersona() throws Exception {
        // Given
        when(personaService.existsById(1L)).thenReturn(true);
        when(personaService.getOne(1L)).thenReturn(Optional.of(persona));
        doNothing().when(personaService).save(any(Persona.class));

        // When & Then
        mockMvc.perform(put("/persona/actualizar/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(personaDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje", is("Datos actualizados")));

        verify(personaService, times(1)).existsById(1L);
        verify(personaService, times(1)).getOne(1L);
        verify(personaService, times(1)).save(any(Persona.class));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    @DisplayName("DELETE /persona/eliminar/{id} - Debe eliminar persona")
    void testEliminarPersona() throws Exception {
        // Given
        when(personaService.existsById(1L)).thenReturn(true);
        doNothing().when(personaService).delete(1L);

        // When & Then
        mockMvc.perform(delete("/persona/eliminar/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje", is("Persona eliminada")));

        verify(personaService, times(1)).existsById(1L);
        verify(personaService, times(1)).delete(1L);
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    @DisplayName("DELETE /persona/eliminar/{id} - Debe retornar 404 cuando persona no existe")
    void testEliminarPersonaNotFound() throws Exception {
        // Given
        when(personaService.existsById(999L)).thenReturn(false);

        // When & Then
        mockMvc.perform(delete("/persona/eliminar/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.mensaje", is("La persona no existe")));

        verify(personaService, times(1)).existsById(999L);
        verify(personaService, never()).delete(anyLong());
    }
}
