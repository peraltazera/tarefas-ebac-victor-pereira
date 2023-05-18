package br.com.vpereira.dao;

public class ContratoDAO implements IContratoDAO{

    @Override
    public String salvar() {
        return "Salvo";
    }

    @Override
    public Boolean buscar() {
        return true;
    }

    @Override
    public Boolean excluir() {
        return false;
    }

    @Override
    public String atualizar() {
        return "Atualizado";
    }
}
