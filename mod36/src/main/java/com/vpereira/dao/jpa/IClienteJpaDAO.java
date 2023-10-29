package com.vpereira.dao.jpa;

import com.vpereira.dao.generic.jpa.IGenericJapDAO;
import com.vpereira.domain.jpa.Persistente;

public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long>{

}
