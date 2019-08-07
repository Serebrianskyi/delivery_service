package model.dao;

import model.entity.Weight;

public interface WeightDao extends GenericDao<Weight> {
    Weight findWeightByValueAndCoefficient(double value, double coefficient);

    Weight findWeightByValue(double value);

    boolean weightIsCreated(Weight weight);
}
