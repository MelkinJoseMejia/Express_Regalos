package com.claro.WSCRUDSerMensajesXCampanaServicio.interfase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.claro.WSCRUDSerMensajesXCampanaServicio.dto.SerMensajesXCampana;

@Component
public interface SerMensajesXCampanaJpaRepository extends JpaRepository<SerMensajesXCampana, Long> , CrudRepository<SerMensajesXCampana, Long>{
	
}
