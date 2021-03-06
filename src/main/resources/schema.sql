DROP TABLE IF EXISTS MODEL;

CREATE TABLE MODEL (
                               logic INT PRIMARY KEY,
                               serial VARCHAR(50) NOT NULL,
                               model VARCHAR(20) NOT NULL,
                               sam INT,
                               ptid VARCHAR(50),
                               plat INT,
                               version VARCHAR(20) NOT NULL,
                               mxr INT,
                               mxf INT,
                               VERFM VARCHAR(20)
);
