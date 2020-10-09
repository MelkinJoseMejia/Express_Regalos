package com.claro.WSCRUDSerMensajesServicio.interfase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.claro.WSCRUDSerMensajesServicio.dto.SerMensaje;

@Component
public interface SerMensajesJpaRepository extends JpaRepository<SerMensaje, Long> , CrudRepository<SerMensaje, Long>{
	
}
