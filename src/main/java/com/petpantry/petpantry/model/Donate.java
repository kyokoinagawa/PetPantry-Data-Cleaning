package com.petpantry.petpantry.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Donate {
   private int id;
   @JsonProperty("item_name")
   private String itemName;
   private int quantity;

   public Donate(){};

   public Donate(int id, String itemName, int quantity) {
      this.id = id;
      this.itemName = itemName;
      this.quantity = quantity;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getItemName() {
      return itemName;
   }

   public void setItemName(String itemName) {
      this.itemName = itemName;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

}
