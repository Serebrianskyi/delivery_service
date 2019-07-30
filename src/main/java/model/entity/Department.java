package model.entity;

import java.util.Objects;

 public class Department {
        private Integer id;
        private String town;
        private String street;
        private String buildingNumber;
        private Integer sheduleId;

        public Department(Integer id, String town, String street, String buildingNumber, Integer sheduleId) {
            this.id = id;
            this.town = town;
            this.street = street;
            this.buildingNumber = buildingNumber;
            this.sheduleId = sheduleId;
        }

        public Department() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTown() {
            return town;
        }

        public void setTown(String town) {
            this.town = town;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getBuildingNumber() {
            return buildingNumber;
        }

        public void setBuildingNumber(String buildingNumber) {
            this.buildingNumber = buildingNumber;
        }

        public Integer getSheduleId() {
            return sheduleId;
        }

        public void setSheduleId(Integer sheduleId) {
            this.sheduleId = sheduleId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Department that = (Department) o;
            return town.equals(that.town) &&
                    street.equals(that.street) &&
                    buildingNumber.equals(that.buildingNumber) &&
                    sheduleId.equals(that.sheduleId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(town, street, buildingNumber, sheduleId);
        }
    }
