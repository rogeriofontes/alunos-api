package br.ufu.techweek.alunosapi.model.service;

import java.math.BigDecimal;

public enum Desconto {

    FIES {
        @Override
        public BigDecimal calculaDesconto(BigDecimal valor) {
            return valor.multiply(BigDecimal.valueOf(0.80));
        }
    },

    FINANCIAMENTO_BANCO {
        @Override
        public BigDecimal calculaDesconto(BigDecimal valor) {
            return valor.multiply(BigDecimal.valueOf(0.50));
        }
    },

    FINANCIAMENTO_INTERNO {
        @Override
        public BigDecimal calculaDesconto(BigDecimal valor) {
            return valor.multiply(BigDecimal.valueOf(0.30));
        }
    },

    BOLSA_50 {
        @Override
        public BigDecimal calculaDesconto(BigDecimal valor) {
            return valor.multiply(BigDecimal.valueOf(0.20));
        }
    },

    BOLSA_100 {
        @Override
        public BigDecimal calculaDesconto(BigDecimal valor) {
            return valor.multiply(BigDecimal.valueOf(0.50));
        }
    };

    public abstract BigDecimal calculaDesconto(BigDecimal valor);

    public static Desconto getType(String type){
        for (Desconto desconto : Desconto.values())
        if (type.equals(desconto.name())) {
            return desconto;
        }

        return null;
    }
}
