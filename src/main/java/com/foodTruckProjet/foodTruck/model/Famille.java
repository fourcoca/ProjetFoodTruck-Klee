package com.foodTruckProjet.foodTruck.model;

public enum Famille {
	BF ("boisson froide"),
	  BC ("boisson chaude"),
	  Plat ("plat"),
	  Dessert ("dessert"),
	  Entree ("entree");

	 private String name = "";
	   
	  //Constructeur
	 Famille(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }
}
