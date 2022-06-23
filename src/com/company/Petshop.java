package com.company;

abstract class Petshop{
    double distancia_km;
    double preco_cao_grande;
    double preco_cao_pequeno;
    double PrecoTotal;
    String nome;

    public double getDistancia_km() {
        return distancia_km;
    }

    public Petshop(double distancia_km, double preco_cao_grande, double preco_cao_pequeno, String nome) {
        this.distancia_km = distancia_km;
        this.preco_cao_grande = preco_cao_grande;
        this.preco_cao_pequeno = preco_cao_pequeno;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco_cao_grande() {
        return preco_cao_grande;
    }

    public double getPreco_cao_pequeno() {
        return preco_cao_pequeno;
    }

    public double getPrecoTotal() {
        return PrecoTotal;
    }

    public void setPrecoTotal(int quantCaesGrandes, int quantCaesPequenos) {
        PrecoTotal = (getPreco_cao_grande() * quantCaesGrandes) + (getPreco_cao_pequeno() * quantCaesPequenos);
    }
}
