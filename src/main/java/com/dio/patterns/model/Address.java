package com.dio.patterns.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 */
@Entity
public class Address {

    @Id
    @JsonAlias("cep")
    private String zipcode;
    @JsonAlias("logradouro")
    private String street;
    @JsonAlias("complemento")
    private String complement;
    @JsonAlias("bairro")
    private String district;
    @JsonAlias("localidade")
    private String location;
    @JsonAlias("uf")
    private String state;
    @JsonAlias("ibge")
    private String ibge;
    @JsonAlias("gia")
    private String gia;
    @JsonAlias("ddd")
    private String ddd;
    @JsonAlias("siafi")
    private String siafi;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

}
