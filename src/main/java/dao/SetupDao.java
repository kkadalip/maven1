package dao;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;
//import java.io.File;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.SortedSet;
//import java.util.TreeSet;

//import org.apache.tools.ant.Project;
//import org.apache.tools.ant.taskdefs.SQLExec;
//import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Address;
//import model.Image;
import model.Person;
import model.Project;
//import model.Project;
//import model.ProjectGroup;
//import model.Image;
import model.ProjectGroup;

public class SetupDao { // extends AbstractDaoHibernate {
	Logger log = LoggerFactory.getLogger(SetupDao.class); // info trace debug warn error
	
	// NOT USING ANYMORE
	public void insertSampleDataPersons(){
		log.info("[insertSampleDataPersons] START");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(new Person("John", "Smith"));
		session.save(new Person("Jane", "Doe"));
		transaction.commit(); // session.getTransaction().commit();
		session.close();
		log.info("[insertSampleDataPersons] END");
	}
	
	
	
	public void insertSampleData(){ // AND PROJECT GROUPS
		log.info("[insertSampleDataProjects] START");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//String images_root_folder = "static/images/";
		
		// PROJECT GROUPS
		
		ProjectGroup pg1 = new ProjectGroup();
		pg1.setName("eramud");
		pg1.setImagesRootFolder("Eramud");
		session.save(pg1);
		
		ProjectGroup pg2 = new ProjectGroup();
		pg2.setName("korterelamud.ja.ühiskondlikud.hooned"); // <- for translation files
		pg2.setImagesRootFolder("Korterelamud_ja_ühisk_hooned");
		session.save(pg2);
		
		ProjectGroup pg3 = new ProjectGroup();
		pg3.setName("konkursiprojektid");
		pg3.setImagesRootFolder("Konkursiprojektid");
		session.save(pg3);
		
		ProjectGroup pg4 = new ProjectGroup();
		pg4.setName("planeeringud");
		pg4.setImagesRootFolder("Planeeringud");
		session.save(pg4);
		
		ProjectGroup pg5 = new ProjectGroup();
		pg5.setName("näitused");
		pg5.setImagesRootFolder("Näitused");
		session.save(pg5);
		
		// PERSONS (people)
		
		Person personVelleKadalipp = new Person("Velle", "Kadalipp");
		session.save(personVelleKadalipp);
		Person personKalleVellevoog = new Person("Kalle", "Vellevoog");
		session.save(personKalleVellevoog);
		Person personTiiuTruus = new Person("Tiiu", "Truus");
		session.save(personTiiuTruus);
		// konstruktor
		Person personMartinPrommik = new Person("Martin", "Prommik");
		session.save(personMartinPrommik);
		log.debug("MARTIN PROMMIK ID IS: " + personMartinPrommik.getId());
		// kaastöö
		Person personMargusTamm = new Person("Margus", "Tamm");
		session.save(personMargusTamm);
		// maastikuarhitekt
		Person personAhtiLaane = new Person("Ahti", "Lääne");
		session.save(personAhtiLaane);
		Person personVaikeParker = new Person("Vaike", "Parker");
		session.save(personVaikeParker);
		Person personAndrusAndrejev = new Person("Andrus", "Andrejev");
		session.save(personAndrusAndrejev);
		Person personLidiaZarudnaja = new Person("Lidia", "Zarudnaja");
		session.save(personLidiaZarudnaja);
		Person personMalleLaan = new Person("Malle", "Laan");
		session.save(personMalleLaan);
		Person personUdoIvask = new Person("Udo", "Ivask");
		session.save(personUdoIvask);
		Person personPilleNoole = new Person("Pille", "Noole");
		session.save(personPilleNoole);
		Person personMartKadarik = new Person("Mart", "Kadarik");
		session.save(personMartKadarik);
		Person personMargusTriibmann = new Person("Margus", "Triibmann");
		session.save(personMargusTriibmann);
		Person personLailaPodra = new Person("Laila", "Põdra");
		session.save(personLailaPodra);
		Person personMartinPedanik = new Person("Martin", "Pedanik");
		session.save(personMartinPedanik);
		Person personKarenJagodin = new Person("Karen", "Jagodin");
		session.save(personKarenJagodin);
		Person personMihkelTuur = new Person("Mihkel", "Tüür");
		session.save(personMihkelTuur);
		Person personOttKadarik = new Person("Ott", "Kadarik");
		session.save(personOttKadarik);
		Person personReedikPoopuu = new Person("Reedik", "Poopuu");
		session.save(personReedikPoopuu);
		Person personMartenTuuling = new Person("Märten", "Tuuling");
		session.save(personMartenTuuling);
		Person personAivarHanniotti = new Person("Aivar", "Hanniotti");
		session.save(personAivarHanniotti);
		Person personArneMaasik = new Person("Arne", "Maasik");
		session.save(personArneMaasik);
		
		log.debug("KALLE VELLEVOOG ID IS: " + personKalleVellevoog.getId());
		// PROJECTS
		
		Project p1 = new Project();
		p1.setName("eramute.grupp.seedri.remmelga"); // Eramute grupp Seedri ja Remmelga tänavate vahelisel alal Pärnus
		p1.setPlanningStartYear(2000);
		p1.setPlanningEndYear(2001);
		p1.setBuildingStartYear(2002);
		p1.setBuildingEndYear(2003);
		//Set<Person> p1set = new HashSet<Person>();
		List<Person> p1architects = new ArrayList<Person>();
		p1architects.add(personKalleVellevoog); 
		p1.setArchitects(p1architects);
		p1.setSizeQuantity(2026f);
		//p1.setSizeUnit("m2"); // Todo separate model for units so I can convert them on the fly
		// BROKEN p1.setProjectGroup(pg1);
		p1.setProjectGroup(pg1);
		p1.setImagesRootFolder("Eramute_grupp_Seedri_Remmelga");
		p1.setImagesArray(p1.getProjectGroup().getImagesRootFolder() + "/" + p1.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg","10.jpg","Joonis.jpg"});
//      OLD WAY OF ADDING IMAGES
//		String p1images_folder = pg1.getImagesRootFolder() + "/Eramute grupp seedri remmelga";
//		List<Image> p1images = new ArrayList<Image>();		
//		p1images.add(new Image(p1images_folder,"1.jpg"));
//		p1images.add(new Image(p1images_folder,"2.jpg"));
//		p1images.add(new Image(p1images_folder,"3.jpg"));
//		p1images.add(new Image(p1images_folder,"4.jpg"));
//		p1images.add(new Image(p1images_folder,"5.jpg"));
//		p1images.add(new Image(p1images_folder,"6.jpg"));
//		p1images.add(new Image(p1images_folder,"7.jpg"));
//		p1images.add(new Image(p1images_folder,"8.jpg"));
//		p1images.add(new Image(p1images_folder,"9.jpg"));
//		p1.setImages(p1images);
		session.save(p1);
		
		Project p2 = new Project();
		p2.setName("eramu.rohuneeme"); // Eramu Rohuneemes
		p2.setPlanningStartYear(2002);
		p2.setBuildingStartYear(2002);
		p2.setBuildingEndYear(2003);
		List<Person> p2architects = new ArrayList<Person>();
		p2architects.add(personKalleVellevoog);
		p2.setArchitects(p2architects);
		p2.setSizeQuantity(260f);
		p2.setProjectGroup(pg1);
		p2.setImagesRootFolder("Rohuneeme");
		p2.setImagesArray(p2.getProjectGroup().getImagesRootFolder() + "/" + p2.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","Joonis.jpg"});
		session.save(p2);
		
		Project p3 = new Project();
		p3.setName("eramu.rohuneeme.2"); // Eramu Rohuneemes 2
		p3.setPlanningStartYear(2005);
		p3.setBuildingStartYear(2011);
		List<Person> p3architects = new ArrayList<Person>();
		p3architects.add(personKalleVellevoog);
		p3.setArchitects(p3architects);
		p3.setSizeQuantity(441f);
		p3.setProjectGroup(pg1);
		p3.setImagesRootFolder("Rohuneeme_2");
		p3.setImagesArray(p3.getProjectGroup().getImagesRootFolder() + "/" + p3.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","Joonis (1. korrus).jpg","Joonis (2. korrus).jpg"});
		session.save(p3);
		
		Project p4 = new Project();
		p4.setName("eramu.aate"); // Eramu Tallinnas Aate tänaval
		p4.setPlanningStartYear(2000);
		p4.setBuildingStartYear(2000);
		p4.setBuildingEndYear(2001);
		List<Person> p4architects = new ArrayList<Person>();
		p4architects.add(personKalleVellevoog);
		p4.setArchitects(p4architects);
		p4.setSizeQuantity(250f);
		p4.setProjectGroup(pg1);
		p4.setImagesRootFolder("Aate");
		p4.setImagesArray(p4.getProjectGroup().getImagesRootFolder() + "/" + p4.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","Joonis.jpg"});
		session.save(p4);
	
		Project p5 = new Project();
		p5.setName("eramu.karepa"); // Suvila Karepal Lääne-Virumaal
		p5.setPlanningStartYear(1999);
		p5.setBuildingStartYear(2000);
		p5.setBuildingEndYear(2002);
		List<Person> p5architects = new ArrayList<Person>();
		p5architects.add(personKalleVellevoog);
		p5.setArchitects(p5architects);
		p5.setSizeQuantity(35f);
		p5.setProjectGroup(pg1);
		p5.setImagesRootFolder("Karepa");
		p5.setImagesArray(p5.getProjectGroup().getImagesRootFolder() + "/" + p5.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","Joonis.jpg"});
		session.save(p5);
		
		Project p6 = new Project();
		p6.setName("eramu.mäepea"); // Eramu Mäepea külas Harjumaal
		p6.setPlanningStartYear(2008);
		List<Person> p6architects = new ArrayList<Person>();
		p6architects.add(personKalleVellevoog);
		p6.setArchitects(p6architects);
		List<Person> p6contributors = new ArrayList<Person>();
		p6contributors.add(personMartinPrommik);
		p6.setContributors(p6contributors);
		p6.setProjectGroup(pg1);
		p6.setImagesRootFolder("Mäepea");
		p6.setImagesArray(p6.getProjectGroup().getImagesRootFolder() + "/" + p6.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","Joonis (1. korrus).jpg","Joonis (2. korrus).jpg"});
		session.save(p6);
		
		Project p7 = new Project();
		p7.setName("eramu.vaatetorn"); // Suvila-vaatetorn põhjarannikul
		p7.setPlanningStartYear(2008);
		List<Person> p7architects = new ArrayList<Person>();
		p7architects.add(personKalleVellevoog);
		p7.setArchitects(p7architects);
		List<Person> p7contributors = new ArrayList<Person>();
		p7contributors.add(personMartinPrommik);
		p7.setContributors(p7contributors);
		p7.setProjectGroup(pg1);
		p7.setImagesRootFolder("Vaatetorn");
		p7.setImagesArray(p7.getProjectGroup().getImagesRootFolder() + "/" + p7.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg"});
		session.save(p7);
		
		Project p8 = new Project();
		p8.setName("pansionaat.seedri.4"); // Pansionaat Pärnus Seedri tn 4
		List<Address> p8addresses = new ArrayList<Address>();
		Address p8address = new Address();
		p8address.setCity("Pärnu");
		p8address.setStreet("Seedri");
		p8address.setStreetType("tänav");
		p8address.setBuilding("4");
		p8addresses.add(p8address);
		p8.setAddresses(p8addresses);
		p8.setPlanningStartYear(2005);
		p8.setBuildingStartYear(2007);
		// Architects:
		List<Person> p8architects = new ArrayList<Person>();
		p8architects.add(personKalleVellevoog);
		p8.setArchitects(p8architects);
		// Contributors:
		List<Person> p8contributors = new ArrayList<Person>();
		p8contributors.add(personMargusTamm);
		p8.setContributors(p8contributors);
		// Constructors:
		List<Person> p8constructors = new ArrayList<Person>();
		p8constructors.add(personAhtiLaane);
		p8.setConstructors(p8constructors);
		// Interior designers:
		List<Person> p8interiorDesigners = new ArrayList<Person>();
		p8interiorDesigners.add(personTiiuTruus);
		p8.setInteriorDesigners(p8interiorDesigners);
		// Landscape architects:
		List<Person> p8landscapeArchitects = new ArrayList<Person>();
		p8landscapeArchitects.add(personVaikeParker);
		p8.setLandscapeArchitects(p8landscapeArchitects);
		p8.setSizeQuantity(4565f);
		p8.setProjectGroup(pg2);
		p8.setImagesRootFolder("Pansionaat_Seedri_4");
		p8.setImagesArray(p8.getProjectGroup().getImagesRootFolder() + "/" + p8.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg","10.jpg","11.jpg","12.jpg","13.jpg","14.jpg","15.jpg","16.jpg","17.jpg","18.jpg","19.jpg","20.jpg","21.jpg","22.jpg","23.jpg","24.jpg","25.jpg","Joonis (1. korrus).jpg","Joonis (2. korrus).jpg","Joonis asendiplaan.jpg","Joonis keldrikorrus.jpg","Joonis lõige.jpg"});
		session.save(p8);
		
		Project p9 = new Project();
		p9.setName("korterelamud.pähkli"); // Korterelamud Tallinnas Pähkli tänaval
		List<Address> p9addresses = new ArrayList<Address>();
		Address p9address = new Address();
		p9address.setCity("Tallinn");
		p9address.setStreet("Pähkli");
		p9address.setStreetType("tänav");
		p9addresses.add(p9address);
		p9.setAddresses(p9addresses);
		p9.setPlanningStartYear(2004);
		p9.setBuildingStartYear(2005);
		// Architects:
		List<Person> p9architects = new ArrayList<Person>();
		p9architects.add(personKalleVellevoog);
		p9architects.add(personVelleKadalipp);
		p9.setArchitects(p9architects);
		p9.setSizeQuantity(903f);
		p9.setApartmentsQuantity(12);
		p9.setProjectGroup(pg2);
		p9.setImagesRootFolder("Korterelamud_Tallinnas_Pähkli");
		p9.setImagesArray(p9.getProjectGroup().getImagesRootFolder() + "/" + p9.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg","Joonis asendiplaan.jpg","Joonis korruseplaan.jpg"});
		session.save(p9);
		
		Project p10 = new Project();
		p10.setName("büroo.ja.kortermaja.tartu.mnt.25"); // Büroo- ja kortermaja Tallinnas Tartu mnt. 25
		p10.setPlanningStartYear(2014);
		p10.setBuildingStartYear(2014);
		List<Person> p10architects = new ArrayList<Person>();
		p10architects.add(personKalleVellevoog);
		p10architects.add(personAndrusAndrejev);
		p10architects.add(personLidiaZarudnaja);
		p10.setArchitects(p10architects);
		// TODO? Koostöös arhitektibürooga Laan & Remi, arhitekt Malle Laan
		List<Person> p10contributors = new ArrayList<Person>();
		p10contributors.add(personMalleLaan);
		p10.setContributors(p10contributors);
		List<Person> p10interiorDesigners = new ArrayList<Person>();
		p10interiorDesigners.add(personTiiuTruus);
		p10.setInteriorDesigners(p10interiorDesigners);
		p10.setSizeQuantity(9500f);
		p10.setApartmentsQuantity(13);
		p10.setProjectGroup(pg2);
		p10.setImagesRootFolder("Büroo_ja_kortermaja_Tartu_mnt_25");
		p10.setImagesArray(p10.getProjectGroup().getImagesRootFolder() + "/" + p10.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","Joonis (1. korrus).png","Joonis (5. korrus).png","Joonis (14. korrus).png"});
		session.save(p10);

		Project p11 = new Project();
		p11.setName("rekonstrueerimine.EHL"); // EHL hoone rekonstrueerimine Eesti Helikunsti Keskuseks
		// ADDRESS
		List<Address> p11addresses = new ArrayList<Address>();
		Address p11address = new Address();
		p11address.setCity("Tallinn");
		p11address.setStreet("Lauteri");
		p11address.setStreetType("tänav");
		p11address.setBuilding("7C");
		p11addresses.add(p11address);
		p11.setAddresses(p11addresses);
		p11.setPlanningStartYear(2014);
		List<Person> p11architects = new ArrayList<Person>();
		p11architects.add(personKalleVellevoog);
		p11architects.add(personLidiaZarudnaja);
		p11.setArchitects(p11architects);
		List<Person> p11contributors = new ArrayList<Person>();
		p11contributors.add(personMartinPrommik);
		p11.setContributors(p11contributors);
		p11.setSizeQuantity(1500f);
		List<Person> p11originalAuthors = new ArrayList<Person>();
		p11originalAuthors.add(personUdoIvask);
		p11.setOriginalAuthors(p11originalAuthors);
		p11.setProjectGroup(pg2);
		p11.setImagesRootFolder("Rekonstruktsioon_EHL");
		p11.setImagesArray(p11.getProjectGroup().getImagesRootFolder() + "/" + p11.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg"});
		session.save(p11);
		
		Project p12 = new Project();
		p12.setName("naftatehas.jaroslav"); // Naftatehase peahoone Jaroslavlis
		p12.setPlanningStartYear(2013);
		List<Person> p12architects = new ArrayList<Person>();
		p12architects.add(personKalleVellevoog);
		p12architects.add(personTiiuTruus);
		p12.setArchitects(p12architects);
		List<Person> p12contributors = new ArrayList<Person>();
		p12contributors.add(personMartinPrommik);
		p12contributors.add(personPilleNoole);
		p12contributors.add(personLidiaZarudnaja);
		p12.setConstructors(p12contributors);
		p12.setSizeQuantity(3650f);
		p12.setProjectGroup(pg2);
		p12.setImagesRootFolder("Naftatehase_peahoone_Jaroslavis");
		p12.setImagesArray(p12.getProjectGroup().getImagesRootFolder() + "/" + p12.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","Joonis (1. korrus).jpg","Joonis (2. korrus).jpg","Joonis (asendiplaan).jpg"});
		session.save(p12);
		
		Project p13 = new Project();
		p13.setName("korterelamu.tallinn.tatari.tn.9.11"); // Korterelamu Tallinnas Tatari tn 9/11
		List<Address> p13addresses = new ArrayList<Address>();
		Address p13address = new Address();
		p13address.setCity("Tallinn");
		p13address.setStreet("Tatari");
		p13address.setStreetType("tänav");
		p13address.setBuilding("9/11");
		p13addresses.add(p13address);
		p13.setAddresses(p13addresses);
		p13.setPlanningStartYear(2004);
		p13.setBuildingStartYear(2005);
		List<Person> p13architects = new ArrayList<Person>();
		p13architects.add(personKalleVellevoog);
		p13architects.add(personVelleKadalipp);
		p13.setArchitects(p13architects);
		List<Person> p13contributors = new ArrayList<Person>();
		p13contributors.add(personAndrusAndrejev);
		p13.setContributors(p13contributors);
		p13.setSizeQuantity(2820f);
		p13.setApartmentsQuantity(24);
		p13.setProjectGroup(pg2);
		p13.setImagesRootFolder("Korterelamu_Tallinn_Tatari_9_ja_11");
		p13.setImagesArray(p13.getProjectGroup().getImagesRootFolder() + "/" + p13.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","Joonis (asendiplaan).jpg","Joonis (plaanid).jpg"});
		session.save(p13);
		
		Project p14 = new Project();
		p14.setName("korterelamu.tallinn.masti"); // Korterelamu Tallinnas Masti tänaval
		// ADDRESS START
		List<Address> p14addresses = new ArrayList<Address>();
		Address p14address = new Address();
		p14address.setCity("Tallinn");
		p14address.setStreet("Masti");
		p14address.setStreetType("tänav");
		p14address.setBuilding("15");
		p14addresses.add(p14address);
		p14.setAddresses(p14addresses);
		// ADDRESS END
		p14.setPlanningStartYear(2013);
		p14.setBuildingStartYear(2014);
		p14.setBuildingEndYear(2015);
		List<Person> p14architects = new ArrayList<Person>();
		p14architects.add(personKalleVellevoog);
		p14.setArchitects(p14architects);
		List<Person> p14contributors = new ArrayList<Person>();
		p14contributors.add(personMartinPrommik);
		p14.setContributors(p14contributors);
		p14.setSizeQuantity(600f);
		p14.setApartmentsQuantity(4);
		p14.setProjectGroup(pg2);
		p14.setImagesRootFolder("Korterelamu_Tallinn_Masti");
		p14.setImagesArray(p14.getProjectGroup().getImagesRootFolder() + "/" + p14.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","Joonis (1. korrus).jpg","Joonis (2. korrus).jpg"});
		session.save(p14);
		
		Project p15 = new Project();
		p15.setName("rekonstruksioon.tööstuse.54a"); // Tööstuse tn 54a hoone rekonstruktsioon
		// ADDRESS START
		List<Address> p15addresses = new ArrayList<Address>();
		Address p15address = new Address();
		p15address.setCity("Tallinn");
		p15address.setStreet("Tööstuse");
		p15address.setStreetType("tänav");
		p15address.setBuilding("54a");
		p15addresses.add(p15address);
		p15.setAddresses(p15addresses);
		// ADDRESS END
		p15.setPlanningStartYear(2013);
		p15.setPlanningEndYear(2014);
		p15.setBuildingStartYear(2014);
		p15.setBuildingEndYear(2015);
		List<Person> p15architects = new ArrayList<Person>();
		p15architects.add(personKalleVellevoog);
		p15.setArchitects(p15architects);
		List<Person> p15contributors = new ArrayList<Person>();
		p15contributors.add(personMartKadarik);
		p15contributors.add(personMartinPrommik);
		p15.setContributors(p15contributors);
		List<Person> p15lightsDesigners = new ArrayList<Person>();
		p15lightsDesigners.add(personMargusTriibmann);
		p15.setLightsDesigners(p15lightsDesigners);
		p15.setSizeQuantity(9400f);
		p15.setProjectGroup(pg2);
		p15.setImagesRootFolder("Rekonstruktsioon_Tallinn_Tööstuse_54a");
		p15.setImagesArray(p15.getProjectGroup().getImagesRootFolder() + "/" + p15.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg"});
		session.save(p15);
		
		Project p16 = new Project();
		p16.setName("kortermajad.tallinn.helme"); // Kortermajad Tallinnas Helme tänaval
		// ADDRESS START
		List<Address> p16addresses = new ArrayList<Address>();
		Address p16address = new Address();
		p16address.setCity("Tallinn");
		p16address.setStreet("Helme");
		p16address.setStreetType("tänav");
		p16addresses.add(p16address);
		p16.setAddresses(p16addresses);
		// ADDRESS END
		p16.setPlanningStartYear(2009);
		p16.setPlanningEndYear(2011);
		p16.setBuildingStartYear(2010);
		p16.setBuildingEndYear(2011);
		List<Person> p16architects = new ArrayList<Person>();
		p16architects.add(personKalleVellevoog);
		p16architects.add(personVelleKadalipp);
		p16.setArchitects(p16architects);
		List<Person> p16contributors = new ArrayList<Person>();
		p16contributors.add(personAndrusAndrejev);
		p16.setContributors(p16contributors);
		p16.setSizeQuantity(8960f);
		p16.setApartmentsQuantity(98);
		p16.setProjectGroup(pg2);
		p16.setImagesRootFolder("Kortermajad_Tallinn_Helme");
		p16.setImagesArray(p16.getProjectGroup().getImagesRootFolder() + "/" + p16.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","Joonis (1. korrus).jpg","Joonis (2. korrus).jpg"});
		session.save(p16);
		
		Project p17 = new Project();
		p17.setName("rekonstruktsioon.kortermaja.suur-patarei.16"); // Kortermaja rekonstruktsioon Suur-Patarei 16, Tallinn
		// ADDRESS START
		List<Address> p17addresses = new ArrayList<Address>();
		Address p17address = new Address();
		p17address.setCity("Tallinn");
		p17address.setStreet("Suur-Patarei");
		p17address.setStreetType("tänav");
		p17address.setBuilding("16");
		p17addresses.add(p17address);
		p17.setAddresses(p17addresses);
		// ADDRESS END
		p17.setPlanningStartYear(1997);
		p17.setPlanningEndYear(1998);
		p17.setBuildingStartYear(1998);
		List<Person> p17architects = new ArrayList<Person>();
		p17architects.add(personKalleVellevoog);
		p17.setArchitects(p17architects);
		List<Person> p17contributors = new ArrayList<Person>();
		p17contributors.add(personAndrusAndrejev);
		p17.setContributors(p17contributors);
		p17.setSizeQuantity(989.9f);
		p17.setApartmentsQuantity(14);
		p17.setProjectGroup(pg2);
		p17.setImagesRootFolder("Rekonstruktioon_kortermaja_Suur-Patarei_16");
		p17.setImagesArray(p17.getProjectGroup().getImagesRootFolder() + "/" + p17.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","Joonis (asendiplaan).jpg","Joonis (plaan).jpg"});
		session.save(p17);
		
		Project p18 = new Project();
		p18.setName("äri.ja.eluhoone.jõhvi.narva.mnt.14"); // Äri- ja eluhoone Jõhvis Narva mnt 14
		// ADDRESS START
		List<Address> p18addresses = new ArrayList<Address>();
		Address p18address = new Address();
		p18address.setCity("Jõhvi");
		p18address.setStreet("Narva"); // tänav, maantee, põik
		p18address.setStreetType("maantee");
		p18address.setBuilding("14");
		p18addresses.add(p18address);
		p18.setAddresses(p18addresses);
		// ADDRESS END
		p18.setPlanningStartYear(2007);
		List<Person> p18architects = new ArrayList<Person>();
		p18architects.add(personKalleVellevoog);
		p18architects.add(personVelleKadalipp);
		p18.setArchitects(p18architects);
		List<Person> p18contributors = new ArrayList<Person>();
		p18contributors.add(personAndrusAndrejev);
		p18contributors.add(personMargusTamm);
		p18.setContributors(p18contributors);
		p18.setSizeQuantity(13200f);
		p18.setProjectGroup(pg2);
		p18.setImagesRootFolder("Äri-_ja_eluhoone_Jõhvis_Narva_mnt_14");
		p18.setImagesArray(p18.getProjectGroup().getImagesRootFolder() + "/" + p18.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","Joonis (1. korrus).jpg","Joonis (2. korrus).jpg","Joonis (3. korrus).jpg","Joonis (4. korrus).jpg","Joonis (kelder).jpg","Joonis (lõige).jpg"});
		session.save(p18);
		
		Project p19 = new Project();
		p19.setName("korterelamu.haapsalu.suur-liiva.15"); // Korterelamu Haapsalus Suur-Liiva tn 15
		// ADDRESS START
		List<Address> p19addresses = new ArrayList<Address>();
		Address p19address = new Address();
		p19address.setCity("Haapsalu");
		p19address.setStreet("Suur-Liiva"); // tänav, maantee, põik
		p19address.setStreetType("tänav");
		p19address.setBuilding("15");
		p19addresses.add(p19address);
		p19.setAddresses(p19addresses);
		// ADDRESS END
		p19.setPlanningStartYear(2005);
		p19.setBuildingStartYear(2006);
		List<Person> p19architects = new ArrayList<Person>();
		p19architects.add(personKalleVellevoog);
		p19.setArchitects(p19architects);
		List<Person> p19contributors = new ArrayList<Person>();
		p19contributors.add(personAndrusAndrejev);
		p19.setContributors(p19contributors);
		p19.setSizeQuantity(2870f);
		p19.setApartmentsQuantity(35);
		p19.setProjectGroup(pg2);
		p19.setImagesRootFolder("Korterelamu_Haapsalu_Suur-Liiva_15");
		p19.setImagesArray(p19.getProjectGroup().getImagesRootFolder() + "/" + p19.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg","10.jpg","Joonis (1. korrus).jpg","Joonis (2. korrus).jpg","Joonis (3. korrus).jpg","Joonis (asendiplaan).jpg"});
		session.save(p19);
		
		Project p20 = new Project();
		p20.setName("büroohoone.tallinn.metalli");
		p20.setPlanningStartYear(2012);
		p20.setPlanningEndYear(2013);
		p20.setBuildingStartYear(2014);
		List<Person> p20architects = new ArrayList<Person>();
		p20architects.add(personKalleVellevoog);
		p20.setArchitects(p20architects);
		List<Person> p20contributors = new ArrayList<Person>();
		p20contributors.add(personAndrusAndrejev);
		p20contributors.add(personMartinPrommik);
		p20.setContributors(p20contributors);
		p20.setSizeQuantity(5133f);
		p20.setProjectGroup(pg2);
		p20.setImagesRootFolder("Büroohoone_Tallinn_Metalli");
		p20.setImagesArray(p20.getProjectGroup().getImagesRootFolder() + "/" + p20.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","Joonis (1. korrus).png","Joonis (2. korrus).png","Joonis (6. korrus).png","Joonis (keldrikorrus).png"});
		session.save(p20);
		
		Project p21 = new Project();
		p21.setName("büroohoone.tallinn.pärnu.mnt.153"); // Büroohoone Tallinnas Pärnu mnt 153
		// ADDRESS START
		List<Address> p21addresses = new ArrayList<Address>();
		Address p21address = new Address();
		p21address.setCity("Tallinn");
		p21address.setStreet("Pärnu"); // tänav, maantee, põik
		p21address.setStreetType("maantee");
		p21address.setBuilding("153");
		p21addresses.add(p21address);
		p21.setAddresses(p21addresses);
		// ADDRESS END
		p21.setPlanningStartYear(2005);
		p21.setBuildingStartYear(2006);
		List<Person> p21architects = new ArrayList<Person>();
		p21architects.add(personKalleVellevoog);
		p21architects.add(personLailaPodra);
		p21.setArchitects(p21architects);
		p21.setSizeQuantity(2121f);
		p21.setProjectGroup(pg2);
		p21.setImagesRootFolder("Büroohoone_Tallinn_Pärnu_mnt_153");
		p21.setImagesArray(p21.getProjectGroup().getImagesRootFolder() + "/" + p21.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","Joonis (1. korrus).jpg","Joonis (3. korrus).jpg","Joonis (asendiplaan).jpg","Joonis (katuse plaan).jpg","Joonis (keldrikorrus).jpg"});
		session.save(p21);
		
		Project p22 = new Project();
		p22.setName("korterelamu.tallinn.kaupmehe.6"); // Korterelamu Tallinnas Kaupmehe tn 6
		// ADDRESS START
		List<Address> p22addresses = new ArrayList<Address>();
		Address p22address = new Address();
		p22address.setCity("Tallinn");
		p22address.setStreet("Kaupmehe"); // tänav, maantee, põik
		p22address.setStreetType("tänav");
		p22address.setBuilding("6");
		p22addresses.add(p22address);
		p22.setAddresses(p22addresses);
		// ADDRESS END
		p22.setPlanningStartYear(2001);
		p22.setPlanningEndYear(2002);
		p22.setBuildingStartYear(2003);
		// ARCHITECTS
		List<Person> p22architects = new ArrayList<Person>();
		p22architects.add(personKalleVellevoog);
		p22architects.add(personVelleKadalipp);
		p22.setArchitects(p22architects);
		// CONTRIBUTORS
		List<Person> p22contributors = new ArrayList<Person>();
		p22contributors.add(personAndrusAndrejev);
		p22contributors.add(personMargusTamm);
		p22.setContributors(p22contributors);
		p22.setSizeQuantity(11990f);
		p22.setApartmentsQuantity(113);
		p22.setProjectGroup(pg2);
		p22.setImagesRootFolder("Korterelamu_Tallinn_Kaupmehe_6");
		p22.setImagesArray(p22.getProjectGroup().getImagesRootFolder() + "/" + p22.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","Joonis (asendiplaan).jpg","Joonis (korruseplaan).jpg"});
		session.save(p22);
		
		Project p23 = new Project();
		p23.setName("büroohoone.tallinn.katusepapi.8"); // Büroohoone Tallinnas Katusepapi tn 8
		// ADDRESS START
		List<Address> p23addresses = new ArrayList<Address>();
		Address p23address = new Address();
		p23address.setCity("Tallinn");
		p23address.setStreet("Katusepapi");
		p23address.setStreetType("tänav");
		p23address.setBuilding("8");
		p23addresses.add(p23address);
		p23.setAddresses(p23addresses);
		// ADDRESS END
		p23.setPlanningStartYear(2005);
		p23.setBuildingStartYear(2006);
		List<Person> p23architects = new ArrayList<Person>();
		p23architects.add(personVelleKadalipp);
		p23.setArchitects(p23architects);
		List<Person> p23contributors = new ArrayList<Person>();
		p23contributors.add(personMartinPrommik);
		p23.setContributors(p23contributors);
		p23.setProjectGroup(pg2);
		p23.setImagesRootFolder("Büroohoone_Tallinn_Katusepapi_8");
		p23.setImagesArray(p23.getProjectGroup().getImagesRootFolder() + "/" + p23.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","Joonis (korruseplaan).jpg"});
		session.save(p23);
		
		Project p24 = new Project();
		p24.setName("korterelamu.pärnu.papli.34"); // Korterelamu Pärnus Papli tn 34
		// ADDRESS START
		List<Address> p24addresses = new ArrayList<Address>();
		Address p24address = new Address();
		p24address.setCity("Pärnu");
		p24address.setStreet("Papli");
		p24address.setStreetType("tänav");
		p24address.setBuilding("34");
		p24addresses.add(p24address);
		p24.setAddresses(p24addresses);
		// ADDRESS END
		p24.setPlanningStartYear(2003);
		p24.setBuildingStartYear(2004);
		List<Person> p24architects = new ArrayList<Person>();
		p24architects.add(personKalleVellevoog);
		p24.setArchitects(p24architects);
		List<Person> p24contributors = new ArrayList<Person>();
		p24contributors.add(personAndrusAndrejev);
		p24.setContributors(p24contributors);
		p24.setSizeQuantity(517f);
		p24.setApartmentsQuantity(8);
		p24.setProjectGroup(pg2);
		p24.setImagesRootFolder("Korterelamu_Pärnu_Papli_34");
		p24.setImagesArray(p24.getProjectGroup().getImagesRootFolder() + "/" + p24.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","Joonis (1. korrus).jpg","Joonis (2. korrus).jpg"});
		session.save(p24);
		
		Project p25 = new Project();
		p25.setName("kortermaja.ristiku.33a"); // Kortermaja Ristiku tänaval
		// ADDRESS START
		List<Address> p25addresses = new ArrayList<Address>();
		Address p25address = new Address();
		p25address.setCity("Tallinn");
		p25address.setStreet("Ristiku");
		p25address.setStreetType("tänav");
		p25address.setBuilding("33A");
		p25addresses.add(p25address);
		p25.setAddresses(p25addresses);
		// ADDRESS END
		p25.setPlanningStartYear(2007);
		List<Person> p25architects = new ArrayList<Person>();
		p25architects.add(personKalleVellevoog);
		p25.setArchitects(p25architects);
		List<Person> p25contributors = new ArrayList<Person>();
		p25contributors.add(personMartinPrommik);
		p25.setContributors(p25contributors);
		p25.setSizeQuantity(472f);
		p25.setApartmentsQuantity(6);
		p25.setProjectGroup(pg2);
		p25.setImagesRootFolder("Kortermaja_Ristiku");
		p25.setImagesArray(p25.getProjectGroup().getImagesRootFolder() + "/" + p25.getImagesRootFolder(), new String[]{"1.jpg","2.jpg"});
		session.save(p25);
		
		Project p26 = new Project();
		p26.setName("korterelamu.tallinn.luige.3"); // Korterelamu Tallinnas Luige tn 3
		// ADDRESS START
		List<Address> p26addresses = new ArrayList<Address>();
		Address p26address = new Address();
		p26address.setCity("Tallinn");
		p26address.setStreet("Luige");
		p26address.setStreetType("tänav");
		p26address.setBuilding("3");
		p26addresses.add(p26address);
		p26.setAddresses(p26addresses);
		// ADDRESS END
		p26.setPlanningStartYear(2005);
		p26.setPlanningEndYear(2006);
		List<Person> p26architects = new ArrayList<Person>();
		p26architects.add(personKalleVellevoog);
		p26architects.add(personVelleKadalipp);
		p26.setArchitects(p26architects);
		List<Person> p26contributors = new ArrayList<Person>();
		p26contributors.add(personAndrusAndrejev);
		p26.setContributors(p26contributors);
		p26.setSizeQuantity(6400f);
		p26.setApartmentsQuantity(48);
		p26.setProjectGroup(pg2);
		p26.setImagesRootFolder("Korterelamu_Tallinn_Luige_3");
		p26.setImagesArray(p26.getProjectGroup().getImagesRootFolder() + "/" + p26.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","Joonis (asendiplaan).jpg"});
		session.save(p26);
		
		Project p27 = new Project();
		p27.setName("korterelamu.tallinn.kaupmehe.12"); // Korterelamu Tallinnas Kaupmehe tn 12
		// ADDRESS START
		List<Address> p27addresses = new ArrayList<Address>();
		Address p27address = new Address();
		p27address.setCity("Tallinn");
		p27address.setStreet("Kaupmehe");
		p27address.setStreetType("tänav");
		p27address.setBuilding("12");
		p27addresses.add(p27address);
		p27.setAddresses(p27addresses);
		// ADDRESS END
		p27.setPlanningStartYear(2005);
		p27.setPlanningEndYear(2006);
		p27.setBuildingStartYear(2006);
		List<Person> p27architects = new ArrayList<Person>();
		p27architects.add(personVelleKadalipp);
		p27.setArchitects(p27architects);
		List<Person> p27contributors = new ArrayList<Person>();
		p27contributors.add(personAndrusAndrejev);
		p27.setContributors(p27contributors);
		p27.setSizeQuantity(1717.7f);
		p27.setApartmentsQuantity(17);
		p27.setProjectGroup(pg2);
		p27.setImagesRootFolder("Korterelamu_Tallinn_Kaupmehe_12");
		p27.setImagesArray(p27.getProjectGroup().getImagesRootFolder() + "/" + p27.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","Joonis (korruseplaan).jpg"});
		session.save(p27);
		
		// KONKURSIPROJEKTID:
		
		Project p28 = new Project();
		p28.setName("narva.linnus.võistlus"); // Narva linnuse arhitektuurivõistlus
		// narva linnuse aadress siia
		p28.setPlanningStartYear(2015);
		List<Person> p28architects = new ArrayList<Person>();
		p28architects.add(personKalleVellevoog);
		p28architects.add(personTiiuTruus);
		p28architects.add(personLidiaZarudnaja);
		p28architects.add(personMartinPrommik);
		p28.setArchitects(p28architects);
		p28.setSizeQuantity(17000f); //(1.7f); // 1.7ha not square m !!!
		p28.setArchitects(p28architects);
		p28.setPrizeComment("Konkursitöö I preemia");
		p28.setProjectGroup(pg3);
		p28.setImagesRootFolder("Narva_Linnus");
		p28.setImagesArray(p28.getProjectGroup().getImagesRootFolder() + "/" + p28.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","Joonis (asendiplaan).jpg","Joonis (linnuse plaanid).jpg"});
		session.save(p28);
		
		Project p29 = new Project();
		p29.setName("narva.joaoru.konkurss"); // Narva Joaoru puhkeala arhitektuurne ideekonkurss
		p29.setPlanningStartYear(2009);
		List<Person> p29architects = new ArrayList<Person>();
		p29architects.add(personKalleVellevoog);
		p29architects.add(personTiiuTruus);
		p29architects.add(personMartinPrommik);
		p29.setArchitects(p29architects);
		p29.setSizeQuantity(170000f); // 17ha
		p29.setPrizeComment("Konkursitöö I preemia");
		p29.setProjectGroup(pg3);
		p29.setImagesRootFolder("Narva_Joaoru_Puhkeala");
		p29.setImagesArray(p29.getProjectGroup().getImagesRootFolder() + "/" + p29.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","Joonis (asendiplaan).jpg","Joonis (rannahoone).jpg","Joonis (valgustuse plaan).jpg"});
		session.save(p29);
		
		Project p30 = new Project();
		p30.setName("eesti.saatkond.peking"); // Eesti saatkond Pekingis
		p30.setPlanningStartYear(2008);
		List<Person> p30architects = new ArrayList<Person>();
		p30architects.add(personKalleVellevoog);
		p30architects.add(personVelleKadalipp);
		p30architects.add(personTiiuTruus);
		p30architects.add(personMartinPrommik);
		p30.setArchitects(p30architects);
		p30.setPrizeComment("Konkursitöö III preemia");
		p30.setProjectGroup(pg3);
		p30.setImagesRootFolder("Eesti_saatkond_Pekingis");
		p30.setImagesArray(p30.getProjectGroup().getImagesRootFolder() + "/" + p30.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg","10.jpg","11.jpg","12.jpg","Joonis (1. korrus).jpg","Joonis (2. korrus).jpg","Joonis (3. korrus).jpg","Joonis (4. korrus).jpg","Joonis (keldrikorrus).jpg", "Joonis (lõiked).jpg", "Joonis (vaated I).jpg", "Joonis (vaated II).jpg"});
		session.save(p30);
		
		Project p31 = new Project();
		p31.setName("rakvere.pauluse.kirik"); // Rakvere Pauluse kiriku rekonstrueerimise arhitektuurivõistlus
		p31.setPlanningStartYear(2008);
		List<Person> p31architects = new ArrayList<Person>();
		p31architects.add(personKalleVellevoog);
		p31architects.add(personVelleKadalipp);
		p31architects.add(personTiiuTruus);
		p31architects.add(personMartinPrommik);
		p31.setArchitects(p31architects);
		p31.setProjectGroup(pg3);
		p31.setImagesRootFolder("Rakvere_Pauluse_kirik");
		p31.setImagesArray(p31.getProjectGroup().getImagesRootFolder() + "/" + p31.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg","Joonis (1. korrus).jpg","Joonis (2. korrus).jpg","Joonis (3. korrus).jpg","Joonis (asendiplaan).jpg","Joonis (keldrikorrus).jpg", "Joonis (lõige A-A).jpg", "Joonis (lõige B-B).jpg", "Joonis (lõige C-C).jpg", "Joonis (lõige D-D).jpg", "Joonis (vaade 1).jpg", "Joonis (vaade 2).jpg", "Joonis (vaade 3).jpg", "Joonis (vaade 4).jpg"});
		session.save(p31);
		
		Project p32 = new Project();
		p32.setName("büroohoone.tallinn.võistlus"); // Büroohoone Tallinnas
		p32.setPlanningStartYear(2005);
		List<Person> p32architects = new ArrayList<Person>();
		p32architects.add(personKalleVellevoog);
		p32architects.add(personVelleKadalipp);
		p32.setArchitects(p32architects);
		p32.setProjectGroup(pg3);
		p32.setImagesRootFolder("Büroohoone_Tallinn");
		p32.setImagesArray(p32.getProjectGroup().getImagesRootFolder() + "/" + p32.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","Joonis (makett 1).jpg","Joonis (makett 2).jpg", "Joonis (makett 3).jpg"});
		session.save(p32);
		
		Project p33 = new Project();
		p33.setName("eesti.maaülikool.võistlus"); // Eesti Maaülikooli juurdeehitise arhitektuurivõistlus
		p33.setPlanningStartYear(2008);
		List<Person> p33architects = new ArrayList<Person>();
		p33architects.add(personKalleVellevoog);
		p33architects.add(personVelleKadalipp);
		p33architects.add(personTiiuTruus);
		p33architects.add(personMartinPrommik);
		p33.setArchitects(p33architects);
		p33.setProjectGroup(pg3);
		p33.setImagesRootFolder("Maaülikool");
		p33.setImagesArray(p33.getProjectGroup().getImagesRootFolder() + "/" + p33.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg"});
		session.save(p33);
		
		Project p34 = new Project();
		p34.setName("g4s.office"); // AS G4S büroohoone
		p34.setPlanningStartYear(2011);
		List<Person> p34architects = new ArrayList<Person>();
		p34architects.add(personKalleVellevoog);
		p34architects.add(personVelleKadalipp);
		p34.setArchitects(p34architects);
		List<Person> p34contributors = new ArrayList<Person>();
		p34contributors.add(personMartinPrommik);
		p34.setContributors(p34contributors);
		p34.setSizeQuantity(11489f);
		p34.setProjectGroup(pg3);
		p34.setImagesRootFolder("G4S");
		p34.setImagesArray(p34.getProjectGroup().getImagesRootFolder() + "/" + p34.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","Joonis (asendiplaan).jpg"});
		session.save(p34);
		
		Project p35 = new Project();
		p35.setName("tartu.raamatukogu.ja.kunstimuuseum"); // Tartu raamatukogu ja kunstimuuseumi arhitektuurivõistlus
		p35.setPlanningStartYear(2011);
		List<Person> p35architects = new ArrayList<Person>();
		p35architects.add(personKalleVellevoog);
		p35architects.add(personMartinPrommik);
		p35architects.add(personTiiuTruus);
		p35.setArchitects(p35architects);
		p35.setSizeQuantity(18367f);
		p35.setProjectGroup(pg3);
		p35.setImagesRootFolder("Tartu_raamatukogu_ja_kunstimuuseum");
		p35.setImagesArray(p35.getProjectGroup().getImagesRootFolder() + "/" + p35.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","Joonis (1. korrus).jpg","Joonis (2. korrus).jpg","Joonis (3. korrus).jpg","Joonis (4. korrus).jpg","Joonis (aksonomeetriline vaade 1).jpg","Joonis (aksonomeetriline vaade 2).jpg","Joonis (aksonomeetrilised skeemid).jpg", "Joonis (keldrikorrus).jpg","Joonis (lõige A-A).jpg", "Joonis (lõige B-B).jpg", "Joonis (lõige C-C).jpg", "Joonis (vaade).jpg"});
		session.save(p35);
		
		Project p36 = new Project();
		p36.setName("narva-jõesuu.hoonestuskava.vabaduse.72"); // Vabaduse tn. 72, Narva-Jõesuu. Hoonestuskava.
		p36.setPlanningStartYear(2008);
		List<Person> p36architects = new ArrayList<Person>();
		p36architects.add(personKalleVellevoog);
		p36architects.add(personVelleKadalipp);
		p36.setArchitects(p36architects);
		List<Person> p36interiorDesigners = new ArrayList<Person>();
		p36interiorDesigners.add(personTiiuTruus);
		p36.setInteriorDesigners(p36interiorDesigners);
		p36.setProjectGroup(pg4);
		p36.setImagesRootFolder("Narva-Jõesuu_Vabaduse_72");
		p36.setImagesArray(p36.getProjectGroup().getImagesRootFolder() + "/" + p36.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg"});
		session.save(p36);
		
		Project p37 = new Project();
		p37.setName("planeering.paldiski.mnt.50"); // Paldiski mnt. 50 mahuline planeering. Konkursitöö
		p37.setPlanningStartYear(2008);
		List<Person> p37architects = new ArrayList<Person>();
		p37architects.add(personKalleVellevoog);
		p37architects.add(personVelleKadalipp);
		p37.setArchitects(p37architects);
		List<Person> p37contributors = new ArrayList<Person>();
		p37contributors.add(personMartinPrommik);
		p37contributors.add(personAndrusAndrejev);
		p37.setContributors(p37contributors);
		p37.setProjectGroup(pg4);
		p37.setImagesRootFolder("Tallinn_Paldiski_mnt_50");
		p37.setImagesArray(p37.getProjectGroup().getImagesRootFolder() + "/" + p37.getImagesRootFolder(), new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","Joonis (asendiplaan).jpg"});
		session.save(p37);
		
		// NÄITUSED: eraldi model luua? http://www.jvr.ee/#et/projektid
		
		//Project p38 = new Project();
		//p38.setName("Eesti ekspositsioon 12. Veneetsia Arhitektuuribiennaalil");
		// Veneetsia Arhitektuuribiennaal  29.08.-21.11.2010
		// Autorid: Kalle Vellevoog, Tiiu Truus, Martin Pedanik, Karen Jagodin
		// Makett Näitusel: Mihkel Tüür, Ott Kadarik, Reedik Poopuu, Märten Tuuling, Aivar Hanniotti

		
		
		
		transaction.commit();
		session.close();
		log.info("[insertSampleDataProjects] END");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void insertSampleDataProjectGroups(){
//		log.info("[insertSampleDataProjectGroups] START");
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		
//
//		
//		transaction.commit();
//		session.close();
//		log.info("[insertSampleDataProjects] END");
//	}
	
	

//	public void insertSampleDataSectors(){
//		log.info("[insertSampleDataSectors] START");
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		
//		// ATM LEVEL 0 and LEVEL 1 added
//		//System.out.println("adding manufacturing");
//		Sector s_lvl0_0 = new Sector("Manufacturing");
//		//session.save(s_lvl0_0);
//		
//		//System.out.println("adding Construction mat");
//		Sector s_lvl1_group0_0 = new Sector("Construction materials");
//		//System.out.println("adding Electronics and opt");
//		Sector s_lvl1_group0_1 = new Sector("Electronics and Optics");
//		//System.out.println("adding food and beverages");
//		Sector s_lvl1_group0_2 = new Sector("Food and Beverage");
//		//System.out.println("adding Furniture");
//		Sector s_lvl1_group0_3 = new Sector("Furniture");
//		Sector s_lvl1_group0_4 = new Sector("Machinery");
//		Sector s_lvl1_group0_5 = new Sector("Metalworking");
//		Sector s_lvl1_group0_6 = new Sector("Plastic and Rubber");
//		Sector s_lvl1_group0_7 = new Sector("Printing");
//		Sector s_lvl1_group0_8 = new Sector("Textile and Clothing");
//		Sector s_lvl1_group0_9 = new Sector("Wood");
//		//session.save(s_lvl1_3);
//
////		Set<Sector> set_lvl0_0 = new HashSet<Sector>();
//		SortedSet<Sector> set_lvl0_group0 = new TreeSet<Sector>();
//		set_lvl0_group0.add(s_lvl1_group0_0);
//		set_lvl0_group0.add(s_lvl1_group0_1);
//		set_lvl0_group0.add(s_lvl1_group0_2);
//		set_lvl0_group0.add(s_lvl1_group0_3);
//		set_lvl0_group0.add(s_lvl1_group0_4);
//		set_lvl0_group0.add(s_lvl1_group0_5);
//		set_lvl0_group0.add(s_lvl1_group0_6);
//		set_lvl0_group0.add(s_lvl1_group0_7);
//		set_lvl0_group0.add(s_lvl1_group0_8);
//		set_lvl0_group0.add(s_lvl1_group0_9);
//		s_lvl0_0.setChild_sectors(set_lvl0_group0);
//		session.save(s_lvl0_0);
//		
//		Sector s_lvl0_1 = new Sector("Other");
//		
//		Sector s_lvl1_group1_0 = new Sector("Creative industries");
//		Sector s_lvl1_group1_1 = new Sector("Energy technology");
//		Sector s_lvl1_group1_2 = new Sector("Environment");
//		
////		Set<Sector> set_lvl0_1 = new HashSet<Sector>();
//		SortedSet<Sector> set_lvl0_group1 = new TreeSet<Sector>();
//		set_lvl0_group1.add(s_lvl1_group1_0);
//		set_lvl0_group1.add(s_lvl1_group1_1);
//		set_lvl0_group1.add(s_lvl1_group1_2);
//		s_lvl0_1.setChild_sectors(set_lvl0_group1);
//		session.save(s_lvl0_1);
//		
//		Sector s_lvl0_2 = new Sector("Service");
//		
//		Sector s_lvl1_group2_0 = new Sector("Business services");
//		Sector s_lvl1_group2_1 = new Sector("Engineering");
//		Sector s_lvl1_group2_2 = new Sector("Information Technology and Telecommunications");
//		Sector s_lvl1_group2_3 = new Sector("Tourism");
//		Sector s_lvl1_group2_4 = new Sector("Translation services");
//		Sector s_lvl1_group2_5 = new Sector("Transport and Logistics");
//
////		Set<Sector> set_lvl0_2 = new HashSet<Sector>();
//		SortedSet<Sector> set_lvl0_group2 = new TreeSet<Sector>();
//		set_lvl0_group2.add(s_lvl1_group2_0);
//		set_lvl0_group2.add(s_lvl1_group2_1);
//		set_lvl0_group2.add(s_lvl1_group2_2);
//		set_lvl0_group2.add(s_lvl1_group2_3);
//		set_lvl0_group2.add(s_lvl1_group2_4);
//		set_lvl0_group2.add(s_lvl1_group2_5);
//		s_lvl0_2.setChild_sectors(set_lvl0_group2);
//		session.save(s_lvl0_2);
//		
//		// lvl0 lvl1 LEVEL2 STUFF HERE // Sector s_lvl1_group0_2 = new Sector("Food and Beverage"); 
//		// Food and Beverage children:
//		
//		Sector s_lvl2_group0_0 = new Sector("Bakery & confectionery products");
//		Sector s_lvl2_group0_1 = new Sector("Beverages");
//		Sector s_lvl2_group0_2 = new Sector("Fish & fish products");
//		Sector s_lvl2_group0_3 = new Sector("Meat & meat products");
//		Sector s_lvl2_group0_4 = new Sector("Milk & dairy products");
//		Sector s_lvl2_group0_5 = new Sector("Other");
//		Sector s_lvl2_group0_6 = new Sector("Sweets & snack food");
//		SortedSet<Sector> set_lvl2_group0 = new TreeSet<Sector>();
//		set_lvl2_group0.add(s_lvl2_group0_0);
//		set_lvl2_group0.add(s_lvl2_group0_1);
//		set_lvl2_group0.add(s_lvl2_group0_2);
//		set_lvl2_group0.add(s_lvl2_group0_3);
//		set_lvl2_group0.add(s_lvl2_group0_4);
//		set_lvl2_group0.add(s_lvl2_group0_5);
//		set_lvl2_group0.add(s_lvl2_group0_6);
//		s_lvl1_group0_2.setChild_sectors(set_lvl2_group0);
//		session.save(s_lvl1_group0_2);
//		
//		// LEVEL2 // Sector s_lvl1_group0_3 = new Sector("Furniture");
//		// creating new sectors that don't exist yet but belong to furniture
//		Sector s_lvl2_group1_0 = new Sector("Bathroom/sauna"); 
//		Sector s_lvl2_group1_1 = new Sector("Bedroom");
//		Sector s_lvl2_group1_2 = new Sector("Children's room");
//		Sector s_lvl2_group1_3 = new Sector("Kitchen");
//		Sector s_lvl2_group1_4 = new Sector("Living room");
//		Sector s_lvl2_group1_5 = new Sector("Office");
//		Sector s_lvl2_group1_6 = new Sector("Other (Furniture)");
//		Sector s_lvl2_group1_7 = new Sector("Outdoor");
//		Sector s_lvl2_group1_8 = new Sector("Project furniture");
//		SortedSet<Sector> set_lvl2_group1 = new TreeSet<Sector>(); // creating new collection for furniture (level2)
//		set_lvl2_group1.add(s_lvl2_group1_0); // adding children to sorted collection
//		set_lvl2_group1.add(s_lvl2_group1_1);
//		set_lvl2_group1.add(s_lvl2_group1_2);
//		set_lvl2_group1.add(s_lvl2_group1_3);
//		set_lvl2_group1.add(s_lvl2_group1_4);
//		set_lvl2_group1.add(s_lvl2_group1_5);
//		set_lvl2_group1.add(s_lvl2_group1_6);
//		set_lvl2_group1.add(s_lvl2_group1_7);
//		set_lvl2_group1.add(s_lvl2_group1_8);
//		s_lvl1_group0_3.setChild_sectors(set_lvl2_group1); // Adding children to furniture
//		session.save(s_lvl1_group0_3); // Saving furniture children
//		
//		// LEVEL 2 // Sector s_lvl1_group0_4 = new Sector("Machinery");
//		Sector s_lvl2_group2_0 = new Sector("Machinery components"); 
//		Sector s_lvl2_group2_1 = new Sector("Machinery equipment/tools");
//		Sector s_lvl2_group2_2 = new Sector("Manufacture of machinery");
//		Sector s_lvl2_group2_3 = new Sector("Maritime");
//		Sector s_lvl2_group2_4 = new Sector("Metal structures");
//		Sector s_lvl2_group2_5 = new Sector("Other");
//		Sector s_lvl2_group2_6 = new Sector("Repair and maintenance service");
//		SortedSet<Sector> set_lvl2_group2 = new TreeSet<Sector>();
//		set_lvl2_group2.add(s_lvl2_group2_0);
//		set_lvl2_group2.add(s_lvl2_group2_1);
//		set_lvl2_group2.add(s_lvl2_group2_2);
//		set_lvl2_group2.add(s_lvl2_group2_3);
//		set_lvl2_group2.add(s_lvl2_group2_4);
//		set_lvl2_group2.add(s_lvl2_group2_5);
//		set_lvl2_group2.add(s_lvl2_group2_6);
//		s_lvl1_group0_4.setChild_sectors(set_lvl2_group2);
//		session.save(s_lvl1_group0_4);
//		
//		// LEVEL 3 // Sector s_lvl2_group2_3 = new Sector("Maritime");
//		Sector s_lvl3_group0_0 = new Sector("Aluminium and steel workboats"); 
//		Sector s_lvl3_group0_1 = new Sector("Boat/Yacht building");
//		Sector s_lvl3_group0_2 = new Sector("Ship repair and conversion");
//		SortedSet<Sector> set_lvl3_group0 = new TreeSet<Sector>();
//		set_lvl3_group0.add(s_lvl3_group0_0);
//		set_lvl3_group0.add(s_lvl3_group0_1);
//		set_lvl3_group0.add(s_lvl3_group0_2);
//		s_lvl2_group2_3.setChild_sectors(set_lvl3_group0);
//		session.save(s_lvl2_group2_3);
//		
//		// LEVEL 2 // Sector s_lvl1_group0_5 = new Sector("Metalworking");
//		Sector s_lvl2_group3_0 = new Sector("Construction of metal structures");
//		Sector s_lvl2_group3_1 = new Sector("Houses and buildings");
//		Sector s_lvl2_group3_2 = new Sector("Metal products");
//		Sector s_lvl2_group3_3 = new Sector("Metal works");
//		SortedSet<Sector> set_lvl2_group3 = new TreeSet<Sector>();
//		set_lvl2_group3.add(s_lvl2_group3_0);
//		set_lvl2_group3.add(s_lvl2_group3_1);
//		set_lvl2_group3.add(s_lvl2_group3_2);
//		set_lvl2_group3.add(s_lvl2_group3_3);
//		s_lvl1_group0_5.setChild_sectors(set_lvl2_group3);
//		session.save(s_lvl1_group0_5);
//		
//		// LEVEL 3 // Sector s_lvl2_group3_3 = new Sector("Metal works");
//		Sector s_lvl3_group1_0 = new Sector("CNC-machining");
//		Sector s_lvl3_group1_1 = new Sector("Forgings, Fasteners");
//		Sector s_lvl3_group1_2 = new Sector("Gas, Plasma, Laser cutting");
//		Sector s_lvl3_group1_3 = new Sector("MIG, TIG, Aluminium welding");
//		SortedSet<Sector> set_lvl3_group1 = new TreeSet<Sector>();
//		set_lvl3_group1.add(s_lvl3_group1_0);
//		set_lvl3_group1.add(s_lvl3_group1_1);
//		set_lvl3_group1.add(s_lvl3_group1_2);
//		set_lvl3_group1.add(s_lvl3_group1_3);
//		s_lvl2_group3_3.setChild_sectors(set_lvl3_group1);
//		session.save(s_lvl2_group3_3);
//		
//		// LEVEL 2 // Sector s_lvl1_group0_6 = new Sector("Plastic and Rubber");
//		Sector s_lvl2_group4_0 = new Sector("Packaging");
//		Sector s_lvl2_group4_1 = new Sector("Plastic goods");
//		Sector s_lvl2_group4_2 = new Sector("Plastic processing technology");
//		Sector s_lvl2_group4_3 = new Sector("Plastic profiles");
//		SortedSet<Sector> set_lvl2_group4 = new TreeSet<Sector>();
//		set_lvl2_group4.add(s_lvl2_group4_0);
//		set_lvl2_group4.add(s_lvl2_group4_1);
//		set_lvl2_group4.add(s_lvl2_group4_2);
//		set_lvl2_group4.add(s_lvl2_group4_3);
//		s_lvl1_group0_6.setChild_sectors(set_lvl2_group4);
//		session.save(s_lvl1_group0_6);
//		
//		// LEVEL 3 // Sector s_lvl2_group4_2 = new Sector("Plastic processing technology");
//		Sector s_lvl3_group2_0 = new Sector("Blowing");
//		Sector s_lvl3_group2_1 = new Sector("Moulding");
//		Sector s_lvl3_group2_2 = new Sector("Plastics welding and processing");
//		SortedSet<Sector> set_lvl3_group2 = new TreeSet<Sector>();
//		set_lvl3_group2.add(s_lvl3_group2_0);
//		set_lvl3_group2.add(s_lvl3_group2_1);
//		set_lvl3_group2.add(s_lvl3_group2_2);
//		s_lvl2_group4_2.setChild_sectors(set_lvl3_group2);
//		session.save(s_lvl2_group4_2);
//		
//		// LEVEL 2 // Sector s_lvl1_group0_7 = new Sector("Printing");
//		Sector s_lvl2_group5_0 = new Sector("Advertising");
//		Sector s_lvl2_group5_1 = new Sector("Book/Periodicals printing");
//		Sector s_lvl2_group5_2 = new Sector("Labelling and packaging printing");
//		SortedSet<Sector> set_lvl2_group5 = new TreeSet<Sector>();
//		set_lvl2_group5.add(s_lvl2_group5_0);
//		set_lvl2_group5.add(s_lvl2_group5_1);
//		set_lvl2_group5.add(s_lvl2_group5_2);
//		s_lvl1_group0_7.setChild_sectors(set_lvl2_group5);
//		session.save(s_lvl1_group0_7);
//		
//		// LEVEL 2 // Sector s_lvl1_group0_8 = new Sector("Textile and Clothing");
//		Sector s_lvl2_group6_0 = new Sector("Clothing");
//		Sector s_lvl2_group6_1 = new Sector("Textile");
//		SortedSet<Sector> set_lvl2_group6 = new TreeSet<Sector>();
//		set_lvl2_group6.add(s_lvl2_group6_0);
//		set_lvl2_group6.add(s_lvl2_group6_1);
//		s_lvl1_group0_8.setChild_sectors(set_lvl2_group6);
//		session.save(s_lvl1_group0_8);
//		
//		// LEVEL 2 // Sector s_lvl1_group0_9 = new Sector("Wood");
//		Sector s_lvl2_group7_0 = new Sector("Other (Wood)");
//		Sector s_lvl2_group7_1 = new Sector("Wooden building materials");
//		Sector s_lvl2_group7_2 = new Sector("Wooden houses");
//		SortedSet<Sector> set_lvl2_group7 = new TreeSet<Sector>();
//		set_lvl2_group7.add(s_lvl2_group7_0);
//		set_lvl2_group7.add(s_lvl2_group7_1);
//		set_lvl2_group7.add(s_lvl2_group7_2);
//		s_lvl1_group0_9.setChild_sectors(set_lvl2_group7);
//		session.save(s_lvl1_group0_9);
//		
//		// LEVEL 3 // Sector s_lvl1_group2_2 = new Sector("Information Technology and Telecommunications");
//		Sector s_lvl3_group3_0 = new Sector("Data processing, Web portals, E-marketing");
//		Sector s_lvl3_group3_1 = new Sector("Programming, Consultancy");
//		Sector s_lvl3_group3_2 = new Sector("Software, Hardware");
//		Sector s_lvl3_group3_3 = new Sector("Telecommunications");
//		SortedSet<Sector> set_lvl3_group3 = new TreeSet<Sector>();
//		set_lvl3_group3.add(s_lvl3_group3_0);
//		set_lvl3_group3.add(s_lvl3_group3_1);
//		set_lvl3_group3.add(s_lvl3_group3_2);
//		set_lvl3_group3.add(s_lvl3_group3_3);
//		s_lvl1_group2_2.setChild_sectors(set_lvl3_group3);
//		session.save(s_lvl1_group2_2);
//		
//		// LEVEL 3 // Sector s_lvl1_group2_5 = new Sector("Transport and Logistics");
//		Sector s_lvl3_group4_0 = new Sector("Air");
//		Sector s_lvl3_group4_1 = new Sector("Rail");
//		Sector s_lvl3_group4_2 = new Sector("Road");
//		Sector s_lvl3_group4_3 = new Sector("Water");
//		SortedSet<Sector> set_lvl3_group4 = new TreeSet<Sector>();
//		set_lvl3_group4.add(s_lvl3_group4_0);
//		set_lvl3_group4.add(s_lvl3_group4_1);
//		set_lvl3_group4.add(s_lvl3_group4_2);
//		set_lvl3_group4.add(s_lvl3_group4_3);
//		s_lvl1_group2_5.setChild_sectors(set_lvl3_group4);
//		session.save(s_lvl1_group2_5);
//		
//		transaction.commit(); // session.getTransaction().commit();
//		session.close();
//		log.info("[insertSampleDataSectors] END");
//	}
}



















//protected void setUp() throws Exception {
//	public void setUp() throws Exception {
//		System.out.println("sessionfactory is atm " + sessionFactory);
//		// A SessionFactory is set up once for an application!
//		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//				.configure() // configures settings from hibernate.cfg.xml
//				.build();
//		try {
//			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
//		}
//		catch (Exception e) {
//			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//			// so destroy it manually.
//			StandardServiceRegistryBuilder.destroy( registry );
//		}
//		System.out.println("sessionfactory is now " + sessionFactory);
//		
//		sessionFactory = HibernateUtil.getSessionFactory();
//		
//		System.out.println("sessionfactory is now 2 " + sessionFactory);
//	}

//	public void initFactory(){
//		System.out.println("[Class: SetupDaoHibernate] [Method: initFactory]");
//		try {
//			// 1. configuring hibernate
//			//Configuration configuration = new Configuration().configure();
//			// 2. create sessionfactory
//			//SessionFactory sessionFactory = configuration.buildSessionFactory();
//			System.out.println("conf");
//			configuration = new Configuration().configure();
//			System.out.println("sess factory");
//			sessionFactory = configuration.buildSessionFactory();
//		} catch (HibernateException e) {
//			System.out.println("[SetupDaoHibernate][initFactory] error:");
//			System.out.println(e.getMessage());
//		}
//		
//	}

// http://stackoverflow.com/questions/32405031/hibernate-5-org-hibernate-mappingexception-unknown-entity
//	public void initFactory(){
//		// 1. configuring hibernate
//		Configuration configuration = new Configuration().configure();
//		// 2. create sessionfactory
//		sessionFactory = configuration.buildSessionFactory();
//	}

//public void createSchema() {
	//		System.out.println("[SetupDao] createSchema");
	//		executeSqlFromFile(getClassPathFile("schema.sql"));
//}

//public void insertSampleData() {
	//		System.out.println("[SetupDao] insertSampleData");
	//		executeSqlFromFile(getClassPathFile("sample_data.sql"));
//}

//public void destroy() {
	//		System.out.println("[SetupDao] destroy");
	//		//http://h2database.com/html/grammar.html#drop_all_objects
	//		executeQuery("DROP ALL OBJECTS DELETE FILES;"); // without dropping tables use TRUNCATE TABLE, doesn't reset AUTO_INCREMENT counters to zero
	//		// ? The command: SHUTDOWN You can execute it using RunScript.execute(jdbc_url, user, password, "classpath:shutdown.sql", "UTF8", false);
	//		//executeQuery("DROP SCHEMA PUBLIC CASCADE;");
//}

//private String getClassPathFile(String fileName) {
//	return fileName;
	//		return getClass().getClassLoader().getResource(fileName).getFile();
	//		//return getClass().getResource(fileName).getFile();
//}

//private void executeSqlFromFile(String sqlFilePath) {
	//		Project project = new Project();
	//		project.init();
	//
	//		SQLExec e = new SQLExec();
	//		e.setProject(project);
	//		e.setTaskType("sql");
	//		e.setTaskName("sql");
	//		e.setSrc(new File(sqlFilePath));
	//		//e.setDriver("org.hsqldb.jdbcDriver");
	//		e.setDriver("org.h2.Driver");
	//		e.setUserid("sa");
	//		e.setPassword("");
	//		e.setUrl(DB_URL);
	//		e.execute();
//}

/*
protected void setUp() throws Exception {
	// 1. configuring hibernate
	Configuration configuration = new Configuration().configure();

	// 2. create sessionfactory
	SessionFactory sessionFactory = configuration.buildSessionFactory();

}
 */

// http://hibernate.org/orm/documentation/5.1/
// http://docs.jboss.org/hibernate/orm/5.1/quickstart/html_single/#hibernate-gsg-tutorial-basic-test
/*
protected void setUp() throws Exception {
	// A SessionFactory is set up once for an application!
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	try {
		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	}
	catch (Exception e) {
		// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
		// so destroy it manually.
		StandardServiceRegistryBuilder.destroy( registry );
	}
}
 */
/*
protected void setUp() throws Exception {
	entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
}
 */
