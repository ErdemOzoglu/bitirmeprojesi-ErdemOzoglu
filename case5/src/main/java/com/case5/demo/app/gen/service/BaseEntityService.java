package com.case5.demo.app.gen.service;

//import com.case5.demo.app.crd.dao.CrdCreditCardActivityDao;
import com.case5.demo.app.gen.entity.BaseAdditionalFields;
import com.case5.demo.app.gen.entity.BaseEntity;
import com.case5.demo.app.gen.enums.GenErrorMessage;
import com.case5.demo.app.gen.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, D extends JpaRepository<E, Long>> {

    private final D dao;


    private final String genericClassName = ((Class<E>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0])
            .getSimpleName();



    public List<E> findAll(){
        return dao.findAll();
    }

    public Optional<E> findById(Long id){
        return dao.findById(id);
    }

    public E save(E entity){

        setAdditionalFields(entity);
        entity = dao.save(entity);

        return entity;
    }

    private void setAdditionalFields(E entity) {

        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();

        Long currentCustomerId = getCurrentCustomerId();

        if (baseAdditionalFields == null){
            baseAdditionalFields = new BaseAdditionalFields();
            entity.setBaseAdditionalFields(baseAdditionalFields);
        }

        if (entity.getId() == null){
            baseAdditionalFields.setCreateDate(new Date());
            baseAdditionalFields.setCreatedBy(currentCustomerId);
        }

        baseAdditionalFields.setUpdateDate(new Date());
        baseAdditionalFields.setUpdatedBy(currentCustomerId);
    }

    public void delete(E entity){
        dao.delete(entity);
    }

    public E getByIdWithControl(Long id) {

        Optional<E> entityOptional = findById(id);

        E entity;

       // Class clazz = dao.getClass();
       // String clazzName = clazz.getSimpleName();
       // System.out.println(clazzName);
        if (entityOptional.isPresent()){
            entity = entityOptional.get();

        } else {
            throw new ItemNotFoundException(GenErrorMessage.ITEM_NOT_FOUND,genericClassName);
        }

        return entity;
    }

    public boolean existsById(Long id){
        return dao.existsById(id);
    }

    public D getDao() {
        return dao;
    }

    //TODO: control after jwt
    private Long getCurrentCustomerId() {
        Long currentCustomer = null;
        return currentCustomer;
    }
}
