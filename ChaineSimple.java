//JAVA 2021-2022 S2


//Exercice 1.1

public class ChaineSimple<E> {
  ChaineSimple<E> suivant;
  E valeur;

  public void concat(ChaineSimple<E> ch) {
    if (this.suivant == null) {
      this.suivant = ch;
      return;
    }
    ChaineSimple<E> current = this;
    while (current.suivant != null) {
      current = current.suivant;
    }
    current.suivant = ch;
  }

  //    Exercice 1.2
  public static <E> ChaineSimple<E> flatten(ChaineSimple<ChaineSimple<E>> ch) {
    ChaineSimple<E> result = new ChaineSimple<>();
    ChaineSimple<E> current = result;

    while (ch != null) {
      if (ch.valeur != null) {
        current.concat(ch.valeur);
        while (current.suivant != null) {
          current = current.suivant;
        }
      }
      ch = ch.suivant;
    }
    return result.suivant;
  }

//    Exercice 1.3

  public static <E> ChaineSimple<E> flatten2(ChaineSimple<ChaineSimple<ChaineSimple<E>>> ch) {
    return flatten(flatten(ch));
  }


}

class ArbreBinaire<E> {
  ArbreBinaire<E> gauche;
  ArbreBinaire<E> droit;
  E valeur;

  //    Exercice 2.1
  public ArbreBinaire<E> max() {
    return null;
  }

  public ArbreBinaire<E> hauteur() {
    return null;
  }

  public boolean supprime(E valeur) {
      return true;
  }

  public ArbreBinaire<E> adam() {
    if (this.gauche == null && this.droit == null) return null;

    if (this.gauche == null) return this.droit.max();

    if (this.droit == null) return this.gauche.max();

    return this.gauche.hauteur() > this.droit.hauteur() ? this.gauche.max() : this.droit.max();// pas sur mais ca semble bueno

  }

  //    Exercice 2.2

  public ArbreBinaire<E> deseqG() {
    if (this.droit == null) return this;

    ArbreBinaire<E> current = this.droit.max();
    this.valeur = current.valeur;
    current.supprime();
    return this;

  }

  //    Exercice 2.3

  public ArbreBinaire<E> supprimeDG() {
    if (this.gauche == null && this.droit == null) return null;

    if (this.droit == null) return this.gauche;

    if (this.gauche == null) return this.droit;

    ArbreBinaire<E> maxGauche = this.gauche.max(); //on recupere la valeur max de la partie gauche de l'arbre
    this.valeur = maxGauche.valeur; //on remplace la valeur de this par la valeur max du fils gauche
    this.gauche = this.gauche.supprime(maxGauche.valeur); //on supprime la valeur max du fils gauche

    return this;
  }
}