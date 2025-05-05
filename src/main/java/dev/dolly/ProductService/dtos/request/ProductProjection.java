package dev.dolly.ProductService.dtos.request;

public interface ProductProjection {
    String getName();
    String getDescription();
}

//Projections-->interfaces mimicking/projecting an object containing subset
//of attributes/columns for a model
//how to implement projection?
//create an interface and add get methods for the attributes
//convention for get methods -->getAttributeName()

//use this projection as output for your repo methods
