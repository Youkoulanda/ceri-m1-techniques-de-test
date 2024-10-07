# TP5 : Bulbapedia

## Épisode 1 - With [style](https://i.pinimg.com/600x315/db/05/76/db057671463a0705fed6c71c8e3c3b4f.jpg) !

Avoir des tests qui nous couvrent bien et un code qui passe les tests en question est un bon début, mais on peut encore aller plus loin !  
Écrire du "beau" code n'est pas toujours facile et ça l'est encore moins sans les outils appropriés.  
Pour vous assurez que votre code respecte un ensemble de critères de qualité, intégrez l'outil [checkstyle](https://checkstyle.sourceforge.io/) dans votre processus d'intégration continue. Cet outil vous permettra de générer un rapport sur la qualité syntaxique de votre code.  
Pensez également à intégrer dans votre README un badge présentant une versions condensée des conclusions du rapport généré.  

## Épisode 2 - Doc-tor Proctor

Un projet n'est rien sans sa documentation, et c'est encore mieux si elle est générée automatiquement !  
Configurez votre intégration continue de manière à ce que la [Javadoc](https://www.oracle.com/java/technologies/javase/javadoc-tool.html) soit générée automatiquement et directement publiée au travers de GitHub Pages.  
[Ce lien](https://circleci.com/blog/deploying-documentation-to-github-pages-with-continuous-integration/) décrit une manière de le faire pour un projet en Python, mais la logique peut simplement être transférée pour un projet Java. Mais si cette méthode ne vous plaît pas libre à vous de faire autrement tant que le résultat est là.  
Profitez également des rapports générés par checkstyle pour vérifier la couverture de votre Javadoc, ici aussi, on visera un score parfait.

<p align="center" style="color: #ffcb05; font-size: 2rem;">
Félicitation tu as gagné le badge suivant :
</p>
<p align="center">
    <img
        alt="Dessin de Dr. Proctor"
        src="images/doctor_proctor.jpg"
        title="Doc-tor !"
    />
</p>
<p align="center" style="color: #ffcb05; font-size: 2rem;">
Doc-tor !
</p>
