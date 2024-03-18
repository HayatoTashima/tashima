CREATE TABLE shifutomanage (
    `id` SERIAL NOT NULL COMMENT 'ID',
    `number` VARCHAR(64),
    `name` VARCHAR(128),
    `mail` VARCHAR(128),
    `phone` VARCHAR(64),
    PRIMARY KEY (id)
) ENGINE=InnoDB;