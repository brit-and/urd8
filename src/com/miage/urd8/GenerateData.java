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
				"Certificat m�dical pour saut en parachute", "Marseille",
				uneDate, uneDate, uneHeure, uneAutreHeure, false, false);
		RDV.allRDV.add(unRDV);

		/*
		 * RDV2
		 */
		uneDate.set(2013, 04, 17);
		uneHeure.set(Calendar.HOUR, 21);
		uneAutreHeure.set(Calendar.HOUR, 23);

		unRDV = new RDV("Match PSG-OM",
				"6eme journ�e du championnat de France de Ligue 1", "Paris",
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
				"Concert de Marc Lavoine � l'occasion des 15 ans de Elle a les yeux r�volvers",
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
				"A�roport de Marignagne", uneDate, uneDate, uneHeure, uneHeure,
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
				"Pr�chauffer le four � 180�C (th 6). Faire fondre le chocolat dans une casserole, avec un peu d'eau.Hors du feu, ajouter le beurre, la farine et la levure. Pr�parer une mousse avec le jaune d��uf, le sucre et un peu d'eau; l'ajouter � la pr�paration chocolat�e. Battre les blancs en neige, et les incorporer dans la casserole tout doucement. Verser le tout dans un moule beurr� � bords hauts, et enfourner, pendant environ 35 min. On peut rajouter du sucre glace ou du chocolat fondu, pour d�corer le dessus du g�teau.",
				6, 1400, 3);
		Repas.allRepas.add(unRepas);

		/*
		 * REPAS2
		 */
		unRepas = new Repas(
				"Lasagnes",
				"Laver et hacher finement l'oignon, la carotte et la branche de c�leri (en ayant pris soin d'en retirer les feuilles que l'on r�serve pour plus tard). Dans une marmite ou une cocotte, verser un fond d'huile d'olive et y ajouter la moiti� du m�lange pr�alablement pr�par�, puis y ajouter toute la tomate. Ajouter ensuite un bouquet constitu� des feuilles de c�leri et de deux branches de basilic enti�res, bouquet que l'on retirera en fin de cuisson de la sauce. Pr�parer une b�chamel classique et la r�server. Prendre ensuite un autre r�cipient et y ajouter un fond d'huile d'olive, le reste de hachis (oignon + carotte + c�leri), puis ajouter la chair � saucisse, laisser cuire environ 5 minutes et ajouter le boeuf. Lorsque le m�lange a pris sa couleur, le retirer du feu et le m�langer avec la b�chamel. Si vous avez le temps, laissez cuire la sauce tomate environ 1 heure � feux doux en rajoutant un peu d'eau si n�cessaire. Proc�der ensuite de la mani�re habituelle en faisant une couche de p�tes, une couche de tomate, une couche de b�chamel + viande, en rajoutant quelques feuilles de basilic entre chaque couche. Laisser cuire environ 35 min � four moyen et recouvrir de mozzarella coup�e en petits morceaux quelques minutes avant de servir.",
				4, 440, 2);
		Repas.allRepas.add(unRepas);

		/*
		 * REPAS3
		 */
		unRepas = new Repas(
				"Salade ni�oise",
				"Pour r�aliser la salade ni�oise, il suffit de rassembler tous les ingr�dients, puis de proc�der de la mani�re suivante. Faire durcir les oeufs (6 � 8 minutes apr�s �bullition de l'eau), puis les faire bien refroidir � l'eau froide. Hacher les c�bettes et les disposer au fond du plat. Ajouter les f�vettes, le poivron vert finement coup�, les radis coup�s en rondelles et le thon bien �gout� et �miett�. M�langer grossi�rement tous ces ingr�dients avec du sel et du poivre. Couper les tomates en fines rondelles et les ajouter. Couper les oeufs durs en quartiers et les disposer sur le dessus et ajouter les filets d'anchois, les olives noires et le basilic finement cisel�. Enfin, saupoudrer de sel et de poivre, puis arroser d'huile d'olive et de vinaigre de vin. Mettre au frais 1 heure et bien m�langer la salade juste avant de la servir.",
				4, 210, 1);
		Repas.allRepas.add(unRepas);

		/*
		 * REPAS4
		 */
		unRepas = new Repas(
				"Magrets de canard au miel",
				"Inciser les magrets cot� peau en quadrillage sans couper la viande. Cuire les magrets � feu vif dans une cocotte en fonte, en commen�ant par le cot� peau. Le temps de cuisson d�pend du fait qu'on aime la viande plus ou moins saignante. Compter environ 5 mn de chaque c�t�. Retirer r�guli�rement la graisse en cours de cuisson. R�server les magrets au chaud (au four, couverts par une feuille d'aluminium). D�glacer la cocotte avec le miel et le vinaigre balsamique (une cuill�re � caf� de vinaigre pour une cuill�re � soupe de miel). Ne pas faire bouillir, la pr�paration tournerait au caramel. Bien poivrer. Mettre en sauci�re accompagnant le magret coup� en tranches. Comme accompagnement, je sugg�re des petits navets glac�s (cuits � l'eau puis pass�s au beurre avec un peu de sucre).",
				2, 340, 2);
		Repas.allRepas.add(unRepas);

		/*
		 * REPAS5
		 */
		unRepas = new Repas(
				"Baba au rhum",
				"Dans un bol, d�layez la levure dans 2 cuill�res � soupe d'eau ti�de. Ajoutez 50 g de farine, m�langez. Couvrez et laissez lever 30 mn � temp�rature ambiante. Apr�s 30 mn, battez la p�te repos�e avec le lait, les oeufs, 1 pinc�e de sucre, 1 pinc�e de sel, la farine et le beurre ramolli. P�trissez la p�te � la main jusqu'� ce qu'elle soit souple et se d�colle facilement. Faites une boule, couvrez d'un linge humide et laissez reposer pendant 45 mn. Travaillez une derni�re fois la p�te puis disposez la dans un moule en couronne pr�alablement beurr�. Tassez la p�te puis recouvrez du linge humide laissez lever 1h30. Pr�chauffez le four � 200�C (thermostat 6/7). Enfournez le baba pour 30 mn. D�moulez-le sur une grille au dessus d'un plat creux. Pr�parez un sirop : dans une casserole, portez 50 cl d'eau et 350 g de sucre � �bullition (7 � 8 mn). Faites ti�dir 10 mn et ajoutez le rhum vieux. Faites ti�dir la confiture d'abricot avec 1 cuill�re d'eau. Versez le sirop sur le baba encore chaud, en plusieurs fois pour qu'il s'en imbibe enti�rement. A l'aide d'un pinceau, badigeonnez le baba de confiture d'abricots ti�die. D�corez de fruits confits et placez la g�teau au frais. Servez le g�teau avec de la chantilly ou de la cr�me p�tissi�re.",
				6, 420, 3);
		Repas.allRepas.add(unRepas);

		/*
		 * GENERATION DES COURSES
		 */
		Courses uneCourse;

		/*
		 * COURSE1
		 */
		uneCourse = new Courses("Course Avril", "Mouchoirs \n Coca-Cola \n 6 steacks hach�s \n Lessive \n Papier toilette \n Chocolat \n Pile AAA \n Stylos 4 couleurs");
		Courses.allCourses.add(uneCourse);
		
		/*
		 * COURSE2
		 */
		uneCourse = new Courses("Repas anniversaire Thierry", "Saumon \n Champagne \n Vin rouge \n Biscuits ap�ritifs \n Coca-Cola \n Tarte aux pommes \n Pommes de terre \n Fruits");
		Courses.allCourses.add(uneCourse);

	}

}
