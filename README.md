# LOG320 LAB02 algo de retour en arrière

Il y a 3 fonctions importantes à implémenter. 

## La première fonction 
est la lecture du fichier d’entrée dans lequel le
puzzle à résoudre est décrit. Le format de ce fichier est le suivant. La dimension maximale des plateaux est de 7x7.
Il y aura donc un maximum de 49 trous. Le plateau est décrit par une suite de chiffres. Les cases inaccessibles (en
dehors de la surface de jeu) sont représentées par le chiffre 0. Les trous contenant une tige sont représentés par le
chiffre 1 et les trous libres par le chiffre 2.

## La deuxième fonction
sert à déterminer les coups valident à partir d’une position donnée. Cette fonction vous
permettra de déterminer les mouvements à essayer lors de la recherche d’une solution.

## La troisième fonction
implémente l’algorithme de retour en arrière qui permet de résoudre le puzzle spécifié par
l’utilisateur. Cette fonction devrait retourner vrai si une solution a été trouvée et faux si aucune solution n’est
possible.

## Autres spécifications
La sortie de votre programme devra contenir les trois éléments suivants :

1. la liste des mouvements pour obtenir la solution.
2. la solution au puzzle spécifié.
3. le nombre de nœuds explorés lors de la recherche.
4. le temps d’exécution.

Votre programme devra aussi avertir l’utilisateur si le puzzle n’a pas de solutions.

## Vérification du programme
À la date déterminée par le responsable du laboratoire, vous devrez faire la démonstration que votre programme
fonctionne. À ce moment, le responsable du laboratoire vous fournira différents fichiers de test afin de vérifier le bon
fonctionnement de votre programme et d’évaluer son efficacité. Les puzzles utilisés pour tester votre programme
comprendront entre 15 et 31 tiges. Il peut y avoir des puzzles impossibles à résoudre.

Un programme de démonstration ainsi que des fichiers de test seront disponibles sur le site Moodle du cours.

## Rapport de laboratoire
Votre rapport de laboratoire devra contenir les éléments suivants :

- Description de votre algorithme
- Améliorations apportées à l’algorithme de base pour améliorer la performance
- Autres commentaires pertinents, s’il y a lieu

Votre rapport doit avoir un maximum de 4 pages. Toutes les pages supplémentaires seront ignorées lors de la
correction.

## Barème de correction
- Fonctionnement de base 3 pts
- Fonctionnement avec le(s) test(s) 2 pts
- Performances (nombre de nœuds explorés) 2 pts
- Rapport de laboratoire 3
- Total 10 pts
