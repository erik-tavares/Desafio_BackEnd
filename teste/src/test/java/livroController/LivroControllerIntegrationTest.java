package livroController;

import org.example.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class LivroControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    public LivroControllerIntegrationTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void testCriarLivro() throws Exception {
        mockMvc.perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"titulo\":\"Teste do erik\", \"autores\":[\"Autor Desconhecido\"], \"generoLiterario\":\"Ficção\", \"editora\":\"Editora Teste\", \"dataPublicacao\":\"2022-01-01\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Teste do erik"));
    }

    @Test
    public void testAtualizarLivro() throws Exception {
        mockMvc.perform(put("/livros/9")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"titulo\":\"Teste de Integração Atualizado\", \"autores\":[\"Autor Desconhecido\"], \"generoLiterario\":\"Ficção Atualizada\", \"editora\":\"Editora Teste Atualizada\", \"dataPublicacao\":\"2022-01-02\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Teste de Integração Atualizado"));
    }

    @Test
    public void testListarLivros() throws Exception {
        mockMvc.perform(get("/livros?titulo=Integração&generoLiterario=Ficção"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Teste de Integração"))
                .andExpect(jsonPath("$[0].generoLiterario").value("Ficção"));
    }


    @Test
    public void testDeletarLivro() throws Exception {
        mockMvc.perform(delete("/livros/4"))
                .andExpect(status().isOk());
    }



}
