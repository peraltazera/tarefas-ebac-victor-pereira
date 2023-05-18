package br.com.vpereira.service;

import br.com.vpereira.dao.ContratoDAO;

import java.util.ArrayList;
import java.util.List;

public class ContratoService implements IContratoService{

    private ContratoDAO contradoDao;

    public ContratoService(ContratoDAO contradoDao) {
        this.contradoDao = contradoDao;
    }

    @Override
    public String salvar() {
        contradoDao.salvar();
        return "Salvo";
    }

    @Override
    public Boolean buscar() {
        contradoDao.buscar();
        return true;
    }

    @Override
    public Boolean excluir() {
        contradoDao.excluir();
        return false;
    }

    @Override
    public String atualizar() {
        contradoDao.atualizar();
        return "Atualizado";
    }
}
