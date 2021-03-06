drop table if exists PRODUCT_DESCRIPTION;  
    CREATE TABLE PRODUCT_DESCRIPTION(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    description text NOT NULL,
    product_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id)
    );
drop table if exists PRODUCT;
 CREATE TABLE PRODUCT(
    id int UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price decimal(7,2) unsigned DEFAULT 0,
    origin VARCHAR(50),
    description text,
    nutrition_score decimal(5,2) unsigned DEFAULT 0,
    conservation VARCHAR(200),
    agriculture VARCHAR(50),
    picture VARCHAR(100),
    product_sub_cat_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id)
    );
       drop table if exists PRODUCT_SUB_CATEGORY; 
	CREATE TABLE PRODUCT_SUB_CATEGORY(
	 	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
 		sub_category_name VARCHAR(100) NOT NULL UNIQUE,
 		description VARCHAR(50),
 		product_category_id int UNSIGNED NOT NULL,
 	PRIMARY KEY (id)
);
   
    drop table if exists PRODUCT_CATEGORY; 

    CREATE TABLE PRODUCT_CATEGORY(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (id)
    );
 
     ALTER TABLE PRODUCT_DESCRIPTION ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES PRODUCT (id) on delete cascade;	
     ALTER TABLE PRODUCT ADD CONSTRAINT fk_product_sub_category_id FOREIGN KEY (product_sub_cat_id) REFERENCES PRODUCT_SUB_CATEGORY (id);
     ALTER TABLE PRODUCT_SUB_CATEGORY ADD CONSTRAINT fk_product_category_id FOREIGN KEY (product_category_id) REFERENCES PRODUCT_CATEGORY (id);
     
INSERT INTO PRODUCT_CATEGORY (category_name,description) VALUES ('FRUITS', 'fruits frais de saisons');

INSERT INTO PRODUCT_CATEGORY (category_name,description) VALUES ('LEGUMES', 'légumes frais de saisons');

INSERT INTO PRODUCT_SUB_CATEGORY (sub_category_name,description, product_category_id) values ('FRUITS ROUGES', 'walo', 1);

INSERT INTO PRODUCT_SUB_CATEGORY (sub_category_name,description,product_category_id) values ('FRUITS A NOYAUX', 'walo', 1);

INSERT INTO PRODUCT_SUB_CATEGORY (sub_category_name,description, product_category_id) values ('FRUITS EXOTIQUES ', 'walo' , 1);

INSERT INTO PRODUCT_SUB_CATEGORY (sub_category_name,description, product_category_id) values ('champognons', 'walo', 2);

INSERT INTO PRODUCT_SUB_CATEGORY (sub_category_name,description,product_category_id) values ('légumes feuilles', 'walo', 2);

INSERT INTO PRODUCT_SUB_CATEGORY (sub_category_name,description, product_category_id) values ('légumes racines ', 'walo' , 2);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Barquette Mirabelle - 350g',3.5,'Portugal / Espagne','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','modéré','cherry-plum-5366060_640.jpg',1);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Barquette de cerise - Gard',3.9,'Portugal / Espagne','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','cherry-3074284_640.jpg',2);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Fraises Mariguette - 250g',4.5,'MAROC','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','modéré','Fraises250g_2_9f3139dc-8d15-4fac-8e06-c55db28a0aaa.jpg',2);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Fraises rondes Dream - 400g',3.5,'Espagne','De belles FRAISES savoureuses, parce que sinon c est pas vraiment l été !',200,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','Fraises250GV2_1.jpg',1);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Barquette de framboises - 125g',3.7,'Portugal / Espagne','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',400,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','framboises_fp_1.jpg',3);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Myrtilles - 125g',2.7,'Portugal','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','modéré','Petit-pot-de-myrtilles.jpg',3);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Mangue - 125g',2.5,'ESPAGNE','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','Mangue_1_ade060ad-07e8-450d-8e25-2f85b8323b69.jpg',1);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Nectarine - 125g',1.5,'ESPAGNE','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','fruit-3533619_640.jpg',2);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Prunes - 125g',4,'MAROC','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','plums-2724160_640.jpg',3);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Pêche - 125g',3,'ESPAGNE','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','pear-1620467_640.jpg',1);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Pomme - 125g',4.99,'MAROC','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','apples-490474_640.jpg',1);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Raisin - 125g',5,'MAROC','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','grapes-1283162_640.jpg',1);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
values ('Champignon de paris',3.5,'Maroc','Tendre et goûteux ce champignon de couche se cuisine facilement.',100,'3 ou 4 jours au réfrigérateur','En France','champignon-de-paris.jpg',4);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Truffe',3.9,'Portugal / Espagne','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','truffe.jpg',4);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Morille - 250g',4.5,'MAROC','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','modéré','morille.jpg',4);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Oignon Primeur - 400g',3.5,'Espagne','De belles FRAISES savoureuses, parce que sinon c est pas vraiment l été !',200,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','oignon-blanc-botte.jpg',4);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Carotte primeur - 125g',3.7,'Portugal / Espagne','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',400,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','carotte.jpg',5);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Rutabaga - 125g',2.7,'Portugal','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','modéré','20210719A-FR2-favpng.com-pnghunter.com-.jpg',5);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Topinambure - 125g',2.5,'ESPAGNE','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','istock_aardpeer.jpg',5);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Choux de bruxelles - 125g',1.5,'ESPAGNE','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','Choux-de-Bruxelles-sautes-au-beurre.jpg',5);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Choux kale- 125g',4,'MAROC','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','laura-johnston-637056-unsplash-1100x715.jpg',5);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Persile - 125g',3,'ESPAGNE','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','persil.jpg',6);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Oseille - 125g',4.99,'MAROC','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','thinkstockphotos-519836542.jpg',6);

INSERT INTO PRODUCT (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)  values ('Echalote - 125g',5,'MAROC','De belles myrtilles savoureuses, parce que sinon c est pas vraiment l été !',100,'Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.','Agriculture raisonnée','echalotes-de-plougoulm-ebarbees-a-la-main-250g.jpg',6);

