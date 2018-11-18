package com.etwas.rest;

import com.etwas.data.ProductRepository;
import com.etwas.model.Product;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.logging.Logger;

/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read/write the contents of the products table.
 */
@Path("/products")
@RequestScoped
public class ProductResourceRESTService {
    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private ProductRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> listAllProducts() {
        return repository.findAllOrderedByName();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product lookupProductById(@PathParam("id") /*long*/int id) {
        Product product = repository.findById(id);
        if (product == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return product;
    }
}
