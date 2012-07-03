--// ddl_oppgave
-- Migration SQL that makes the change goes here.

CREATE SEQUENCE oppgave_id_seq;

CREATE TABLE oppgave (
id INTEGER DEFAULT NEXTVAL('oppgave_id_seq') NOT NULL,
kort_beskrivelse VARCHAR(100) NOT NULL,
lang_beskrivelse VARCHAR
);

ALTER TABLE oppgave
ADD CONSTRAINT pk_oppgave
PRIMARY KEY (id);

--//@UNDO
-- SQL to undo the change goes here.


DROP TABLE oppgave;

DROP SEQUENCE oppgave_id_seq;