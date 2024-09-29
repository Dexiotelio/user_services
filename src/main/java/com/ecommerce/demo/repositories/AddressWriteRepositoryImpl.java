package com.ecommerce.demo.repositories;

import com.ecommerce.demo.entities.Address;
import com.ecommerce.demo.util.Result;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AddressWriteRepositoryImpl implements AddressWriteRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AddressWriteRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Result<Void> create(Address address) {
        String sql = "INSERT INTO Address (user_id, street, street_number, " +
                "apartment_number, neighborhood, city, state, " +
                "postal_code, country ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return Try.of(() -> {
            jdbcTemplate.update(sql, address.getUserId(), address.getStreet(),
                    address.getStreetNumber(), address.getApartmentNumber(),
                    address.getNeighborhood(), address.getCity(), address.getState(),
                    address.getPostalCode(), address.getCountry());
            return Result.success((Void) null);
        }).getOrElseGet(e -> Result.failure("Error creating address: " + e.getMessage()));
    }

    @Override
    public Result<Address> findById(Long id) {
        return null;
    }

    @Override
    public Result<Void> delete(Long id) {
        return null;
    }
}