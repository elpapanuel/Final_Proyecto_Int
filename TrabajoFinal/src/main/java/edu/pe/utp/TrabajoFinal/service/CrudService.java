package edu.pe.utp.TrabajoFinal.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface CrudService<T, ID> {

    Logger logger = LoggerFactory.getLogger(CrudService.class);
	JpaRepository<T, ID> getJpaRepository();

    @Transactional
    default T create(T entity) throws Exception {
        logger.info("Creando entidad: {}", entity);  // Registro del evento de creación
        T savedEntity = getJpaRepository().save(entity);
        logger.info("Entidad creada con éxito: {}", savedEntity);  // Registro de éxito
        return savedEntity;
    }

    @Transactional
    default T update(T entity) throws Exception {
        logger.info("Actualizando entidad: {}", entity);  // Registro del evento de actualización
        T updatedEntity = getJpaRepository().save(entity);
        logger.info("Entidad actualizada con éxito: {}", updatedEntity);  // Registro de éxito
        return updatedEntity;
    }

    @Transactional(readOnly = true)
    default boolean existsById(ID id) throws Exception {
        logger.info("Verificando existencia de entidad con ID: {}", id);  // Registro de verificación
        boolean exists = getJpaRepository().existsById(id);
        logger.info("Existencia de entidad con ID {}: {}", id, exists);  // Registro de resultado
        return exists;
    }

    @Transactional(readOnly = true)
    default Optional<T> findById(ID id) throws Exception {
        logger.info("Buscando entidad con ID: {}", id);  // Registro de búsqueda
        Optional<T> entity = getJpaRepository().findById(id);
        if (entity.isPresent()) {
            logger.info("Entidad encontrada: {}", entity.get());  // Registro de éxito
        } else {
            logger.warn("Entidad con ID {} no encontrada", id);  // Registro de advertencia
        }
        return entity;
    }

    @Transactional(readOnly = true)
    default List<T> getAll() throws Exception {
        logger.info("Recuperando todas las entidades");  // Registro de la recuperación
        List<T> entities = getJpaRepository().findAll();
        logger.info("Se recuperaron {} entidades", entities.size());  // Registro del número de entidades
        return entities;
    }

    @Transactional
    default void deleteById(ID id) throws Exception {
        logger.info("Eliminando entidad con ID: {}", id);  // Registro de eliminación
        getJpaRepository().deleteById(id);
        logger.info("Entidad con ID {} eliminada con éxito", id);  // Registro de éxito
    }

    @Transactional
    default void delete(T entity) throws Exception {
        logger.info("Eliminando entidad: {}", entity);  // Registro de eliminación
        getJpaRepository().delete(entity);
        logger.info("Entidad eliminada con éxito: {}", entity);  // Registro de éxito
    }
}
