package br.com.tt.petshop.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CpfValidatorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void deveriaValidarCpfSemFormatacao() {
        //Preparação
        String cpf = "00011122233";

        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        Assertions.assertTrue(resultado, "Deveria ser um CPF Válido!");
    }

    @Test
    void deveriaFalharCpfSemFormatacaoComLetras() {
        //Preparação
        String cpf = "0001A12223A";

        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        assertFalse(resultado, "Deveria ser um CPF Inválido pois tem letras!");
    }

    @Test
    void deveriaValidarCpfComFormatacao() {
        //Preparação
        String cpf = "000.111.222-33";

        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        Assertions.assertTrue(resultado, "Deveria ser um CPF Válido");
    }

    @Test
    void deveriaFalharEmCpfComFormatacaoELetras(){
        //Preparação
        String cpf = "000.111.A22-33";

        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        assertFalse(resultado, "Deveria falhar pois contém letras");
    }

    @Test
    void deveriaFalharEmCpfComFormatacaoIncorreta(){
        //Preparação
        String cpf = "000.111.2223-3";

        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        assertFalse(resultado, "Deveria falhar pois contém formatação inválida");
    }

    @Test
    void deveriaFalharComCpfMenorQue11Digitos(){
        //Preparação
        String cpf = "000111222";

        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        assertFalse(resultado, "Deveria falhar pois contém menos de 11 dígitos");
    }

    @Test
    void deveriaFalharComCpfMaiorQue14Digitos(){
        //Preparação
        String cpf = "000.111.222-334";

        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        assertFalse(resultado, "Deveria falhar pois contém mais de 14 dígitos");
    }

    @ParameterizedTest
    @ValueSource(strings = {"111.222.334-00", "111.111.111-11", "000.111.000-99"})
    void deveriaValidarComSucessoCpfsValidos(String cpf){
        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        assertTrue(resultado, "Deveria passar pois cpf é válido");
    }

    @ParameterizedTest
    @ValueSource(strings = {"11.222.334-00", "111.11.111-11", "000.111.000-$9", "C00.111.000-11"})
    void deveriaRetornarCpfsInValidos(String cpf){
        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        assertFalse(resultado, "Deveria falhar pois cpf é válido");
    }
}