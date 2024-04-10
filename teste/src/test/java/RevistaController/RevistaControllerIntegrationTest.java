package RevistaController;

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
public class RevistaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCriarRevista() throws Exception {
        mockMvc.perform(post("/revistas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Revista Teste\", \"editora\":\"Editora Teste\", \"numeroEdicao\":1, \"dataPublicacao\":\"2022-01-01\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Revista Teste"));
    }

    @Test
    public void testAtualizarRevista() throws Exception {
        mockMvc.perform(put("/revistas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Revista Atualizada\", \"editora\":\"Editora Atualizada\", \"numeroEdicao\":2, \"dataPublicacao\":\"2022-01-02\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Revista Atualizada"));
    }

    @Test
    public void testListarRevistas() throws Exception {
        mockMvc.perform(get("/revistas"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletarRevista() throws Exception {
        mockMvc.perform(delete("/revistas/1"))
                .andExpect(status().isOk());
    }
}
