package com.movember.quizz.controller.control;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import net.sourceforge.wurfl.core.Device;
import net.sourceforge.wurfl.core.WURFLManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.movember.quizz.controller.dto.EstadisticaDTO;
import com.movember.quizz.model.bean.Estadistica;
import com.movember.quizz.model.exception.AppException;
import com.movember.quizz.model.service.IEstadisticaService;

/**
 * 
 * Controlador de estadisticas
 * 
 * **/
@Controller
public class EstadisticaController {

	/**
	 * Servicio para manejos de estadisticas en BBDD
	 * */
	@Inject
	private IEstadisticaService estadisticaService;

	/**
	 * Recurso principal del controlador en la peticiones rest
	 * **/
	private static final String recurso = "estadistica";
	/**
	 * Elemento para conocer que tipo de dispositivo est� accediendo a la
	 * aplicaci�n
	 */
	@Inject
	private WURFLManager manager;

	/**
	 * Petici�n REST que nos devuelve una sola estadistica por ID
	 * 
	 * @param id
	 *            es el id de la estadistica
	 * @return devuelve la estadistica con el id seleccionado
	 * **/
	@RequestMapping(value = "/" + recurso + "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	EstadisticaDTO retrieve(@PathVariable("id") Integer id) {
		EstadisticaDTO estadisticaDTO = new EstadisticaDTO();
		try {
			Estadistica estadistica = this.estadisticaService.retrieve(id);
			// Comversion a DTO
			estadisticaDTO.toRest(estadistica);
		}
		catch (AppException e) {

		}
		return estadisticaDTO;
	}

	/**
	 * Petici�n REST que nos devuelve en otra petici�n REST que operaci�n vamos
	 * a realizar
	 * 
	 * @param operaci�n
	 *            es el identificador para saber si vamos a listar
	 * @return devuelve la nueva petici�n REST
	 * **/
	@RequestMapping(value = "/" + recurso + "/form/{operacion}", method = RequestMethod.GET, produces = "text/html")
	public String createForm(ModelMap model, HttpServletRequest request) {
		model.addAttribute("mobile", this.isMobile(request));
		return recurso + "/form";
	}

	private boolean isMobile(HttpServletRequest request) {
		Device device = manager.getDeviceForRequest(request);
		return !device.isGeneric();
	}
}
