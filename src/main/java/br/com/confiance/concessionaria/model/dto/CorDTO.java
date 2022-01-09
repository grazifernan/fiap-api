package br.com.confiance.concessionaria.model.dto;

import br.com.confiance.concessionaria.model.entity.Cor;

public class CorDTO {
    private int codCor;
    private String cor;

    public CorDTO(){};

    public CorDTO(Cor cor){
        this.codCor = cor.getCodCor();
        this.cor = cor.getCor();
    }

    public int getCodCor() {
        return codCor;
    }

    public void setCodCor(int codCor) {
        this.codCor = codCor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
