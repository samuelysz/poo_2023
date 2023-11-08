package atividade9;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class test {
 @Test
 public void testDizerOla() {
     pessoa pessoa = new pessoa();
     String mensagemEsperada = "Olá! Sou uma pessoa.";
     assertEquals(mensagemEsperada, pessoa.dizerOla());
 }
}
