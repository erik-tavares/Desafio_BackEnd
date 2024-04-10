package org.example.model;

import java.math.BigDecimal;

public class CompraResponse {
    private Livraria livroComprado;
    private BigDecimal precoPago;

    public CompraResponse(Livraria livroComprado, BigDecimal precoPago) {
        this.livroComprado = livroComprado;
        this.precoPago = precoPago;
    }

    public BigDecimal getPrecoPago() {
        return precoPago;
    }

    public void setPrecoPago(BigDecimal precoPago) {
        this.precoPago = precoPago;
    }

    public Livraria getLivroComprado() {
        return livroComprado;
    }

    public void setLivroComprado(Livraria livroComprado) {
        this.livroComprado = livroComprado;
    }
// Getters e setters
}
