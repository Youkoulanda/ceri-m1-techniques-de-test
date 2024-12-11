# UCE Génie Logiciel Avancé : Techniques de tests

Oumayma BOUSAID ( M1 ILSEN Classsique )

CircleCI : [![CircleCI](https://dl.circleci.com/status-badge/img/gh/Oumayma-Bousaid/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/Oumayma-Bousaid/ceri-m1-techniques-de-test/tree/master)
codecov : [![codecov](https://codecov.io/github/Oumayma-Bousaid/ceri-m1-techniques-de-test/graph/badge.svg?token=4IGQXO1YWH)](https://codecov.io/github/Oumayma-Bousaid/ceri-m1-techniques-de-test)
Checkstyle : ![Checkstyle Badge](https://github.com/Oumayma-Bousaid/ceri-m1-techniques-de-test/raw/master/badges/target/checkstyle-result.svg)


## Langages Utilisés

- Java : Le projet utilise Java pour le développement des fonctionnalités et la gestion de la logique métier. Java est un langage robuste et performant adapté à la création d'applications scalables et maintenables.

## Frameworks et Bibliothèques

- JUnit : Utilisé pour l'écriture et l'exécution de tests unitaires. JUnit permet de valider le comportement de petites unités de code (comme les classes et méthodes) pour s'assurer qu'elles fonctionnent comme prévu.

- Mockito : Un framework de simulation qui permet de créer des objets simulés (mocks) pour tester le comportement des unités de code de manière isolée. Mockito est principalement utilisé pour les tests d'intégration et unitaires en simulant des interactions avec d'autres objets.

- JaCoCo : Une bibliothèque Java qui génère des rapports de couverture de code. Elle permet de mesurer la proportion de code qui est exécutée par les tests, fournissant des informations essentielles pour évaluer la qualité des tests.

## Intégration Continue

- CircleCI : CircleCI est un outil d'intégration continue qui automatise l'exécution des tests chaque fois qu'un changement est apporté au code source (par exemple, après un commit ou un push). Il permet de garantir que le code reste fonctionnel à chaque étape du développement et d'exécuter des tests de manière automatisée.

- Codecov : Codecov est une plateforme de suivi de la couverture de code qui récupère les rapports générés par JaCoCo et les affiche sous forme de graphiques et de statistiques détaillées. Codecov permet de suivre en temps réel l'état de la couverture de code et de s'assurer que les tests couvrent suffisamment le code source.

- Checkstyle : Un outil de vérification de la qualité du code qui permet de s'assurer que le code respecte certaines normes de codage. Checkstyle est intégré dans le processus d'intégration continue pour détecter les problèmes de style, comme les erreurs de formatage, les noms de variables non conformes ou les méthodes trop longues.

## Workflow d'Intégration Continue

- Développement du code : Le développeur crée ou modifie les fichiers source en Java.

- Tests unitaires : Utilisation de JUnit et Mockito pour écrire des tests et vérifier le bon fonctionnement des différentes parties du programme.

- Vérification de la couverture de code : Après l’exécution des tests, JaCoCo génère des rapports de couverture pour évaluer combien de lignes de code ont été testées. Ces rapports sont envoyés à Codecov pour un suivi détaillé.

- Vérification des normes de codage : Checkstyle analyse le code pour vérifier s’il respecte les bonnes pratiques et les conventions de codage Java.

- Intégration continue : CircleCI automatise l'exécution des tests et des étapes de vérification à chaque mise à jour du code (push) dans le dépôt GitHub. Il permet aussi de publier les résultats sur Codecov pour un suivi en temps réel.

## Conclusion

- L'intégration de JUnit, Mockito, JaCoCo, Codecov, Checkstyle, et CircleCI dans le projet assure une bonne gestion de la qualité du code. Cela permet non seulement de valider que le code fonctionne correctement, mais aussi de maintenir une couverture de code adéquate et de garantir que le code suit des conventions claires. Ces outils combinés assurent une gestion efficace du code tout au long de son cycle de vie de développement.
