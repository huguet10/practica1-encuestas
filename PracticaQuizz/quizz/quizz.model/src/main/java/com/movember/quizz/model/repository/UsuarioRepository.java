package com.movember.quizz.model.repository;

import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.movember.quizz.model.bean.Usuario;

@Repository
class RepositoryDAO implements IRepositoryDAO<Usuario> {

	@Inject
	private HibernateTemplate hibernateTemplate;

	public void save(Usuario usuario) {
		hibernateTemplate.save(usuario);
	}

	public void update(Usuario usuario) {
		hibernateTemplate.update(usuario);
	}

	public void delete(Usuario usuario) {
		hibernateTemplate.delete(usuario);
	}

	public Usuario findOne(Long pId) {
		return (Usuario) hibernateTemplate.load(Usuario.class, pId);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		return hibernateTemplate.loadAll(Usuario.class);
	}

}
