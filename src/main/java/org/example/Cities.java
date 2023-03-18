package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CITIES")
public class Cities {
	
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "CITIES_ID")
        private int id;
        
        @Column(name = "COUNTRY")
        private String country;
        
        @Column(name = "CITY")
        private String city;

        public Cities() {
        }

        public Cities( String country, String city) {
            this.country = country;
            this.city = city;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "Cities{" +
                    "id=" + id +
                    ", country='" + country + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
