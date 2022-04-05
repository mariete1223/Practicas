DROP Table MEDICO_PACIENTE CASCADE CONSTRAINTS;
DROP Table CITA CASCADE CONSTRAINTS;
DROP Table DIAGNOSTICO CASCADE CONSTRAINTS;
DROP Table MEDICO CASCADE CONSTRAINTS;
DROP Table PACIENTE CASCADE CONSTRAINTS;
DROP Table USUARIO CASCADE CONSTRAINTS;
DROP Table HIBERNATE_SEQUENCE CASCADE CONSTRAINTS;

CREATE TABLE HIBERNATE_SEQUENCE (
    next_val NUMBER(9)
);

CREATE TABLE USUARIO (
    usuario_id NUMBER(9) PRIMARY KEY NOT NULL,
    nombre VARCHAR2(10) NOT NULL,
    apellidos VARCHAR2(20) NOT NULL,
    email VARCHAR2(30) NOT NULL
   

);

CREATE TABLE MEDICO (
    medico_id NUMBER(9) PRIMARY KEY NOT NULL REFERENCES USUARIO (usuario_id),
    num_colegio VARCHAR2(15) NOT NULL,
    CONSTRAINT num_colegio_ok CHECK(num_colegio>0)

);

CREATE TABLE PACIENTE (
    paciente_id NUMBER(9) PRIMARY KEY NOT NULL REFERENCES USUARIO (usuario_id),
    nss VARCHAR2(11) NOT NULL,
    num_Tarjeta VARCHAR2(16) NOT NULL,
    telefono VARCHAR2(15) NOT NULL,
    direccion VARCHAR2(30) NOT NULL,
    CONSTRAINT telefono_ok CHECK(LENGTH(telefono)>=6),
    CONSTRAINT num_Tarjeta_ok CHECK(LENGTH(num_Tarjeta)>=16 and LENGTH(num_Tarjeta)<=19),
    CONSTRAINT nss_ok CHECK(LENGTH(nss)=11)
    
);

CREATE TABLE MEDICO_PACIENTE (
    paciente NUMBER(9) NOT NULL, 
    medico NUMBER(9) NOT NULL,
    CONSTRAINT Atendido_pk PRIMARY KEY(paciente,medico),
    CONSTRAINT paciente_fk_atendido
        FOREIGN KEY(paciente) REFERENCES PACIENTE(paciente_id),
    CONSTRAINT medico_fk_atendido
        FOREIGN KEY(medico) REFERENCES MEDICO(medico_id),
    CONSTRAINT no_paciente_si_mismo CHECK(paciente<>medico)
);

CREATE TABLE CITA (
    cita_id NUMBER(9) PRIMARY KEY NOT NULL,
    fecha_Cita DATE NOT NULL,
    motivo_Cita VARCHAR2(50) NOT NULL,
    attribute11 INT NOT NULL,
    medico NUMBER(9) NOT NULL,
    paciente NUMBER(9) NOT NULL,
    diagnostico NUMBER(9) NOT NULL,
    CONSTRAINT medico_fk_cita
        FOREIGN KEY(medico) REFERENCES MEDICO(medico_id),
    CONSTRAINT paciente_fk_cita
        FOREIGN KEY(paciente) REFERENCES PACIENTE(paciente_id),
    CONSTRAINT distinto_paciente_medico CHECK(paciente<>medico),
    CONSTRAINT diagnostico_fk_cita
    	FOREIGN KEY(diagnostico) REFERENCES DIAGNOSTICO(diagnostico_id)
    	INITIALLY IMMEDIATE DEFERRABLE;
    
);

CREATE TABLE DIAGNOSTICO (
    diagnostico_id NUMBER(9) PRIMARY KEY NOT NULL,
    valoracion_especialista VARCHAR2(50) NOT NULL,
    enfermedad VARCHAR2(15) NOT NULL,
);

ALTER TABLE CITA ADD CONSTRAINT diagnostico_fk_cita
    FOREIGN KEY(diagnostico) REFERENCES DIAGNOSTICO(diagnostico_id)
    INITIALLY IMMEDIATE DEFERRABLE;

Insert into hibernate_sequence (next_val) values(0);
Insert into USUARIO (usuario_id, nombre, apellidos, email) values(1,'Joaquin','Martinez Martinez','Joaq');
Insert into USUARIO (usuario_id, nombre, apellidos, email) values(3,'Maro','Rodriguez Bejar','Mariete');
INSERT INTO PACIENTE (paciente_id,nss,num_tarjeta,telefono,direccion) VALUES(3,'bbbbbbbbbbb','2342322222444444','2444444','ssss');
Insert into MEDICO (medico_id,num_colegio) values(1,'222222222');
Insert into USUARIO (usuario_id, nombre, apellidos, email) values(2,'Pedro','Jimenez Montalban','Pedri');
INSERT INTO PACIENTE (paciente_id,nss,num_tarjeta,telefono,direccion) VALUES(2,'aaaaaaaaaaa','2342322222444444','234234444444','ssss');
INSERT INTO DIAGNOSTICO (diagnostico_id,valoracion_especialista,enfermedad) values(5,'AAAAA','COVID');
INSERT INTO CITA (cita_id,fecha_cita,motivo_cita,attribute11,medico,paciente,diagnostico) VALUES(3,date '2015-01-01','dolor barriga','1234',1,2,5);

COMMIT;
