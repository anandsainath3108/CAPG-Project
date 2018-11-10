package com.capg.cms.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	public static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("parallelproject_161680").createEntityManager();
	}
}