package com.petpantry.petpantry.dao;

import com.petpantry.petpantry.model.Donate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDonateDao implements DonateDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcDonateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Donate> findAllCatDonations() {
        List<Donate> catDonations = new ArrayList<>();
        String sql = "SELECT id, item_name, quantity FROM cat_donations " +
                    "ORDER BY id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Donate donate = mapRowToDonate(results);
            catDonations.add(donate);
        }
        return catDonations;
    }

    @Override
    public List<Donate> findAllDogDonations() {
        List<Donate> dogDonations = new ArrayList<>();
        String sql = "SELECT id, item_name, quantity FROM dog_donations " +
                "ORDER BY id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Donate donate = mapRowToDonate(results);
            dogDonations.add(donate);
        }
        return dogDonations;
    }

    @Override
    public boolean donationEntryCat (String itemName, int quantity) {
        String sql = "UPDATE cat_donations SET quantity = (quantity + ?) " +
                    "WHERE item_name = ?;";
        return jdbcTemplate.update(sql, quantity, itemName) == 1;
    }

    @Override
    public boolean donationEntryDog(String itemName, int quantity) {
        String sql = "UPDATE dog_donations SET quantity = (quantity + ?) " +
                "WHERE item_name = ?;";
        return jdbcTemplate.update(sql, quantity, itemName) == 1;
    }


    @Override
    public boolean pickupEntryCat(String itemName, int quantity){
        String sql = "UPDATE cat_donations SET quantity = (quantity - ?) " +
                "WHERE item_name = ?;";
        return jdbcTemplate.update(sql, quantity, itemName) == 1;
    }

    @Override
    public boolean pickupEntryDog(String itemName, int quantity){
        String sql = "UPDATE dog_donations SET quantity = (quantity - ?) " +
                "WHERE item_name = ?;";
        return jdbcTemplate.update(sql, quantity, itemName) == 1;
    }

    private Donate mapRowToDonate(SqlRowSet rs) {
        Donate donate = new Donate();
        donate.setId(rs.getInt("id"));
        donate.setItemName(rs.getString("item_name"));
        donate.setQuantity(rs.getInt("quantity"));
        return donate;
    }



}
