import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResidentTest {

    private List<Object> liste;
    private List<Entrave> listeDeEntraves;
    private Resident Bob;

    @BeforeEach
    public void setUp() {
        liste = new ArrayList<Object>();
        Bob = new Resident("bob", "2002/23/01", "bob@gmail.com", "123", "514-123-4567", "2900 Edouard Montpetit Blvd");
    }
    @Test
    void ListeEstVide(){
        assertEquals(0, liste.size());
        assertTrue(liste.isEmpty());
    }
    @Test
    void AjouterBob(){
        Bob.Ajouter(liste);
        assertEquals(1, liste.size());
        assertTrue(liste.contains(Bob));
    }
    @Test
    void objetPointeVersLeMêmeObjet(){
        Bob.Ajouter(liste);
        assertSame(Bob.getClass(),liste.get(0).getClass());
    }
    @Test
    void EnleverUnResident(){
        Bob.Ajouter(liste);
        assertTrue(liste.contains(Bob));
        Bob.Enlever(liste);
        assertTrue(liste.isEmpty());
        assertTrue(!liste.contains(Bob));
    }

    @Test
    void RechercherEntraveParId(){
        Entrave entrave1 = new Entrave("65b40710675f6600194688fe","avenue Earnscliffe ","Earnscliffe","Aucun impact / non applicable");
        Entrave entrave2 = new Entrave("671fd1d6d2c76f001aa8bea8","avenue Louis-Hébert ","Louis-Hébert","Aucun impact / non applicable");
        Entrave entrave3 = new Entrave("671fd1d6d2c76f001aa8bea8","rue Garnier ","Garnier","Aucun impact / non applicable");
        Entrave entrave4 = new Entrave("671f7f71ba710c00198d625d","rue De Chambly ","De Chambly","Aucun impact / non applicable");
        listeDeEntraves = new ArrayList<>();
        listeDeEntraves.add(entrave1);
        listeDeEntraves.add(entrave2);
        listeDeEntraves.add(entrave3);
        listeDeEntraves.add(entrave4);
        Entrave trouve = Bob.ConsulterEntraveParID(listeDeEntraves,"671fd1d6d2c76f001aa8bea8");
        assertSame(entrave2,trouve);
        assertSame(entrave2.getShortname(),trouve.getShortname());
    }

    @Test
    void RechercherEntraveParRue(){
        Entrave entrave1 = new Entrave("65b40710675f6600194688fe","avenue Earnscliffe ","Earnscliffe","Aucun impact / non applicable");
        Entrave entrave2 = new Entrave("671fd1d6d2c76f001aa8bea8","avenue Louis-Hébert ","Louis-Hébert","Aucun impact / non applicable");
        Entrave entrave3 = new Entrave("671fd1d6d2c76f001aa8bea8","rue Garnier ","Garnier","Aucun impact / non applicable");
        Entrave entrave4 = new Entrave("671f7f71ba710c00198d625d","rue De Chambly ","De Chambly","Aucun impact / non applicable");
        listeDeEntraves = new ArrayList<>();
        listeDeEntraves.add(entrave1);
        listeDeEntraves.add(entrave2);
        listeDeEntraves.add(entrave3);
        listeDeEntraves.add(entrave4);
        Entrave trouve = Bob.ConsulterEntraveParRue(listeDeEntraves,"Garnier");
        assertSame(entrave3,trouve);
        assertSame(entrave3.getShortname(),trouve.getShortname());
    }
    @Test
    void verifierFuncRecevoirNotifications() {
        assertSame("*Example*"
                +"\n Vous êtes maintenant abonnés!"
                +"\n ---------------------------",Bob.RecevoirNotifications("1"));
        assertSame("*Example*"
                +"\n Vous êtes maintenant abonnés!"
                +"\n ---------------------------",Bob.RecevoirNotifications("2"));
        assertSame("Retour au menu",Bob.RecevoirNotifications("3"));
    }

    @Test
    void verifierFuncPlanification() {
        assertSame("*Example*"
                +"\n Veuillez indiquer les plages horaires préférables:"
                +"\n ---------------------------",Bob.Planification("1"));
        assertSame("*Example*"
                +"\n Voici les préférences des autres résidents de mon quartier:"
                +"\n ---------------------------",Bob.Planification("2"));
        assertSame("*Example*"
                +"\n Quel est votre avis sur les travaux et l'intervenant:"
                +"\n ---------------------------",Bob.Planification("3"));
        assertSame("Retour au menu",Bob.Planification("4"));
    }

    @Test
    void verifierFuncRechercheTravaux() {
        assertSame("Voici liste des travaux par titre:"
                +"\n *Example*"
                +"\n ---------------------------"
                +"\n ---------------------------"
                +"\n ---------------------------",Bob.RechercheTravaux("1"));
        assertSame("Voici liste des travaux par type de travaux:"
                +"\n *Example*"
                +"\n ---------------------------"
                +"\n ---------------------------"
                +"\n ---------------------------",Bob.RechercheTravaux("2"));
        assertSame("Voici liste des travaux par quartier:"
                +"\n *Example*"
                +"\n ---------------------------"
                +"\n ---------------------------"
                +"\n ---------------------------",Bob.RechercheTravaux("3"));
        assertSame("Retour au menu",Bob.RechercheTravaux("4"));
    }



}