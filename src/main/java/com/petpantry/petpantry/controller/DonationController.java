package com.petpantry.petpantry.controller;

import com.petpantry.petpantry.dao.DonateDao;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.petpantry.petpantry.model.Donate;
import org.springframework.web.server.ResponseStatusException;


import java.security.Principal;
import java.util.List;

/**
 * Controller to authenticate users.
 */

@RestController
public class DonationController {

    private DonateDao donateDao;

    public DonationController(DonateDao donateDao) {
        this.donateDao = donateDao;
    }

    @RequestMapping(path = "/cat/donations", method = RequestMethod.GET)
    public List<Donate> getAllCatDonations(){
        return donateDao.findAllCatDonations();
    }

    @RequestMapping(path = "/dog/donations", method = RequestMethod.GET)
    public List<Donate> getAllDogDonations(){
        return donateDao.findAllDogDonations();
    }


    @RequestMapping(path = "/donate/cat", method = RequestMethod.PUT)
    public boolean increaseCatInventory(@RequestBody Donate catItem){
        donateDao.donationEntryCat(catItem.getItemName(), catItem.getQuantity());
        return true;
    }

    @RequestMapping(path = "/donate/dog", method = RequestMethod.PUT)
    public boolean increaseDogInventory(@RequestBody Donate dogItem){
        donateDao.donationEntryDog(dogItem.getItemName(), dogItem.getQuantity());
        return true;
    }
    @RequestMapping(path = "/pickup/cat", method = RequestMethod.PUT)
    public boolean decreaseCatInventory(@RequestBody Donate catItem){
        donateDao.pickupEntryCat(catItem.getItemName(), catItem.getQuantity());
        return true;
    }
    @RequestMapping(path = "/pickup/dog", method = RequestMethod.PUT)
    public boolean decreaseDogInventory(@RequestBody Donate dogItem){
        donateDao.pickupEntryDog(dogItem.getItemName(), dogItem.getQuantity());
        return true;
    }


    }


