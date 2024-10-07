# TP2 : (Dés)intégration continue

## Épisode 1 - CircleCI

Nous avons un projet compatible avec Maven, nous allons maintenant mettre en place une intégration continue comme vu en cours. Pour cela nous allons utiliser la plateforme CircleCI.  
Commencez par vous rendre à [cette adresse](https://circleci.com), et connectez-vous en utilisant votre compte GitHub :

<p align="center">
    <img
        alt="Capture d'écran de la page de connexion de CircleCI"
        src="images/circleci_signin.png"
        title="Connexion CircleCI"
    />
</p>

Le tableau de bord résume l’ensemble des builds effectués pour vos projets GitHub connecté, comme le montre la capture d'écran suivante :

<p align="center">
    <img
        alt="Capture d'écran du tableau de bord de CircleCI"
        src="images/circleci_dashboard.png"
        title="Dashboard CircleCI"
    />
</p>

## Épisode 2 - circle.yml

CircleCI s’enregistre comme listener des événements de votre repository. Ainsi lorsque qu’on push un commit, CircleCI déclenche une intégration continue exécutée dans un conteneur.  
La première étape de cette intégration continue est de chercher un fichier nommé `circle.yml` à  la racine de votre repository, si ce fichier n’est pas trouvé l’intégration continue échouera.  
En vous aidant de la documentation en ligne, vous devez écrire un fichier `circle.yml` avec les contraintes suivantes :

- Branche master uniquement.
- Environnement Java 8 ou supérieur.
- Execution des tests unitaires avec Maven.

Une fois écrit, "commitez” et "pushez" votre fichier `circle.yml` sur votre repository et assurez vous de la bonne exécution de l'intégration continue sur le dashboard de CircleCI.

<p align="center" style="color: #ffcb05; font-size: 2rem;">
Félicitation tu as gagné le badge suivant :
</p>
<p align="center">
    <img
        alt="Dessin d'un voltorbe"
        src="images/voltorbe.png"
        title="Désintégrateur"
    />
</p>
<p align="center" style="color: #ffcb05; font-size: 2rem;">
Désintégrateur !
</p>
