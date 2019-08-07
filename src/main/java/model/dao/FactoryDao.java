package model.dao;

import model.dao.impl.FactoryDaoImpl;

public abstract class FactoryDao {

        private static FactoryDao factoryDao;

        public abstract DeliveryTypeDao createDeliveryTypeDao();

        public abstract DepartmentDao createDepartmentDao();

        public abstract ExpenseDao createExpenseDao();

        public abstract RequestDao createRequestDao();

        public abstract RoleDao createRoleDao();

        public abstract ScheduleDao createScheduleDao();

        public abstract TariffDao createTariffDao();

        public abstract UserDao createUserDao();

        public abstract WeightDao createWeightDao();

        public static FactoryDao getInstance() {
            if (factoryDao == null) {
                synchronized (FactoryDao.class) {
                    if (factoryDao == null) {
                        factoryDao = new FactoryDaoImpl();
                    }
                }
            }
            return factoryDao;
        }
    }