package io.github.williamtrindade.unity2.class7.e;

public class Director {
    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void calabreza() {
        builder.buildMassa();
        builder.molhoTomate();
        builder.queijo();
        builder.calabreza();
    }

    public void cornBacon() {
        builder.buildMassa();
        builder.molhoTomate();
        builder.queijo();
        builder.milho();
        builder.bacon();
    }

    public void daCasa() {
        builder.buildMassa();
        builder.molhoTomate();
        builder.queijo();
        builder.milho();
        builder.bacon();
        builder.batataPalha();
        builder.calabreza();
        builder.carneGado();
        builder.queijoCatupiry();
        builder.queijoGorgonzola();
    }
}
