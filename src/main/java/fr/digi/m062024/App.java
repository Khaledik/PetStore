package fr.digi.m062024;

import fr.digi.m062024.entities.*;
import fr.digi.m062024.utils.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author Khaled IKHLEF
 */
public class App {
    public static void main(String[] args) {

//      CRÉATION ET OUVERTURE DE L'ENTITY MANAGER
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

//      CRÉATION DES PETSTORES
        PetStore petLand = new PetStore("PetLand", "Jack");
        PetStore topPet = new PetStore("TopPet", "Yanis");
        PetStore animalis = new PetStore("Animalis", "Jason");

//      CRÉATION DES ADDRESSES
        Address addressPl = new Address("12", "rue du tigre", "69000", "Lyon");
        Address addressTp = new Address("12", "avenue Charles de Gaulle", "75000", "Paris");
        Address addressAn = new Address("17", "rue de la libération", "34000", "Montpellier");

//      CRÉATION DES PRODUITS
        Product itemsOne = new Product("2154268581", "Croquettes pour chat 2Kg", ProdType.FOOD, 19.99);
        Product itemsTwo = new Product("986332447", "Niche pour chien", ProdType.ACCESSORY, 59.99);
        Product itemsThree = new Product("74522652", "Nourriture pour poisson", ProdType.FOOD, 15.99);

//      CRÉATION DES ANIMAUX
        Cat miaousse = new Cat(LocalDate.of(2022, 05, 5), "Blanc", "25481");
        Animal piouPiou = new Animal(LocalDate.of(2020, 7, 24), "Jaune");
        Fish dori = new Fish(LocalDate.of(2015, 10, 8), "Bleu", FishLivEnv.SEA_WATER);
        Animal croco = new Animal(LocalDate.of(2010, 7, 1), "Vert");


//      INSERTION DES PETSTORES EN BDD
        em.persist(petLand);
        em.persist(topPet);
        em.persist(animalis);

//      INSERTION DES ADDRESSES EN BDD
        em.persist(addressPl);
        em.persist(addressTp);
        em.persist(addressAn);

//      INSERTION DES PRODUITS EN BDD
        em.persist(itemsOne);
        em.persist(itemsTwo);
        em.persist(itemsThree);

//      INSERTION DES ANIMAUX EN BDD
        em.persist(miaousse);
        em.persist(piouPiou);
        em.persist(dori);
        em.persist(croco);


//      AJOUTS DES INFORMATIONS LIÉ AU PETSTORE -> PETLAND
        petLand.setAddress(addressPl);
        petLand.addProduct(itemsOne);
        petLand.addAnimal(miaousse);


//      AJOUTS DES INFORMATIONS LIER AU PETSTORE -> TOPPET
        topPet.setAddress(addressTp);
        topPet.addProduct(itemsTwo);
        topPet.addAnimal(piouPiou);


//      AJOUTS DES INFORMATIONS LIER AU PETSTORE -> ANIMALIS
        animalis.setAddress(addressAn);
        animalis.addProduct(itemsThree);
        animalis.addAnimal(dori);
        animalis.addAnimal(croco);


//      RÊQUETES JPQL QUI RÉCUPERE TOUS LES ANIMAUX DU PETSTORE -> ANIMALIS
        TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a LEFT JOIN  a.petStore pt   WHERE pt.name = 'Animalis'", Animal.class);
        List<Animal> animalisResult = query.getResultList();
        System.out.println(animalisResult);


//      FERMETURE DE L'ENTITY MANAGER
        em.getTransaction().commit();
        em.close();
        PersistenceManager.getEntityManagerFactory().close();

    }
}
