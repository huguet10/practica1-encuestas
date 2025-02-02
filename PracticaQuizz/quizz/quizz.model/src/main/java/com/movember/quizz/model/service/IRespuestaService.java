package com.movember.quizz.model.service;

import java.util.List;
import com.movember.quizz.model.bean.Respuesta;
import com.movember.quizz.model.exception.AppException;

/**
 * The Interface IRespuestaService.
 */
public interface IRespuestaService extends IService<Respuesta> {

	/**
	 * Recuperar de pregunta.
	 * 
	 * @param id
	 *            the id
	 * @return the list
	 * @throws AppException
	 *             the app exception
	 */
	List<Respuesta> recuperarDePregunta(Integer id) throws AppException;

	Integer recuperarVecesContestadasPorIdentificado(Integer idRespuesta) throws AppException;

	Integer recuperarVecesContestadasPorNoIdentificado(Integer idRespuesta) throws AppException;

	/**
	 * Contestar.
	 * 
	 * @param idEncuestaContestada
	 *            the id encuesta contestada
	 * @param idRespuesta
	 *            the id respuesta
	 * @throws AppException
	 *             the app exception
	 */
	void contestar(Integer idEncuestaContestada, Integer idRespuesta) throws AppException;
}