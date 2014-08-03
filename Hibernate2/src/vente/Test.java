package vente;

import java.util.*;
import net.sf.hibernate.*;





public class Test {

	public static void main(String[] args) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Billet billet= new Billet(2, "Contenur hibernate",new Date(), "ma difficulete");

//		TContact contact = new TContact();
//		contact.setNom("Jacson");
//		contact.setPrenom("Antonio");
//		contact.setAge(new Integer(25));
//		session.save(contact);
//
//		contact = new TContact();
//		contact.setNom("Lambert");
//		contact.setPrenom("Julie");
//		contact.setAge(new Integer(27));
//		session.save(contact);
//		
//		TContact contact =
//				(TContact) session.load(TContact.class, new Integer(1));
//
//				contact.setPrenom("Jacques");
				session.save(billet);
		tx.commit();
		
//		List list = session.find("from TContact where nom like '%t'");
//		Iterator it = list.iterator();
//		while(it.hasNext())
//		{
//		  TContact contact = (TContact)it.next();
//		  System.out.println(contact.getNom());
//		}

		HibernateUtil.closeSession();
	}

}
