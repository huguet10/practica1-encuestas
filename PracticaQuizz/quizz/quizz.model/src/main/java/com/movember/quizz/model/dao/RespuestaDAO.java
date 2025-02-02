package com.movember.quizz.model.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.bean.RespuestaContestada;

/**
 * The Class RespuestaDAO.
 */
@Repository
class RespuestaDAO extends AbstractDAO implements IRespuestaDAO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.movember.quizz.model.dao.IRepositoryDAO#insert(com.movember.quizz
	 * .model.bean.AbstractBean)
	 */
	public void insert(Respuesta respuesta) throws SQLException {
		Integer id = (Integer) this.getSqlMapClient().insert("respuesta.insertReturnId", respuesta);
		respuesta.setId(id);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.movember.quizz.model.dao.IRepositoryDAO#update(com.movember.quizz
	 * .model.bean.AbstractBean)
	 */
	public void update(Respuesta respuesta) throws SQLException {
		this.getSqlMapClient().update("respuesta.updateByPrimaryKey", respuesta);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.movember.quizz.model.dao.IRepositoryDAO#delete(java.lang.Integer)
	 */
	public void delete(Integer id) throws SQLException {
		this.getSqlMapClient().delete("respuesta.deleteByPrimaryKey", id);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.movember.quizz.model.dao.IRepositoryDAO#retrieve(java.lang.Integer)
	 */
	public Respuesta retrieve(Integer id) throws SQLException {
		return (Respuesta) this.getSqlMapClient().queryForObject("respuesta.selectById", id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.movember.quizz.model.dao.IRepositoryDAO#selectAll()
	 */
	public List<Respuesta> selectAll() throws SQLException {
		return (List<Respuesta>) this.getSqlMapClient().queryForList("respuesta.selectAll");
	}

	/*
	 * (non-Javadoc)
	 * @see com.movember.quizz.model.dao.IRepositoryDAO#selectByCriterios()
	 */
	public List<Respuesta> selectByCriterios() throws SQLException {
		return (List<Respuesta>) this.getSqlMapClient().queryForList("respuesta.selectAll");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.movember.quizz.model.dao.IRespuestaDAO#recuperarDePregunta(java.lang
	 * .Integer)
	 */
	public List<Respuesta> recuperarDePregunta(Integer idPregunta) throws SQLException {
		return (List<Respuesta>) this.getSqlMapClient().queryForList("respuesta.recuperarDePregunta", idPregunta);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.movember.quizz.model.dao.IRespuestaDAO#contestar(com.movember.quizz
	 * .model.bean.RespuestaContestada)
	 */
	public void contestar(RespuestaContestada respuestaContestada) throws SQLException {
		this.getSqlMapClient().insert("respuesta.contestar", respuestaContestada);
	}

	public Integer recuperarVecesContestadasPorNoIdentificado(Integer idRespuesta) throws SQLException {
		return (Integer) this.getSqlMapClient().queryForObject("respuesta.recuperarVecesContestadasPorNoIdentificado", idRespuesta);
	}

	public Integer recuperarVecesContestadasPorIdentificado(Integer idRespuesta) throws SQLException {
		return (Integer) this.getSqlMapClient().queryForObject("respuesta.recuperarVecesContestadasPorIdentificado", idRespuesta);
	}
}