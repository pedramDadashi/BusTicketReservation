package org.example.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEntityMangerFactory() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("default");
        return emf;
    }

}
