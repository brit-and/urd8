package com.miage.urd8;

import java.util.Calendar;

public class GenerateData {

	public static void launch() {
		/*
		 * GENERATION DES RDV
		 */
		RDV unRDV;
		Calendar uneDate;
		Calendar uneHeure;
		Calendar uneAutreHeure;

		uneDate = Calendar.getInstance();
		uneHeure = Calendar.getInstance();
		uneAutreHeure = Calendar.getInstance();

		/*
		 * RDV1
		 */
		uneDate.set(2013, 04, 12);
		uneHeure.set(Calendar.HOUR, 18);
		uneAutreHeure.set(Calendar.HOUR, 19);

		unRDV = new RDV("Docteur Vidal",
				"Certificat médical pour saut en parachute", "Marseille",
				uneDate, uneDate, uneHeure, uneAutreHeure, false, false);
		RDV.allRDV.add(unRDV);

		/*
		 * RDV2
		 */
		uneDate.set(2013, 04, 17);
		uneHeure.set(Calendar.HOUR, 21);
		uneAutreHeure.set(Calendar.HOUR, 23);

		unRDV = new RDV("Match PSG-OM",
				"6eme journée du championnat de France de Ligue 1", "Paris",
				uneDate, uneDate, uneHeure, uneAutreHeure, false, true);
		RDV.allRDV.add(unRDV);

		/*
		 * RDV3
		 */
		uneDate.set(2013, 05, 02);
		uneHeure.set(Calendar.HOUR, 20);
		uneAutreHeure.set(Calendar.HOUR, 22);

		unRDV = new RDV(
				"Concert Marc Lavoine",
				"Concert de Marc Lavoine à l'occasion des 15 ans de Elle a les yeux révolvers",
				"Marseille, Dome", uneDate, uneDate, uneHeure, uneAutreHeure,
				false, false);
		RDV.allRDV.add(unRDV);

		/*
		 * RDV4
		 */
		uneDate.set(2013, 05, 22);
		uneHeure.set(Calendar.HOUR, 20);

		unRDV = new RDV(
				"Vol Marseille - New York",
				"Voyage d'affaire: rencontre avec Bill Gates concernant le rachat d'Apple",
				"Aéroport de Marignagne", uneDate, uneDate, uneHeure, uneHeure,
				false, true);
		RDV.allRDV.add(unRDV);

		/*
		 * GENERATION DES REPAS
		 */
		Repas unRepas;

		/*
		 * REPAS1
		 */
		unRepas = new Repas(
				"Gateau au chocolat",
				"Préchauffer le four à 180°C (th 6). Faire fondre le chocolat dans une casserole, avec un peu d'eau.Hors du feu, ajouter le beurre, la farine et la levure. Préparer une mousse avec le jaune d’œuf, le sucre et un peu d'eau; l'ajouter à la préparation chocolatée. Battre les blancs en neige, et les incorporer dans la casserole tout doucement. Verser le tout dans un moule beurré à bords hauts, et enfourner, pendant environ 35 min. On peut rajouter du sucre glace ou du chocolat fondu, pour décorer le dessus du gâteau.",
				6, 1400, 3);
		Repas.allRepas.add(unRepas);

		/*
		 * REPAS2
		 */
		unRepas = new Repas(
				"Lasagnes",
				"Laver et hacher finement l'oignon, la carotte et la branche de céleri (en ayant pris soin d'en retirer les feuilles que l'on réserve pour plus tard). Dans une marmite ou une cocotte, verser un fond d'huile d'olive et y ajouter la moitié du mélange préalablement préparé, puis y ajouter toute la tomate. Ajouter ensuite un bouquet constitué des feuilles de céleri et de deux branches de basilic entières, bouquet que l'on retirera en fin de cuisson de la sauce. Préparer une béchamel classique et la réserver. Prendre ensuite un autre récipient et y ajouter un fond d'huile d'olive, le reste de hachis (oignon + carotte + céleri), puis ajouter la chair à saucisse, laisser cuire environ 5 minutes et ajouter le boeuf. Lorsque le mélange a pris sa couleur, le retirer du feu et le mélanger avec la béchamel. Si vous avez le temps, laissez cuire la sauce tomate environ 1 heure à feux doux en rajoutant un peu d'eau si nécessaire. Procéder ensuite de la manière habituelle en faisant une couche de pâtes, une couche de tomate, une couche de béchamel + viande, en rajoutant quelques feuilles de basilic entre chaque couche. Laisser cuire environ 35 min à four moyen et recouvrir de mozzarella coupée en petits morceaux quelques minutes avant de servir.",
				4, 440, 2);
		Repas.allRepas.add(unRepas);

		/*
		 * REPAS3
		 */
		unRepas = new Repas(
				"Salade niçoise",
				"Pour réaliser la salade niçoise, il suffit de rassembler tous les ingrédients, puis de procéder de la manière suivante. Faire durcir les oeufs (6 à 8 minutes après ébullition de l'eau), puis les faire bien refroidir à l'eau froide. Hacher les cébettes et les disposer au fond du plat. Ajouter les févettes, le poivron vert finement coupé, les radis coupés en rondelles et le thon bien égouté et émietté. Mélanger grossièrement tous ces ingrédients avec du sel et du poivre. Couper les tomates en fines rondelles et les ajouter. Couper les oeufs durs en quartiers et les disposer sur le dessus et ajouter les filets d'anchois, les olives noires et le basilic finement ciselé. Enfin, saupoudrer de sel et de poivre, puis arroser d'huile d'olive et de vinaigre de vin. Mettre au frais 1 heure et bien mélanger la salade juste avant de la servir.",
				4, 210, 1);
		Repas.allRepas.add(unRepas);

		/*
		 * REPAS4
		 */
		unRepas = new Repas(
				"Magrets de canard au miel",
				"Inciser les magrets coté peau en quadrillage sans couper la viande. Cuire les magrets à feu vif dans une cocotte en fonte, en commençant par le coté peau. Le temps de cuisson dépend du fait qu'on aime la viande plus ou moins saignante. Compter environ 5 mn de chaque côté. Retirer régulièrement la graisse en cours de cuisson. Réserver les magrets au chaud (au four, couverts par une feuille d'aluminium). Déglacer la cocotte avec le miel et le vinaigre balsamique (une cuillère à café de vinaigre pour une cuillère à soupe de miel). Ne pas faire bouillir, la préparation tournerait au caramel. Bien poivrer. Mettre en saucière accompagnant le magret coupé en tranches. Comme accompagnement, je suggère des petits navets glacés (cuits à l'eau puis passés au beurre avec un peu de sucre).",
				2, 340, 2);
		Repas.allRepas.add(unRepas);

		/*
		 * REPAS5
		 */
		unRepas = new Repas(
				"Baba au rhum",
				"Dans un bol, délayez la levure dans 2 cuillères à soupe d'eau tiède. Ajoutez 50 g de farine, mélangez. Couvrez et laissez lever 30 mn à température ambiante. Après 30 mn, battez la pâte reposée avec le lait, les oeufs, 1 pincée de sucre, 1 pincée de sel, la farine et le beurre ramolli. Pétrissez la pâte à la main jusqu'à ce qu'elle soit souple et se décolle facilement. Faites une boule, couvrez d'un linge humide et laissez reposer pendant 45 mn. Travaillez une dernière fois la pâte puis disposez la dans un moule en couronne préalablement beurré. Tassez la pâte puis recouvrez du linge humide laissez lever 1h30. Préchauffez le four à 200°C (thermostat 6/7). Enfournez le baba pour 30 mn. Démoulez-le sur une grille au dessus d'un plat creux. Préparez un sirop : dans une casserole, portez 50 cl d'eau et 350 g de sucre à ébullition (7 à 8 mn). Faites tiédir 10 mn et ajoutez le rhum vieux. Faites tiédir la confiture d'abricot avec 1 cuillère d'eau. Versez le sirop sur le baba encore chaud, en plusieurs fois pour qu'il s'en imbibe entièrement. A l'aide d'un pinceau, badigeonnez le baba de confiture d'abricots tiédie. Décorez de fruits confits et placez la gâteau au frais. Servez le gâteau avec de la chantilly ou de la crème pâtissière.",
				6, 420, 3);
		Repas.allRepas.add(unRepas);

		/*
		 * GENERATION DES COURSES
		 */
		Courses uneCourse;

		/*
		 * COURSE1
		 */
		uneCourse = new Courses("Course Avril", "Mouchoirs \n Coca-Cola \n 6 steacks hachés \n Lessive \n Papier toilette \n Chocolat \n Pile AAA \n Stylos 4 couleurs");
		Courses.allCourses.add(uneCourse);
		
		/*
		 * COURSE2
		 */
		uneCourse = new Courses("Repas anniversaire Thierry", "Saumon \n Champagne \n Vin rouge \n Biscuits apéritifs \n Coca-Cola \n Tarte aux pommes \n Pommes de terre \n Fruits");
		Courses.allCourses.add(uneCourse);

	}

}
