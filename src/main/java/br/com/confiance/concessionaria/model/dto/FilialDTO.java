package br.com.confiance.concessionaria.model.dto;

import br.com.confiance.concessionaria.model.entity.Cidade;
import br.com.confiance.concessionaria.model.entity.Filial;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class FilialDTO {
    private int codFilial;
    private long cnpj;
    private String razaoSocial;
    private long cep;
    private String logradouro;
    private String bairro;
    private int numero;
    private Cidade codCidade;
    private String complemento;

    public FilialDTO(){};

    public FilialDTO(Filial filial){
        this.codFilial = filial.getcodFilial();
        this.cnpj = filial.getCnpj();
        this.razaoSocial = filial.getRazaoSocial();
        this.cep = filial.getCep();
        this.logradouro = filial.getLogradouro();
        this.bairro = filial.getBairro();
        this.numero = filial.getNumero();
        this.codCidade = filial.getCodCidade();
        this.complemento = filial.getComplemento();

    }

    public int getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cidade getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(Cidade codCidade) {
        this.codCidade = codCidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
