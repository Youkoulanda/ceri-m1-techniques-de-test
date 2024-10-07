# TP4 : 100% IV

## Épisode 1 - Code coverage

Nous avons des tests, maintenant on veut des indicateurs de pertinence !  
Le plus répandu est le pourcentage de couverture (ou Code Coverage), et nous allons utiliser la plateforme [Codecov](https://www.codecov.io) pour cela. Après vous être identifié sur la plateforme, sélectionnez et ajoutez votre repository.  
Une fois le repository ajouté, il faut configurer Maven pour qu’il génère des rapports de couverture. Pour la génération de ces rapports on utilisera la bibliothèque [JaCoCo](https://www.eclemma.org/jacoco/), et il faudra s’assurer que CircleCI publie les résultats sur Codecov (à travers une section déploiement par exemple, ou post tests).  
Nous vous invitons à conculter la documentation de ces différents outils pour comprendre comments ils interagissent.

## Épisode 2 - Badger Badger Badger … MUSHROOM

Afin de pouvoir consulter les résultats des différents outils en un coup d'oeil nous allons utiliser des  badges sur le fichier README.md du repository GitHub.  
Le fichier README devra contenir :

- Votre nom et prénom.
- Votre groupe.
- Un badge pour CircleCI.
- Un badge pour la couverture de test.

Nous vous invitons également à enrichir votre README avec un peu de documentation sur votre travail, comme vos choix techniques d’implémentation (à venir).

## Épisode 3 - Make it work !

Tout est prêt pour attaquer l’implémentation !  
Tâchez de développer les implémentation des interfaces en maintenant un niveau de qualité optimal.  
Les détails d’implémentation pourront être discutés avec l'intervenant lors des séances de TP.

<p align="center" style="color: #ffcb05; font-size: 2rem;">
Félicitation tu as gagné le badge suivant :
</p>
<p align="center">
    <img
        alt="Dessin d'un linoone"
        src="images/linoone.png"
        title="Badger"
    />
</p>
<p align="center" style="color: #ffcb05; font-size: 2rem;">
Badger !
</p>
