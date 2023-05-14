package br.com.vpereira;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GrupoPessoasTest {

    @Test
    public void pessoas() {
        GrupoPessoas pessoas = new GrupoPessoas();
        pessoas.stringParaPessoas("Victor-M,Cecilia-F,Leo-M,Bianca-F");
        List<Pessoa> expected = new ArrayList<Pessoa>();
        expected.add(new Pessoa("Victor","M"));
        expected.add(new Pessoa("Cecilia","F"));
        expected.add(new Pessoa("Leo","M"));
        expected.add(new Pessoa("Bianca","F"));
        Assert.assertEquals(expected.toString(), pessoas.getPessoas().toString());
    }

    @Test
    public void homens() {
        GrupoPessoas pessoas = new GrupoPessoas();
        pessoas.stringParaPessoas("Victor-M,Cecilia-F,Leo-M,Bianca-F");
        List<Pessoa> expected = new ArrayList<Pessoa>();
        expected.add(new Pessoa("Victor","M"));
        expected.add(new Pessoa("Leo","M"));
        Assert.assertEquals(expected.toString(), pessoas.getHomens().toString());
    }

    @Test
    public void mulheres() {
        GrupoPessoas pessoas = new GrupoPessoas();
        pessoas.stringParaPessoas("Victor-M,Cecilia-F,Leo-M,Bianca-F");
        List<Pessoa> expected = new ArrayList<Pessoa>();
        expected.add(new Pessoa("Cecilia","F"));
        expected.add(new Pessoa("Bianca","F"));
        Assert.assertEquals(expected.toString(), pessoas.getMulheres().toString());
    }
}
