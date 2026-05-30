# SAE_2.02-BOURREL_RUELRAMOS_C

## Générer un fichier JAR

1. Changer le main du fichier `manifest.txt`

   > ⚠️ Il faut impérativement laisser une ligne vide à la fin du fichier `manifest.txt` après le nom de la classe, sinon Java ne pourra pas la trouver.

2. Puis exécuter la commande :

```bash
jar cvfm nomDuProjet.jar manifest.txt -C out/production/SAE_2.02-BOURREL_RUELRAMOS_C/ .
# c : Create   — crée un nouveau fichier JAR
# v : Verbose  — affiche ce qu'il fait dans le terminal
# f : File     — indique le nom du fichier JAR
# m : Manifest — indique que tu fournis ton propre fichier manifeste
# -C           — se déplace dans le dossier indiqué et prend tout ce qui s'y trouve (.)
#               Ça évite que le JAR final contienne des sous-dossiers inutiles
```

On peut aussi changer la classe au lancement sans recréer le JAR :

```bash
java -cp Projet.jar Principale
# -cp (Classpath) permet d'exécuter une classe spécifique cachée à l'intérieur du JAR
```

## Exécuter le fichier JAR

```bash
java -jar nomDuProjet.jar
```

## Exécuter le fichier Python

```bash
python3 gui/main-gui.py --gtfs gui/STAN.GTFS --jar PATH/TO/JAR
```

> ⚠️ Veillez à ce que le fichier `network.pkl` soit à la racine du projet et à exécuter cette commande depuis la racine du projet.

---

## Crédits

Joshua Ruelramos & Robin Bourrel — S2C