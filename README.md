# SAE_2.02-BOURREL_RUELRAMOS_C

## Pour generer un fichier jar

1. Changer le main du fichier manifest.txt
   (⚠️ Attention : Il faut impérativement laisser une ligne vide tout à la fin du fichier manifest.txt après le nom de la classe, sinon Java ne pourra pas la trouver).

2. Puis executer la commande :

```bash
jar cvfm nomDuProjet.jar manifest.txt -C out/production/SAE_2.02-BOURREL_RUELRAMOS_C/ .
# c : Create (créer un nouveau fichier JAR).
# v : Verbose (affiche dans le terminal tout ce qu'il est en train de faire, pratique pour voir si ça fonctionne).
# f : File (indique que tu vas donner un nom au fichier JAR juste après).
# m : Manifest (indique que tu fournis ton propre fichier manifeste juste après).
# nomDuProjet.jar : Le nom que tu veux donner à ton application.
# manifest.txt : Le fichier manifeste.
# -C : Cette option dit à la commande : "Déplace-toi dans le dossier indiqué et prends tout ce qui s'y trouve (.)". Ça évite que le JAR final contienne des sous-dossiers inutiles.
## Executer le fichier jar
```
On pourra aussi changer la class au lancement du projet au lieu de recreer un nouveau fichier jar, grace a :
```bash
java -cp Projet.jar Principale
# -cp (Classpath) qui permet d'exécuter une classe spécifique cachée à l'intérieur du JAR
```

## Executer le fichier jar
```bash
java -jar nomDuProjet.jar
```

## Executer le fichier python
```bash
python3 gui/main-gui.py --gtfs gui/STAN.GTFS --jar PATH/TO/JAR
```


<span style="color:#00FF00">JOSHUA RUELRAMOS</span><br>
<span style="color:#FF0000">ROBIN BOURREL</span> <br>
S2C