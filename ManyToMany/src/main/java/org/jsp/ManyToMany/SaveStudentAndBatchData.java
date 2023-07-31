package org.jsp.ManyToMany;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveStudentAndBatchData {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Batch b1 = new Batch();
		b1.setSubject("Hibernate");
		b1.setCode("WEK9");
		b1.setTrainer("Sathish");

		Batch b2 = new Batch();
		b2.setSubject("J2EE");
		b2.setCode("WEK10");
		b2.setTrainer("Guru Sir");

		Student s1 = new Student();
		s1.setName("Shyam");
		s1.setPerc(89.56);
		s1.setPhone(8877);
		s1.setBatches(new ArrayList<Batch>(Arrays.asList(b1, b2)));

		Student s2 = new Student();
		s2.setName("Krishna");
		s2.setPerc(89.56);
		s2.setPhone(8888);
		s2.setBatches(new ArrayList<Batch>(Arrays.asList(b1, b2)));

		Student s3 = new Student();
		s3.setName("Yadu");
		s3.setPerc(89.56);
		s3.setPhone(8855);
		s3.setBatches(new ArrayList<Batch>(Arrays.asList(b1, b2)));

		Student s4 = new Student();
		s4.setName("Ram");
		s4.setPerc(89.56);
		s4.setPhone(8844);
		s4.setBatches(new ArrayList<Batch>(Arrays.asList(b1)));

		b1.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3, s4)));
		b2.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));
		manager.persist(b1);
		manager.persist(b2);
		transaction.begin();
		transaction.commit();
	}

}
