package com.claro.WSCRUDSerProductosServicio.dto;

import java.util.List;

import com.claro.WSCRUDSerProductosServicio.entity.SerUsuario;

public class ProductoDTO {
	
	private SerUsuario	empresa;
	private List<CampaniaDTO> listCampania;
	
	public ProductoDTO() {
	}
	
	public ProductoDTO(SerUsuario empresa, List<CampaniaDTO> listCampania) {
		super();
		this.empresa = empresa;
		this.listCampania = listCampania;
	}

	public SerUsuario getEmpresa() {
		return empresa;
	}

	public void setEmpresa(SerUsuario empresa) {
		this.empresa = empresa;
	}

	public List<CampaniaDTO> getListCampania() {
		return listCampania;
	}

	public void setListCampania(List<CampaniaDTO> listCampaniaDTO) {
		this.listCampania = listCampaniaDTO;
	}
	
	
}
