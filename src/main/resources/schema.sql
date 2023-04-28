CREATE TABLE BOOK
(
	ID BIGINT NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	AUTHOR VARCHAR(255) NOT NULL,
	PRIMARY KEY (ID)
);


INSERT INTO OWNER (ID, NAME, BIRTH_DATE)
VALUES(1, 'John', CURRENT_DATE());
INSERT INTO OWNER (ID, NAME, BIRTH_DATE)
VALUES(2, 'Ryan', CURRENT_DATE());
INSERT INTO OWNER (ID, NAME, BIRTH_DATE)
VALUES(3, 'Chris', CURRENT_DATE());



INSERT INTO SHOP (ID, SHOP_NAME, OWNER_ID)
VALUES(1, 'Malad', 1);
INSERT INTO SHOP (ID, SHOP_NAME, OWNER_ID)
VALUES(2, 'Andheri', 1);
INSERT INTO SHOP (ID, SHOP_NAME, OWNER_ID)
VALUES(3, 'Bandra', 1);
INSERT INTO SHOP (ID, SHOP_NAME, OWNER_ID)
VALUES(4, 'Dadar', 2);
INSERT INTO SHOP (ID, SHOP_NAME, OWNER_ID)
VALUES(5, 'Vikhroli', 3);
INSERT INTO SHOP (ID, SHOP_NAME, OWNER_ID)
VALUES(6, 'Thane', 3);