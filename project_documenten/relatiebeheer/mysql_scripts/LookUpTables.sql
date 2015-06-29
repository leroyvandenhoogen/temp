INSERT INTO icaras.adres_type (type)
VALUES ('post');
INSERT INTO icaras.adres_type (type)
VALUES ('postbus');
INSERT INTO icaras.adres_type (type)
VALUES ('huis');
INSERT INTO icaras.adres_type (type)
VALUES ('woonboot');
INSERT INTO icaras.adres_type (type)
VALUES ('bezoek');
COMMIT;
INSERT INTO icaras.digitaal_adres_type (type)
VALUES ('telefoonnummer');
INSERT INTO icaras.digitaal_adres_type (type)
VALUES ('email');
INSERT INTO icaras.digitaal_adres_type (type)
VALUES ('linkedin');
INSERT INTO icaras.digitaal_adres_type (type)
VALUES ('facebook');
INSERT INTO icaras.digitaal_adres_type (type)
VALUES ('twitter');
INSERT INTO icaras.digitaal_adres_type (type)
VALUES ('fax');
INSERT INTO icaras.digitaal_adres_type (type)
VALUES ('website');
COMMIT;
INSERT INTO icaras.identiteitsbewijs_type (type)
VALUES ('paspoort');
INSERT INTO icaras.identiteitsbewijs_type (type)
VALUES ('rijbewijs');
INSERT INTO icaras.identiteitsbewijs_type (type)
VALUES ('identiteitskaart');
COMMIT;
INSERT INTO icaras.rol (type)
VALUES ('cursist');
INSERT INTO icaras.rol (type)
VALUES ('kandidaat');
INSERT INTO icaras.rol (type)
VALUES ('stagiair');
INSERT INTO icaras.rol (type)
VALUES ('werknemer');
INSERT INTO icaras.rol (type)
VALUES ('contactpersoon');
INSERT INTO icaras.rol (type)
VALUES ('prive');
COMMIT;