package br.com.confiance.concessionaria.model.dto;

import br.com.confiance.concessionaria.model.entity.Marca;

public class MarcaDTO {
    private int codMarca;
    private String descricao;

    public MarcaDTO(){};

    public MarcaDTO(Marca marca) {
        this.codMarca = marca.getCodMarca();
        this.descricao = marca.getMarca();
    }

    public int getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(int codMarca) {
        this.codMarca = codMarca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
