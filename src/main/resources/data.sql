INSERT INTO ouvrage (id_ouvrage, titre, auteur) VALUES
  (1, 'Les misérables', 'Victor Hugo'),
  (2, 'Le rouge et le noir', 'Stendhal'),
  (3, 'Le misantrope', 'Moliere');

INSERT INTO biblio (id_Biblio , nom_Biblio) VALUES
    (1, 'Bibliothèque du centre'),
    (2, 'Biblio2000');

INSERT INTO utilisateur (id_utilisateur, pseudo, mot_de_passe, nom_utilisateur, prenom_utilisateur, email) VALUES
    (	1, 'Manu', '$2a$11$tvAKvkKFXIcSKDB9yGNOyuKfyTPIg.Mt5MRsjMsYO0SCXe1teheHy', 'Marcel', 'Emmanuel', 'manu@axa.fr'),
    (	2, 'Hugo', '$2a$11$tvAKvkKFXIcSKDB9yGNOyuKfyTPIg.Mt5MRsjMsYO0SCXe1teheHy', 'Les-Bons-Tuyaux', 'Hugo', 'hugo@axa.fr');

INSERT INTO exemplaire (id_exemplaire, code_barre, id_ouvrage , id_biblio ,  id_utilisateur, date_retour , prolongation) VALUES
    (1, 1234567801, 1, 1, 1, '2020-04-20 00:00:01', false),
    (2, 1234567802, 1, 1, null, null, false),
    (3, 1234567803, 1, 2, null, null, false),
    (4, 1234567804, 1, 2, 2, '2020-03-22 00:00:01', true),
    (5, 1234567805, 2, 2, null, null, false),
    (6, 1234567806, 3, 2, null, null, false), -- ouvrage 3 n'existe que dans bilio 2
    (7, 1234567807, 3, 2, null, null, false);


/*
select * from ouvrage;
select * from biblio;

select * from exemplaire;
 */
