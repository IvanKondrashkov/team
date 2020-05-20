package ru.gwp.team.core;

import ru.gwp.team.app.components.BaseMaterial;

public class BaseService {

    protected <T extends BaseMaterial> void setBaseFeatures(T record, T entity) {
        record.setName(entity.getName());
        record.setDescription(entity.getDescription());
        record.setUnit(entity.getUnit());
        record.setPrice(entity.getPrice());
        record.setWeight(entity.getWeight());
        record.setHeight(entity.getHeight());
        record.setWidth(entity.getWidth());
        record.setLength(entity.getLength());
        record.setManufacturer(entity.getManufacturer());
        record.setIssueDate(entity.getIssueDate());
        record.setExpirationDate(entity.getExpirationDate());
    }
}
