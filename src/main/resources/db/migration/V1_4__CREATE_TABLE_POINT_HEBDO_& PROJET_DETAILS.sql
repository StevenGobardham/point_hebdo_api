CREATE TABLE point_hebdo (
                             id INTEGER NOT NULL AUTO_INCREMENT,
                             user_id INTEGER NOT NULL,
                             note LONGTEXT NULL,
                             priority LONGTEXT NULL,
                             validate TINYINT NOT NULL,
                             creation_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             modification_time TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                             PRIMARY KEY(id),
                             FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE projet_details (
                                id INTEGER NOT NULL AUTO_INCREMENT,
                                point_hebdo_id INTEGER NOT NULL,
                                client VARCHAR(255) NOT NULL,
                                projet VARCHAR(255) NULL,
                                situation LONGTEXT NOT NULL,
                                creation_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                modification_time TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                PRIMARY KEY(id),
                                FOREIGN KEY (point_hebdo_id) REFERENCES point_hebdo(id)
);