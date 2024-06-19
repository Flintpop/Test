//JAVA 2021-2022

// Exercice 1.1
class ChaineDouble<E> {
  E valeur;
  ChaineDouble<E> suivant;
  ChaineDouble<E> precedent;

  //  Exercice 2.1
  public void concat(ChaineDouble<E> ch) {
    if (ch == null)
      return;

    ChaineDouble<E> current = this;
    while (current.suivant != null)
      current = current.suivant;
    current.suivant = ch;
    ch.precedent = current;

  }

//  Exercice 2.2

  public ChaineDouble<E> decale(int n) {
    ChaineDouble<E> current = this;

    if (n < 0) {
      while (current.precedent != null)
        current = current.precedent;
    }
    if (n > 0) {
      while (current.suivant != null)
        current = current.suivant;
    }
    return current;


  }
}

public class ChaineSimple<E> {
  E valeur;
  ChaineSimple<E> suivant;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    //Si pas du meme type
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChaineSimple autre = (ChaineSimple) o;
    ChaineSimple current = this;

    while (current != null && autre != null) {
      if (!current.valeur.equals(autre.valeur)) {
        return false;
      }
      current = current.suivant;
      autre = autre.suivant;
    }
    return current == null && autre == null;
  }

  public ChaineSimple<E> inverse() {
    return null;
  }

  //Exercice 1.2
  public boolean palindrome() {
    ChaineSimple<E> ch = this.inverse();
    if (this.equals(ch))
      return true;
    return false;
  }
}

