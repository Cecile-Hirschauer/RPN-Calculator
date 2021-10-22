# RPN Calculator

Vous avez pour mission de développer une calculatrice RPN (Reverse Polish Notation – Notation Polonaise Inverse) de type HP-48.

La Notation Polonaise Inverse (NPI), ou RPN (Reverse Polish Notation) est également connue sous le nom de notation post-fixée et permet d'écrire de façon non ambiguë des formules arithmétiques sans utiliser de parenthèses ni gérer de priorités d’opérateurs.

Voici quelques exemples d’expressions RPN valides :

 -  20 5 /          => renvoie 4
 -  4 2 + 3 -       => renvoie 3
 -  3 5 8 * 7 + *   => renvoie 141
 -  12 3 - 3 /      => renvoie 3
 -  -2 3 11 + 5 - * => renvoie -18

Vous devez développer une application en mode console permettant d’évaluer des expressions post-fixées comme décrites précédemment.

Les expressions seront saisies par l’utilisateur au prompt de l’application et seront évaluées lors de l’appui de la touche `Entrée`.

Le prompt de l’application sera représenté ainsi :

    RPN Calculator > 

La calculatrice prendra en charge les quatre opérations de base :

 -  `+` : ajouter
 -  `-` : soustraire
 -  `*` : multiplier
 -  `/` : diviser

La calculatrice prendra en charge quelques commandes spéciales :

 -  La commande « clear » permettra de réinitialiser la calculatrice.
 -  La commande « quit » permettra de quitter la calculatrice.
 -  La commande « help » affichera une aide en ligne de la liste des commandes disponibles.

La qualité et l'évolutivité du code étant prioritaire, un design orienté objet, solide, élégant et soigné est attendu.

