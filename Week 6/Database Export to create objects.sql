----------------------------------------------------------  
File created - Monday-November-23-2020   
------------------------------------------------------------------------------------------------------------------  
-- DDL for Type ADDRESS_TYPE
--------------------------------------------------------

  CREATE OR REPLACE TYPE "ADDRESS_TYPE" AS OBJECT (
street		VARCHAR2(25),
city		VARCHAR2(25),
country		VARCHAR2(20) )
/

--------------------------------------------------------
--  DDL for Type CLASSROOM_TYPE
--------------------------------------------------------

  CREATE OR REPLACE TYPE "CLASSROOM_TYPE" AS OBJECT(
room_number VARCHAR2(4),
capacity NUMBER(6),
description VARCHAR2(200));
/

--------------------------------------------------------
--  DDL for Type CLASSROOM_VARRAY_TYPE
--------------------------------------------------------

  CREATE OR REPLACE TYPE "CLASSROOM_VARRAY_TYPE" AS VARRAY(50) OF classroom_type;
/
--------------------------------------------------------
--  DDL for Type INVOICE_ITEM_TYPE
--------------------------------------------------------

  CREATE OR REPLACE TYPE "INVOICE_ITEM_TYPE" AS OBJECT(
student_surname		VARCHAR2(15),
course_title		VARCHAR2(30),
start_date			DATE,
end_date			DATE,
amount				NUMBER(10,2));
/
--------------------------------------------------------
--  DDL for Type INVOICE_ITEM_TABLE_TYPE
--------------------------------------------------------

  CREATE OR REPLACE TYPE "INVOICE_ITEM_TABLE_TYPE" AS TABLE OF invoice_item_type;
/
--------------------------------------------------------
--  DDL for Type STATE_TYPE
--------------------------------------------------------

  CREATE OR REPLACE TYPE "STATE_TYPE" as object(
state varchar2(25),
country varchar2(25));
/

--------------------------------------------------------
--  DDL for Table ADDRESSES
--------------------------------------------------------

  CREATE TABLE "ADDRESSES" OF "ADDRESS_TYPE";
--------------------------------------------------------
--  DDL for Table ATTENDANCE
--------------------------------------------------------

  CREATE TABLE "ATTENDANCE" 
   (	"OFFERING_ID" NUMBER(6,0), 
	"STUDENT_ID" NUMBER(6,0), 
	"START_DATE" DATE, 
	"EVALUATION" NUMBER(6,2), 
	"AMOUNT_PAID" NUMBER(10,2)
   );
--------------------------------------------------------
--  DDL for Table COMPANIES
--------------------------------------------------------

  CREATE TABLE "COMPANIES" 
   (	"COMPANY_ID" NUMBER(6,0), 
	"COMPANY_NAME" VARCHAR2(15), 
	"CITY" VARCHAR2(12), 
	"INDUSTRY" VARCHAR2(15), 
	"NO_EMPLOYEE" NUMBER(5,0), 
	"REVENUE" NUMBER(10,2), 
	"TRAINING_BUDGET" NUMBER(10,2)
   ) ;
--------------------------------------------------------
--  DDL for Table COURSES
--------------------------------------------------------

  CREATE TABLE "COURSES" 
   (	"COURSE_ID" NUMBER(6,0), 
	"TITLE" VARCHAR2(30), 
	"DURATION" NUMBER(6,0), 
	"COST" NUMBER(10,2), 
	"SUBJECT_ID" NUMBER(6,0), 
	"BROCHURE" BFILE
   ) ;
--------------------------------------------------------
--  DDL for Table CUSTOMERS
--------------------------------------------------------

  CREATE TABLE "CUSTOMERS" 
   (	"CUSTOMER_ID" NUMBER(6,0), 
	"CUSTOMER_NAME" VARCHAR2(25), 
	"ADDRESS" REF "ADDRESS_TYPE" , 
	SCOPE FOR ("ADDRESS") IS "ADDRESSES" 
   );
--------------------------------------------------------
--  DDL for Table INSTRUCTORS
--------------------------------------------------------

  CREATE TABLE "INSTRUCTORS" 
   (	"INSTRUCTOR_ID" NUMBER(6,0), 
	"INSTRUCTOR_NAME" VARCHAR2(15), 
	"ADDRESS" REF "ADDRESS_TYPE" , 
	"SALARY" NUMBER(10,2), 
	"COMMISSION" NUMBER(10,2), 
	"MENTOR_ID" NUMBER(6,0), 
	"DATE_HIRED" DATE, 
	"PROFILE" CLOB, 
	SCOPE FOR ("ADDRESS") IS "ADDRESSES" 
   );
--------------------------------------------------------
--  DDL for Table INVOICES
--------------------------------------------------------

  CREATE TABLE "INVOICES" 
   (	"INVOICE_NUMBER" NUMBER(6,0), 
	"COMPANY_ID" NUMBER(6,0), 
	"BILLING_DATE" DATE, 
	"DUE_DATE" DATE, 
	"INVOICE_ITEM" "INVOICE_ITEM_TABLE_TYPE" 
   ) NESTED TABLE invoice_item STORE AS invoice_item_table;
   
--------------------------------------------------------
--  DDL for Table OFFERINGS
--------------------------------------------------------

  CREATE TABLE "OFFERINGS" 
   (	"OFFERING_ID" NUMBER(6,0), 
	"COURSE_ID" NUMBER(6,0), 
	"SITE_ID" NUMBER(6,0), 
	"INSTRUCTOR_ID" NUMBER(6,0), 
	"START_DATE" DATE, 
	"MAX_NO_STUDENTS" NUMBER(6,0)
   );

--------------------------------------------------------
--  DDL for Table STATES
--------------------------------------------------------

  CREATE TABLE "STATES" OF "STATE_TYPE";

--------------------------------------------------------
--  DDL for Table SITES
--------------------------------------------------------

  CREATE TABLE "SITES" 
   (	"SITE_ID" NUMBER(6,0), 
	"ADDRESS" "ADDRESS_TYPE" , 
	"CLASSROOM" "CLASSROOM_VARRAY_TYPE" , 
	"LOCATION" VARCHAR2(12), 
	"STATE_REF" REF "STATE_TYPE" , 
	SCOPE FOR ("STATE_REF") IS "STATES" 
   );

--------------------------------------------------------
--  DDL for Table STUDENTS
--------------------------------------------------------

  CREATE TABLE "STUDENTS" 
   (	"STUDENT_ID" NUMBER(6,0), 
	"STUDENT_FIRSTNAME" VARCHAR2(20), 
	"STUDENT_SURNAME" VARCHAR2(20), 
	"ADDRESS" REF "ADDRESS_TYPE" , 
	"PHONE_NUMBER" VARCHAR2(15), 
	"FAX_NUMBER" VARCHAR2(15), 
	"GENDER" CHAR(1), 
	"DATE_OF_BIRTH" DATE, 
	"DESCRIPTION" VARCHAR2(250), 
	"PREFERRED_LANGUAGE" VARCHAR2(2), 
	"VOUCHER" CHAR(1), 
	"COMPANY_ID" NUMBER(6,0), 
	SCOPE FOR ("ADDRESS") IS "ADDRESSES" 
   );
--------------------------------------------------------
--  DDL for Table SUBJECT_AREAS
--------------------------------------------------------

  CREATE TABLE "SUBJECT_AREAS" 
   (	"SUBJECT_ID" NUMBER(6,0), 
	"SUBJECT_NAME" VARCHAR2(30)
   );

REM INSERTING into ADDRESSES
SET DEFINE OFF;
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('111 BAY STATE ROAD','BOSTON','USA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('111 VALLEY WAY','SAN FERNANDO','USA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('4545 ORACLE DRIVE','SAN FRANCISCO','USA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('22 GOLDEN GATE DRIVE','SAN FRANCISCO','USA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('77 ELM STREET','NEWARK','USA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('544 42ND STREET','NEW YORK','USA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('111 BEACHCOMBER PLACE','OCEANSIDE','USA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('25 MISSION WAY','SAN DIEGO','USA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('177 AIRPORT ROAD','NEWARK','USA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('5567 KNIGHTSBRIDGE COURT','LONDON','UK');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('111 CRUISING WAY','TORTOLA','BVI');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('45 KING STREET','OTTAWA','CANADA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('45555 BIG STREET','DALLAS','USA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('AVENUE CHAMPS-ELYSEES 456','PARIS','FRANCE');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('562 HOCKEY STREET','TORONTO','CANADA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('4242 MISTY LANE','SEATTLE','USA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('KUNGSGATAN 56','STOCKHOLM','SWEDEN');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('11-882 KAMEHAMEHA HIGHWAY','HAWAII','USA');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('333 SAN JUAN BLVD','SAN JUAN','PUERTO RICO');
Insert into ADDRESSES (STREET,CITY,COUNTRY) values ('7500 IMPERIAL BLVD','LOS ANGELES','USA');

REM INSERTING into ATTENDANCE
SET DEFINE OFF;
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1001,1111,to_date('01-JAN-02','DD-MON-RR'),4,1000);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1002,2299,to_date('05-JAN-02','DD-MON-RR'),null,1000);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1003,4568,to_date('10-JAN-02','DD-MON-RR'),3,1200);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1002,6789,to_date('15-JAN-02','DD-MON-RR'),4,1150);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1005,9835,to_date('25-JAN-02','DD-MON-RR'),3,1995);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1006,9842,to_date('05-FEB-02','DD-MON-RR'),4,1000);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1006,1199,to_date('10-FEB-02','DD-MON-RR'),4,1200);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1006,3452,to_date('15-FEB-02','DD-MON-RR'),2,200);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1007,8390,to_date('20-FEB-02','DD-MON-RR'),4,1200);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1007,6474,to_date('25-FEB-02','DD-MON-RR'),4,900);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1008,8390,to_date('05-MAR-02','DD-MON-RR'),4,1000);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1003,1199,to_date('10-MAR-02','DD-MON-RR'),4,1000);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1001,6738,to_date('15-MAR-02','DD-MON-RR'),4,850);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1001,5556,to_date('20-MAR-02','DD-MON-RR'),4,1995);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1001,6263,to_date('25-MAR-02','DD-MON-RR'),1,1995);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1002,2346,to_date('30-MAR-02','DD-MON-RR'),4,1995);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1003,6901,to_date('05-APR-02','DD-MON-RR'),4,1200);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1003,7652,to_date('10-APR-02','DD-MON-RR'),4,1200);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1003,4631,to_date('15-APR-02','DD-MON-RR'),3,1200);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1008,3459,to_date('20-APR-02','DD-MON-RR'),4,1995);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1004,2299,to_date('25-APR-02','DD-MON-RR'),3,1995);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1004,6789,to_date('30-APR-02','DD-MON-RR'),4,1995);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1004,6263,to_date('05-MAY-02','DD-MON-RR'),4,1995);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1007,9842,to_date('10-MAY-02','DD-MON-RR'),3,1200);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1007,4631,to_date('15-MAY-02','DD-MON-RR'),3,1200);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1005,6738,to_date('20-MAY-02','DD-MON-RR'),4,1000);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1005,3459,to_date('25-MAY-02','DD-MON-RR'),3,1995);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1006,6474,to_date('30-MAY-02','DD-MON-RR'),2,1200);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1006,9835,to_date('05-JUN-02','DD-MON-RR'),4,1000);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1007,9835,to_date('10-JUN-02','DD-MON-RR'),4,1200);
Insert into ATTENDANCE (OFFERING_ID,STUDENT_ID,START_DATE,EVALUATION,AMOUNT_PAID) values (1009,3459,to_date('15-JUN-02','DD-MON-RR'),3,4000);

REM INSERTING into COMPANIES
SET DEFINE OFF;
Insert into COMPANIES (COMPANY_ID,COMPANY_NAME,CITY,INDUSTRY,NO_EMPLOYEE,REVENUE,TRAINING_BUDGET) values (10,'USCABLES','WASHINGTON','MANUFACTURING',250,4000000,50000);
Insert into COMPANIES (COMPANY_ID,COMPANY_NAME,CITY,INDUSTRY,NO_EMPLOYEE,REVENUE,TRAINING_BUDGET) values (20,'KODAK','HOUSTON','MANUFACTURING',2500,10000000,100000);
Insert into COMPANIES (COMPANY_ID,COMPANY_NAME,CITY,INDUSTRY,NO_EMPLOYEE,REVENUE,TRAINING_BUDGET) values (30,'KLM','AMSTERDAM','SERVICE',5000,11000000,990000);
Insert into COMPANIES (COMPANY_ID,COMPANY_NAME,CITY,INDUSTRY,NO_EMPLOYEE,REVENUE,TRAINING_BUDGET) values (40,'HAMBRO','LONDON','SERVICE',2000,6000000,500000);
Insert into COMPANIES (COMPANY_ID,COMPANY_NAME,CITY,INDUSTRY,NO_EMPLOYEE,REVENUE,TRAINING_BUDGET) values (50,'FORD','DETROIT','MANUFACTURING',8000,20000000,100000);
Insert into COMPANIES (COMPANY_ID,COMPANY_NAME,CITY,INDUSTRY,NO_EMPLOYEE,REVENUE,TRAINING_BUDGET) values (60,'CITYBANK','BOSTON','FINANCE',3000,5000000,200000);
Insert into COMPANIES (COMPANY_ID,COMPANY_NAME,CITY,INDUSTRY,NO_EMPLOYEE,REVENUE,TRAINING_BUDGET) values (70,'DISNEY','ORLANDO','ARTS',2500,10000000,300000);

REM INSERTING into COURSES
SET DEFINE OFF;
Insert into COURSES (COURSE_ID,TITLE,DURATION,COST,SUBJECT_ID,BROCHURE) values (215,'UNIX',5,1995,10,null);
Insert into COURSES (COURSE_ID,TITLE,DURATION,COST,SUBJECT_ID,BROCHURE) values (315,'C++',5,1995,20,null);
Insert into COURSES (COURSE_ID,TITLE,DURATION,COST,SUBJECT_ID,BROCHURE) values (415,'ADA',3,1500,20,null);
Insert into COURSES (COURSE_ID,TITLE,DURATION,COST,SUBJECT_ID,BROCHURE) values (515,'ORACLE',5,1995,30,null);
Insert into COURSES (COURSE_ID,TITLE,DURATION,COST,SUBJECT_ID,BROCHURE) values (615,'SYBASE',3,1200,30,null);
Insert into COURSES (COURSE_ID,TITLE,DURATION,COST,SUBJECT_ID,BROCHURE) values (115,'DOS',3,500,10,null);
Insert into COURSES (COURSE_ID,TITLE,DURATION,COST,SUBJECT_ID,BROCHURE) values (715,'VMS',3,995,10,null);
Insert into COURSES (COURSE_ID,TITLE,DURATION,COST,SUBJECT_ID,BROCHURE) values (815,'NETWARE',5,1995,40,null);
Insert into COURSES (COURSE_ID,TITLE,DURATION,COST,SUBJECT_ID,BROCHURE) values (915,'INFORMIX',3,1200,30,null);

REM INSERTING into CUSTOMERS
SET DEFINE OFF;
INSERT INTO customers (customer_id, customer_name, address)
 SELECT 10000,'ALAN', REF(b)
 FROM addresses b
 WHERE street = 'AVENUE CHAMPS-ELYSEES 456';

INSERT INTO customers (customer_id, customer_name, address)
 SELECT 10001,'BETTY', REF(b)
 FROM addresses b
 WHERE street = '5567 KNIGHTSBRIDGE COURT';

INSERT INTO customers (customer_id, customer_name, address)
 SELECT 10002,'CARY', REF(b)
 FROM addresses b
 WHERE street = '11-882 KAMEHAMEHA HIGHWAY';

REM INSERTING into INSTRUCTORS
SET DEFINE OFF;
INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (835, 'SPARKS', 4000 , 200, 978, '16-DEC-1984');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='177 AIRPORT ROAD')
WHERE instructor_id = 835;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (978, 'STEEL', 5000 , 250, 222, '16-JAN-1980');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='177 AIRPORT ROAD')
WHERE instructor_id = 978;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (222, 'CAINE', 5500 , 350, NULL, '02-NOV-1976');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='333 SAN JUAN BLVD')
WHERE instructor_id = 222;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (243, 'TUCKER', 2000 , NULL, 835, '18-DEC-1990');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='11-882 KAMEHAMEHA HIGHWAY')
WHERE instructor_id = 243;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (263, 'JOHNSON', 4000 , NULL, 835, '18-JUL-1992');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='562 HOCKEY STREET')
WHERE instructor_id = 263;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (515, 'SHELLEY', 3500 , 200, 700, '20-JAN-1991');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='4242 MISTY LANE')
WHERE instructor_id = 515;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (453, 'LODGE', 2500 , 100, 835, '14-SEP-1988');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='4242 MISTY LANE')
WHERE instructor_id = 453;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (700, 'WAYNE', 4500 , 300, NULL, '16-MAY-1981');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='AVENUE CHAMPS-ELYSEES 456')
WHERE instructor_id = 700;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (628, 'MONROE', 3000 , NULL, 700, '16-JUN-1984');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='5567 KNIGHTSBRIDGE COURT')
WHERE instructor_id = 628;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (790, 'NEWMAN', 3100 , 300, 700, '16-DEC-1982');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='544 42ND STREET')
WHERE instructor_id = 790;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (795, 'BOGART', 3200 , NULL, 700, '16-DEC-1983');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='111 CRUISING WAY')
WHERE instructor_id = 795;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (560, 'LAUREL', 5200 , 200, 978, '16-DEC-1983');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='333 SAN JUAN BLVD')
WHERE instructor_id = 560;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (123, 'FLINTSTONE,FRED', 1000 , NULL, 978, '16-JUN-1989');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='177 AIRPORT ROAD')
WHERE instructor_id = 123;

INSERT INTO instructors 
(instructor_id, instructor_name, salary, commission, mentor_id, date_hired)
VALUES (111, 'BROWN', 1000 , NULL, 978, '16-JUN-1989');

UPDATE instructors SET address = 
(select ref(a) FROM addresses a
WHERE a.street='111 BAY STATE ROAD')
WHERE instructor_id = 111;

REM INSERTING into INVOICES
SET DEFINE OFF;
INSERT INTO invoices
(invoice_number, company_id, billing_date, invoice_item)
VALUES (10007, 30, '01-OCT-2002',
invoice_item_table_type(
invoice_item_type('GREEN','ORACLE','15-JUL-1997',NULL,1250),
invoice_item_type('ADAMS','UNIX','08-JUL-1997',NULL,1250)));

INSERT INTO invoices
(invoice_number, company_id, billing_date, invoice_item)
VALUES (10000, 10, '04-OCT-2002',
invoice_item_table_type(
invoice_item_type('ROSE','C++','15-JUL-1997',NULL,1250)));

INSERT INTO invoices
(invoice_number, company_id, billing_date, invoice_item)
VALUES (10001, 20, '01-OCT-2002',
invoice_item_table_type(
invoice_item_type('BROWN','C++','15-JUL-1997',NULL,1250),
invoice_item_type('TYLER','C++','15-JUL-1997',NULL,1250),
invoice_item_type('CARTER','C++','08-JUL-1997',NULL,1250)));

INSERT INTO invoices
(invoice_number, company_id, billing_date, invoice_item)
VALUES (10004, 40, '01-OCT-2002',
invoice_item_table_type(
invoice_item_type('CRICK','C++','15-JUL-1997',NULL,1250)));

REM INSERTING into OFFERINGS
SET DEFINE OFF;
Insert into OFFERINGS (OFFERING_ID,COURSE_ID,SITE_ID,INSTRUCTOR_ID,START_DATE,MAX_NO_STUDENTS) values (1001,315,1,700,to_date('16-DEC-94','DD-MON-RR'),24);
Insert into OFFERINGS (OFFERING_ID,COURSE_ID,SITE_ID,INSTRUCTOR_ID,START_DATE,MAX_NO_STUDENTS) values (1002,315,3,263,to_date('16-JUL-95','DD-MON-RR'),20);
Insert into OFFERINGS (OFFERING_ID,COURSE_ID,SITE_ID,INSTRUCTOR_ID,START_DATE,MAX_NO_STUDENTS) values (1003,915,7,560,to_date('23-NOV-96','DD-MON-RR'),30);
Insert into OFFERINGS (OFFERING_ID,COURSE_ID,SITE_ID,INSTRUCTOR_ID,START_DATE,MAX_NO_STUDENTS) values (1004,215,2,263,to_date('26-SEP-95','DD-MON-RR'),24);
Insert into OFFERINGS (OFFERING_ID,COURSE_ID,SITE_ID,INSTRUCTOR_ID,START_DATE,MAX_NO_STUDENTS) values (1005,815,3,978,to_date('15-OCT-95','DD-MON-RR'),20);
Insert into OFFERINGS (OFFERING_ID,COURSE_ID,SITE_ID,INSTRUCTOR_ID,START_DATE,MAX_NO_STUDENTS) values (1006,915,4,560,to_date('04-JAN-96','DD-MON-RR'),22);
Insert into OFFERINGS (OFFERING_ID,COURSE_ID,SITE_ID,INSTRUCTOR_ID,START_DATE,MAX_NO_STUDENTS) values (1007,615,4,453,to_date('30-SEP-95','DD-MON-RR'),30);
Insert into OFFERINGS (OFFERING_ID,COURSE_ID,SITE_ID,INSTRUCTOR_ID,START_DATE,MAX_NO_STUDENTS) values (1008,515,5,835,to_date('20-JUN-95','DD-MON-RR'),24);
Insert into OFFERINGS (OFFERING_ID,COURSE_ID,SITE_ID,INSTRUCTOR_ID,START_DATE,MAX_NO_STUDENTS) values (1009,315,4,790,to_date('21-JUN-95','DD-MON-RR'),24);
Insert into OFFERINGS (OFFERING_ID,COURSE_ID,SITE_ID,INSTRUCTOR_ID,START_DATE,MAX_NO_STUDENTS) values (1010,315,4,null,to_date('30-AUG-97','DD-MON-RR'),24);

REM INSERTING into STATES
SET DEFINE OFF;
Insert into STATES (STATE,COUNTRY) values ('ALBERTA','CANADA');
Insert into STATES (STATE,COUNTRY) values ('DELHI','INDIA');
Insert into STATES (STATE,COUNTRY) values ('BIHAR','INDIA');
Insert into STATES (STATE,COUNTRY) values ('VICTORIA','AUSTRALIA');
Insert into STATES (STATE,COUNTRY) values ('QUEENSLAND','AUSTRALIA');

REM INSERTING into SITES
SET DEFINE OFF;
Insert into SITES (SITE_ID,ADDRESS,CLASSROOM,LOCATION) values (1,ADDRESS_TYPE('3 PLACE DE CONCORDE','PARIS','FRANCE'),CLASSROOM_VARRAY_TYPE(CLASSROOM_TYPE('1',20,NULL),CLASSROOM_TYPE('2',24,NULL),CLASSROOM_TYPE('3',30,NULL)),'EUROPE CTR');

UPDATE sites SET state_ref = 
(select ref(a) FROM states a
WHERE a.state='ALBERTA')
WHERE site_id = 1;

Insert into SITES (SITE_ID,ADDRESS,CLASSROOM,LOCATION) values (2,ADDRESS_TYPE('1600 PENNSYLVANIA','WASHINGTON','USA'),CLASSROOM_VARRAY_TYPE(CLASSROOM_TYPE('1',20,NULL),CLASSROOM_TYPE('2',24,NULL)),'US EAST');

UPDATE sites SET state_ref = 
(select ref(a) FROM states a
WHERE a.state='DELHI')
WHERE site_id = 2;

Insert into SITES (SITE_ID,ADDRESS,CLASSROOM,LOCATION) values (3,ADDRESS_TYPE('22 TRAFALGAR SQUARE','LONDON','UK'),CLASSROOM_VARRAY_TYPE(CLASSROOM_TYPE('1',20,NULL),CLASSROOM_TYPE('2',24,NULL),CLASSROOM_TYPE('3',24,NULL)),'EUROPE WEST');

UPDATE sites SET state_ref = 
(select ref(a) FROM states a
WHERE a.state='BIHAR')
WHERE site_id = 3;

Insert into SITES (SITE_ID,ADDRESS,CLASSROOM,LOCATION) values (4,ADDRESS_TYPE('KUNGSGATAN 26','STOCKHOLM','SWEDEN'),CLASSROOM_VARRAY_TYPE(CLASSROOM_TYPE('1',20,NULL)),'EUROPE NORTH');

UPDATE sites SET state_ref = 
(select ref(a) FROM states a
WHERE a.state='VICTORIA')
WHERE site_id = 4;

Insert into SITES (SITE_ID,ADDRESS,CLASSROOM,LOCATION) values (5,ADDRESS_TYPE('343 ELM STREET','OTTAWA','CANADA'),CLASSROOM_VARRAY_TYPE(CLASSROOM_TYPE('1',20,NULL),CLASSROOM_TYPE('2',20,NULL),CLASSROOM_TYPE('3',20,NULL)),'CANADA CTR');

UPDATE sites SET state_ref = 
(select ref(a) FROM states a
WHERE a.state='QUEENSLAND')
WHERE site_id = 5;

Insert into SITES (SITE_ID,ADDRESS,CLASSROOM,LOCATION) values (6,ADDRESS_TYPE('101 BOYLSTON STREET','BOSTON','USA'),CLASSROOM_VARRAY_TYPE(CLASSROOM_TYPE('1',20,NULL),CLASSROOM_TYPE('2',24,NULL)),'US EAST');
Insert into SITES (SITE_ID,ADDRESS,CLASSROOM,LOCATION) values (7,ADDRESS_TYPE('1010 SEPULVEDA','LOS ANGELES','USA'),CLASSROOM_VARRAY_TYPE(CLASSROOM_TYPE('1',20,NULL),CLASSROOM_TYPE('2',20,NULL),CLASSROOM_TYPE('3',20,NULL)),'US WEST');
Insert into SITES (SITE_ID,ADDRESS,CLASSROOM,LOCATION) values (8,ADDRESS_TYPE('101 YOUNGE STREET','TORONTO','CANADA'),CLASSROOM_VARRAY_TYPE(CLASSROOM_TYPE('1',20,NULL),CLASSROOM_TYPE('2',24,NULL)),'CANADA SOUTH');

REM INSERTING into STUDENTS
SET DEFINE OFF;
INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (1111, 'DIANE', 'BROWN', '(617)342-2345', 6173422345, 'F', '01-FEB-1964', 'EN', 20);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='111 BAY STATE ROAD')
WHERE student_id = 1111;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (2299, 'CHRIS', 'ADAMS', '(213)334-2789', 2133342789, 'M', '22-MAR-1965', 'EN', 30);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='7500 IMPERIAL BLVD')
WHERE student_id = 2299;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (4568, 'KEVIN', 'COX', '(619)433-6845', 6194336845, 'M', '04-DEC-1963', 'EN', 10);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='25 MISSION WAY')
WHERE student_id = 4568;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (5556, 'JOHN', 'TYLER', '(212)444-9769', 2124449769, 'M', '13-JUN-1966', 'EN', 20);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='544 42ND STREET')
WHERE student_id = 5556;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (6874, 'NANCY', 'GIBBS', '(714)346-2896', 7143462896, 'F', '15-JUL-1965', 'EN', 10);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='111 VALLEY WAY')
WHERE student_id = 6874;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (6789, 'JENNY', 'ROSE', '(415)334-2345', 4153342345, 'F', '16-SEP-1963', 'SW', 10);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='4545 ORACLE DRIVE')
WHERE student_id = 6789;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (1199, 'FRANK', 'NELSON', '(609)345-2346', 6093452346, 'M', '22-APR-1964', 'EN', 20);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='77 ELM STREET')
WHERE student_id = 1199;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (6263, 'KEN', 'CRICK', '(415)345-2313', 4153452313, 'M', '14-MAR-1965', 'EN', 50);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='22 GOLDEN GATE DRIVE')
WHERE student_id = 6263;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (3452, 'NIGEL', 'TURNER', '(818)352-2511', 8183522511, 'M', '16-FEB-1962', 'SW', 10);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='111 BEACHCOMBER PLACE')
WHERE student_id = 3452;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (2346, 'CARL', 'DUDLEY', '(609)223-7890', 6092237890, 'M', '28-NOV-1967', 'EN', 20);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='5567 KNIGHTSBRIDGE COURT')
WHERE student_id = 2346;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (9842, 'MIKE', 'COOPER', '(713)726-9842', 7137269842, 'M', '18-OCT-1962', 'EN', 50);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='562 HOCKEY STREET')
WHERE student_id = 9842;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (6901, 'LILY', 'GREEN', '(809)342-9621', 8093429621, 'F', '14-MAY-1964', 'EN', 30);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='111 CRUISING WAY')
WHERE student_id = 6901;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (7652, 'MARY', 'FRANKS', '(713)234-8521', 7132348521, 'F', '23-DEC-1965', 'EN', 60);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='45 KING STREET')
WHERE student_id = 7652;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (4631, 'JOE', 'FISHER', '(709)452-7392', 7094527392, 'M', '22-NOV-1962', 'EN', 50);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='AVENUE CHAMPS-ELYSEES 456')
WHERE student_id = 4631;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (3459, 'LARRY', 'MYERS', '(909)352-6216', 9093526216, 'M', '15-AUG-1967', 'EN', 10);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='4242 MISTY LANE')
WHERE student_id = 3459;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (6738, 'NICK', 'CARTER', '(808)238-2358', 8082382358, 'M', '17-FEB-1964', 'EN', 20);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='11-882 KAMEHAMEHA HIGHWAY')
WHERE student_id = 6738;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (8390, 'CAROL', 'WOOD', '(809)342-2345', 8093422345, 'F', '01-MAR-1964', 'EN', 60);
				   
UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='KUNGSGATAN 56')
WHERE student_id = 8390;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (8872, 'DEBBY', 'ARCHER', '(980)247-2349', 9802472349, 'F', '01-SEP-1964', 'EN', 20);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='333 SAN JUAN BLVD')
WHERE student_id = 8872;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (6474, 'PETER', 'HALL', '(707)843-2346', 7078432346, 'M', '22-FEB-1965', 'EN', 10);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='45555 BIG STREET')
WHERE student_id = 6474;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (9835, 'PAUL', 'MARKS', '(706)343-2345', 7063432345, 'M', '16-DEC-1964', 'EN', 20);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='177 AIRPORT ROAD')
WHERE student_id = 9835;

INSERT INTO students 
(student_id, student_firstname, student_surname, phone_number, fax_number, gender
,date_of_birth, preferred_language, company_id)
VALUES (7777, 'FRED', 'FLINTSTONE', '(747)987-6543', 7478882929, 'M', '04-JUL-1904', 'FR', 70);

UPDATE students SET address = 
(select ref(a) FROM addresses a
WHERE a.street='177 AIRPORT ROAD')
WHERE student_id = 7777;

REM INSERTING into SUBJECT_AREAS
SET DEFINE OFF;
Insert into SUBJECT_AREAS (SUBJECT_ID,SUBJECT_NAME) values (10,'SYSTEMS');
Insert into SUBJECT_AREAS (SUBJECT_ID,SUBJECT_NAME) values (20,'LANGUAGES');
Insert into SUBJECT_AREAS (SUBJECT_ID,SUBJECT_NAME) values (30,'DBMS');
Insert into SUBJECT_AREAS (SUBJECT_ID,SUBJECT_NAME) values (40,'NETWORKS');

commit;

-- Run this drop statement to remove all objects.
/*
drop table customers;

drop table instructors;

drop table offerings;

drop table states;

drop table students;

drop table subject_areas;

drop table courses;

drop table companies;

drop table attendance;

drop table addresses;

drop table sites;

drop table invoices;

drop type invoice_item_table_type;

drop type classroom_varray_type;

drop type invoice_item_type;

drop type classroom_type;

drop type state_type;

drop type address_type;
*/