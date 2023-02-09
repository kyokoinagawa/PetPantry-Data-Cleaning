package com.petpantry.petpantry.dao;

import com.petpantry.petpantry.model.Donate;

import java.util.List;

public interface DonateDao {
    List<Donate> findAllCatDonations();
    List<Donate> findAllDogDonations();
    boolean donationEntryCat(String itemName, int quantity);
    boolean donationEntryDog(String itemName, int quantity);
    boolean pickupEntryCat(String itemName, int quantity);
    boolean pickupEntryDog(String itemName, int quantity);
}
