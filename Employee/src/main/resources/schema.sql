CREATE TABLE DEPARTMENT (
    ID INTEGER NOT NULL AUTO_INCREMENT,
    DEPART_CODE VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE PROJECT (
    ID INTEGER NOT NULL AUTO_INCREMENT,
    PROJECT_CODE VARCHAR(100) NOT NULL,
    DEPART_ID INTEGER,
    PRIMARY KEY (ID),
    CONSTRAINT DEPART_ID FOREIGN KEY (DEPART_ID) REFERENCES DEPARTMENT(ID)
);

CREATE TABLE EMPLOYEE (
    ID INTEGER NOT NULL AUTO_INCREMENT,
    EMP_CODE VARCHAR(100) NOT NULL,
    NAME VARCHAR(100) NOT NULL,
    CITY VARCHAR(50) NOT NULL,
    DEPARTMENT_ID INTEGER,
    PROJECT_ID INTEGER,
    PRIMARY KEY (ID),
    CONSTRAINT DEPARTMENT_ID FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT(ID),
    CONSTRAINT PROJECT_ID FOREIGN KEY (PROJECT_ID) REFERENCES PROJECT(ID)
);



