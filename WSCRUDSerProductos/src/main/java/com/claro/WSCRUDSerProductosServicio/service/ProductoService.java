package com.claro.WSCRUDSerProductosServicio.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.claro.WSCRUDSerProductosServicio.dto.CampaniaDTO;
import com.claro.WSCRUDSerProductosServicio.dto.Constantes;
import com.claro.WSCRUDSerProductosServicio.dto.ProductoDTO;
import com.claro.WSCRUDSerProductosServicio.entity.SerProducto;
import com.claro.WSCRUDSerProductosServicio.entity.SerUsuario;
import com.claro.WSCRUDSerProductosServicio.utils.Mapeador;

@Service
@Transactional
public class ProductoService {

	@PersistenceContext
	private EntityManager em;
	
	public List<ProductoDTO> consultarProductosPorEmpresa(String nit, String nombreCampania, String objetivoConsulta){
		List<ProductoDTO> result = null;
		
		StoredProcedureQuery query = em.createStoredProcedureQuery(Constantes.PRC_CONSULTAR_PRODUCTOS_X_USUARIO);
		
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, Class.class, ParameterMode.REF_CURSOR);
		
		
		query.setParameter(1, nit);
		query.setParameter(2, nombreCampania);
		query.setParameter(3, objetivoConsulta);
		
		query.execute();
		
		ResultSet rs = (ResultSet)query.getOutputParameterValue(4);
		
		try {
			if(rs != null) {
				result = new ArrayList<>();
				SerUsuario empresa = null;
				List<CampaniaDTO> listCampaniaDTOs = null;
				CampaniaDTO campaniaDTO = null;
				List<SerProducto> listProductos = null;
				Long nitAnterior = null;
				String campaniaAnterior = "";
				
				
				while(rs.next()) {
					//crear una empresa		
					Long nitEmp = rs.getLong("NIT");
					String campania = rs.getString("NOMBRE_CAMPANA");
					
					if(!Objects.equals(nitEmp,nitAnterior)) {
						if(Objects.nonNull(empresa)) {
							campaniaDTO.setListaProductos(listProductos);
							listCampaniaDTOs.add(campaniaDTO);
							result.add(new ProductoDTO(empresa,listCampaniaDTOs ));
						}
						empresa = Mapeador.mapearAEmpresa(rs);
						nitAnterior = nitEmp;
						listCampaniaDTOs = new ArrayList<CampaniaDTO>();
						campaniaDTO = null;
						campaniaAnterior = "";
						listProductos = null;
					}
					
					//crear campania
					if( !Objects.equals(campania, campaniaAnterior)) {
						if( campaniaDTO != null ) {
							campaniaDTO.setListaProductos(listProductos);
							listCampaniaDTOs.add(campaniaDTO);
						}
						campaniaDTO = Mapeador.mapearACampaniaDTO(rs);
						campaniaAnterior = campania;
						listProductos = new ArrayList<SerProducto>();
					}
					
					//agregar productos
					SerProducto SerProducto = Mapeador.mapearAProducto(rs);
					listProductos.add(SerProducto);
				}
				//agrega la primera o ultima empresa recorrida
				if(campaniaDTO != null) {
					campaniaDTO.setListaProductos(listProductos);
					listCampaniaDTOs.add(campaniaDTO);
					result.add(new ProductoDTO(empresa,listCampaniaDTOs ));
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String redimirProducto(String nit, String nombreProducto, Integer cantidadRedimir, Date fechaRedencion) {
		StoredProcedureQuery query = em.createStoredProcedureQuery(Constantes.PRC_REDIMIR_PRODUCTO);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, Date.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.OUT);
		
		query.setParameter(1, nit);
		query.setParameter(2, nombreProducto);
		query.setParameter(3, cantidadRedimir);
		query.setParameter(4, fechaRedencion);
		
		return (String)query.getOutputParameterValue(5);
	}
	
	public String cargarProducto(String cadenaProducto, String imagenProducto) {
		StoredProcedureQuery query = em.createStoredProcedureQuery(Constantes.PRC_CARGAR_PRODUCTOS);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		
		
		query.setParameter(1, cadenaProducto);
		query.setParameter(2, imagenProducto);
		
		return (String)query.getOutputParameterValue(3);
	}
	
}
