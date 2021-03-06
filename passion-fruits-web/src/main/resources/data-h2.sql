drop table if exists PRODUCT_DESCRIPTION;
CREATE TABLE PRODUCT_DESCRIPTION
(
    id INT
    UNSIGNED NOT NULL AUTO_INCREMENT,
    description text NOT NULL,
    product_id INT UNSIGNED NOT NULL,
    PRIMARY KEY
    (id)
    );
    drop table if exists PRODUCT;
    CREATE TABLE PRODUCT
    (
        id int
        UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR
        (100) NOT NULL,
    price decimal
        (7,2) unsigned DEFAULT 0,
    origin VARCHAR
        (50),
    description text,
    nutrition_score decimal
        (5,2) unsigned DEFAULT 0,
    conservation VARCHAR
        (200),
    agriculture VARCHAR
        (50),
    picture VARCHAR
        (100),
    product_sub_cat_id INT UNSIGNED NOT NULL,
    PRIMARY KEY
        (id)
    );
        drop table if exists PRODUCT_SUB_CATEGORY;
        CREATE TABLE PRODUCT_SUB_CATEGORY
        (
            id INT
            UNSIGNED NOT NULL AUTO_INCREMENT,
 		sub_category_name VARCHAR
            (100) NOT NULL UNIQUE,
 		description VARCHAR
            (50),
 		product_category_id int UNSIGNED NOT NULL,
 	PRIMARY KEY
            (id)
);
            drop table if exists PRODUCT_CATEGORY;

            CREATE TABLE PRODUCT_CATEGORY
            (
                id INT
                UNSIGNED NOT NULL AUTO_INCREMENT,
    category_name VARCHAR
                (100) NOT NULL UNIQUE,
    description VARCHAR
                (50) DEFAULT NULL,
    PRIMARY KEY
                (id)
    );

                ALTER TABLE PRODUCT_DESCRIPTION ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES PRODUCT (id) on delete cascade;
                ALTER TABLE PRODUCT ADD CONSTRAINT fk_product_sub_category_id FOREIGN KEY (product_sub_cat_id) REFERENCES PRODUCT_SUB_CATEGORY (id);
                ALTER TABLE PRODUCT_SUB_CATEGORY ADD CONSTRAINT fk_product_category_id FOREIGN KEY (product_category_id) REFERENCES PRODUCT_CATEGORY (id);

                INSERT INTO PRODUCT_CATEGORY
                    (category_name,description)
                VALUES
                    ('FRUITS', 'fruits frais de saisons');

                INSERT INTO PRODUCT_CATEGORY
                    (category_name,description)
                VALUES
                    ('LEGUMES', 'l??gumes frais de saisons');

                INSERT INTO PRODUCT_SUB_CATEGORY
                    (sub_category_name,description, product_category_id)
                values
                    ('FRUITS ROUGES', 'walo', 1);

                INSERT INTO PRODUCT_SUB_CATEGORY
                    (sub_category_name,description,product_category_id)
                values
                    ('FRUITS A NOYAUX', 'walo', 1);

                INSERT INTO PRODUCT_SUB_CATEGORY
                    (sub_category_name,description, product_category_id)
                values
                    ('FRUITS EXOTIQUES ', 'walo' , 1);

                INSERT INTO PRODUCT_SUB_CATEGORY
                    (sub_category_name,description, product_category_id)
                values
                    ('champognons', 'walo', 2);

                INSERT INTO PRODUCT_SUB_CATEGORY
                    (sub_category_name,description,product_category_id)
                values
                    ('l??gumes feuilles', 'walo', 2);

                INSERT INTO PRODUCT_SUB_CATEGORY
                    (sub_category_name,description, product_category_id)
                values
                    ('l??gumes racines ', 'walo' , 2);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Barquette Mirabelle - 350g', 3.5, 'Portugal / Espagne', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'mod??r??', 'cherry-plum-5366060_640.jpg', 1);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Barquette de cerise - Gard', 3.9, 'Portugal / Espagne', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'cherry-3074284_640.jpg', 2);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Fraises Mariguette - 250g', 4.5, 'MAROC', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'mod??r??', 'Fraises250g_2_9f3139dc-8d15-4fac-8e06-c55db28a0aaa.jpg', 2);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Fraises rondes Dream - 400g', 3.5, 'Espagne', 'De belles FRAISES savoureuses, parce que sinon c est pas vraiment l ??t?? !', 200, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'Fraises250GV2_1.jpg', 1);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Barquette de framboises - 125g', 3.7, 'Portugal / Espagne', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 400, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'framboises_fp_1.jpg', 3);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Myrtilles - 125g', 2.7, 'Portugal', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'mod??r??', 'Petit-pot-de-myrtilles.jpg', 3);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Mangue - 125g', 2.5, 'ESPAGNE', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'Mangue_1_ade060ad-07e8-450d-8e25-2f85b8323b69.jpg', 1);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Nectarine - 125g', 1.5, 'ESPAGNE', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'fruit-3533619_640.jpg', 2);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Prunes - 125g', 4, 'MAROC', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'plums-2724160_640.jpg', 3);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('P??che - 125g', 3, 'ESPAGNE', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'pear-1620467_640.jpg', 1);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Pomme - 125g', 4.99, 'MAROC', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'apples-490474_640.jpg', 1);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Raisin - 125g', 5, 'MAROC', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'grapes-1283162_640.jpg', 1);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Champignon de paris', 3.5, 'Maroc', 'Tendre et go??teux ce champignon de couche se cuisine facilement.', 100, '3 ou 4 jours au r??frig??rateur', 'En France', 'champignon-de-paris.jpg', 4);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Truffe', 3.9, 'Portugal / Espagne', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'truffe.jpg', 4);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Morille - 250g', 4.5, 'MAROC', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'mod??r??', 'morille.jpg', 4);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Oignon Primeur - 400g', 3.5, 'Espagne', 'De belles FRAISES savoureuses, parce que sinon c est pas vraiment l ??t?? !', 200, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'oignon-blanc-botte.jpg', 4);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Carotte primeur - 125g', 3.7, 'Portugal / Espagne', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 400, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'carotte.jpg', 5);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Rutabaga - 125g', 2.7, 'Portugal', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'mod??r??', '20210719A-FR2-favpng.com-pnghunter.com-.jpg', 5);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Topinambure - 125g', 2.5, 'ESPAGNE', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'istock_aardpeer.jpg', 5);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Choux de bruxelles - 125g', 1.5, 'ESPAGNE', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'Choux-de-Bruxelles-sautes-au-beurre.jpg', 5);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Choux kale- 125g', 4, 'MAROC', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'laura-johnston-637056-unsplash-1100x715.jpg', 5);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Persile - 125g', 3, 'ESPAGNE', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'persil.jpg', 6);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Oseille - 125g', 4.99, 'MAROC', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'thinkstockphotos-519836542.jpg', 6);

                INSERT INTO PRODUCT
                    (name,price,origin,description,nutrition_score,conservation,agriculture,picture,product_sub_cat_id)
                values
                    ('Echalote - 125g', 5, 'MAROC', 'De belles myrtilles savoureuses, parce que sinon c est pas vraiment l ??t?? !', 100, 'Ce produit se conserve au r??frig??rateur. Voir date limite de conservation sur l???emballage.', 'Agriculture raisonn??e', 'echalotes-de-plougoulm-ebarbees-a-la-main-250g.jpg', 6);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 1);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 1);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 1);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 2);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 2);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 2);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 3);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 3);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 3);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 4);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 4);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 4);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 5);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 5);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 5);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 6);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 6);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 6);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 7);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 7);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 7);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 8);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 8);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 8);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 9);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 9);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 9);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 10);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 10);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 10);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 11);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 11);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 11);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 12);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 12);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 12);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 13);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 13);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 13);

                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 1', 14);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 2', 14);
                INSERT INTO PRODUCT_DESCRIPTION
                    (DESCRIPTION, PRODUCT_ID)
                VALUES
                    ('Description 3', 14);


     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     