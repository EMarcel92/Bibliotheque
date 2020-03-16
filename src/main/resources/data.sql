INSERT INTO ouvrage (id_ouvrage, titre, auteur) VALUES
  (1, 'Les misérables', 'Victor Hugo'),
  (2, 'Le rouge et le noir', 'Stendhal'),
  (3, 'Le misantrope', 'Moliere');

INSERT INTO biblio (id_Biblio , nom_Biblio) VALUES (1, 'Bibliothèque du centre');
INSERT INTO biblio (id_Biblio , nom_Biblio) VALUES (2, 'Biblio2000');

INSERT INTO utilisateur (id_utilisateur, pseudo, mot_de_passe, nom_utilisateur, prenom_utilisateur, email) VALUES (	1, 'Manu', '$2a$11$tvAKvkKFXIcSKDB9yGNOyuKfyTPIg.Mt5MRsjMsYO0SCXe1teheHy', 'Marcel', 'Emmanuel', 'manu@axa.fr');
INSERT INTO utilisateur (id_utilisateur, pseudo, mot_de_passe, nom_utilisateur, prenom_utilisateur, email) VALUES (	2, 'Hugo', '$2a$11$tvAKvkKFXIcSKDB9yGNOyuKfyTPIg.Mt5MRsjMsYO0SCXe1teheHy', 'Les-Bons-Tuyaux', 'Hugo', 'hugo@axa.fr');


INSERT INTO exemplaire (id_exemplaire ,id_ouvrage , id_biblio ,  id_utilisateur, date_retour , prolongation)
VALUES (2, 1, 1, null, null, false);
INSERT INTO exemplaire (id_exemplaire ,id_ouvrage , id_biblio ,  id_utilisateur, date_retour , prolongation)
VALUES (3, 1, 2, null, null, false);

INSERT INTO exemplaire (id_exemplaire ,id_ouvrage , id_biblio ,  id_utilisateur, date_retour , prolongation)
VALUES (5, 2, 2, null, null, false);
INSERT INTO exemplaire (id_exemplaire ,id_ouvrage , id_biblio ,  id_utilisateur, date_retour , prolongation)
VALUES (6, 3, 2, null, null, false); -- ouvrage 3 n'existe que dans bilio 2
INSERT INTO exemplaire (id_exemplaire ,id_ouvrage , id_biblio ,  id_utilisateur, date_retour , prolongation)
VALUES (7, 3, 2, null, null, true);

/*
select * from ouvrage;
select * from biblio;

select * from exemplaire;
 */
