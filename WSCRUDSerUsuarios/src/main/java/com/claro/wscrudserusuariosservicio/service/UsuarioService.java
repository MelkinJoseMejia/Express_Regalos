package com.claro.wscrudserusuariosservicio.service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.claro.wscrudserusuariosservicio.dto.Constantes;

@Service
@Transactional
public class UsuarioService {

	@PersistenceContext
	private EntityManager em;
	
	public String cargarUsuario(String cadenaUsuario) {
		String result = null;
		try {
			StoredProcedureQuery query = em.createStoredProcedureQuery(Constantes.PRC_CARGAR_USUARIOS);
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT);
			
			query.setParameter(1, cadenaUsuario);
			
			result = (String) query.getOutputParameterValue(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
