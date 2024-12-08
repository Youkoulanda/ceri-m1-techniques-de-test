# UCE Génie Logiciel Avancé : Techniques de tests

Oumayma BOUSAID
G : M1 ILSEN Classsique 

CircleCI : [![CircleCI](https://dl.circleci.com/status-badge/img/gh/Oumayma-Bousaid/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/Oumayma-Bousaid/ceri-m1-techniques-de-test/tree/master)
codecov : [![codecov](https://codecov.io/github/Oumayma-Bousaid/ceri-m1-techniques-de-test/graph/badge.svg?token=4IGQXO1YWH)](https://codecov.io/github/Oumayma-Bousaid/ceri-m1-techniques-de-test)

## Documentation :

1) Objectif :

Le but est de mettre en place un suivi de la couverture de code pour le projet afin d’assurer la qualité et la pertinence des tests. La couverture de code est un indicateur clé qui permet de vérifier le pourcentage de code testé. Nous utiliserons JaCoCo pour générer les rapports de couverture et Codecov pour les analyser.
Outils et Plateformes

    JaCoCo : une bibliothèque Java qui génère des rapports de couverture de code.
    Codecov : une plateforme pour visualiser et suivre la couverture de code.
    CircleCI : un outil d'intégration continue qui permettra d'exécuter les tests et de publier les résultats sur Codecov.

2) Étapes d'implémentation :

1. Création et configuration du compte Codecov

    - Rendez-vous sur Codecov et connectez-vous.
    - Sélectionnez le repository du projet que vous souhaitez ajouter pour la couverture de code.

2. Configuration de Maven pour utiliser JaCoCo

Dans le fichier pom.xml, ajoutez les configurations pour JaCoCo :

     <plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.7</version>
				<executions>
					<execution>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>report</id>
						<phase>test</phase>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>

3. Intégration de Codecov avec CircleCI

    -- Ajoutez le token de Codecov à CircleCI :
        - Depuis Codecov, copiez le token de votre projet.
        - Ajoutez-le dans les variables d'environnement de votre projet CircleCI sous le nom CODECOV_TOKEN.

    -- Configuration de CircleCI pour publier les rapports sur Codecov :
        - Dans le fichier .circleci/config.yml, configurez CircleCI pour qu'il exécute les tests et publie les résultats avec Codecov.
   
5. Vérification et suivi de la couverture de code

    - Une fois le pipeline exécuté, rendez-vous sur Codecov pour vérifier le rapport de couverture de code.
    - Vous y trouverez des statistiques détaillées et des graphiques de couverture par fichier et par classe.

3) Conclusion :

En suivant ces étapes, nous aurons une intégration complète de la couverture de code avec Maven, JaCoCo, Codecov et CircleCI. Cela permet de suivre la qualité des tests au fil du développement et de visualiser l'impact de chaque modification.
