CREATE TABLE table_user (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    user_age DATE NOT NULL,
    user_gmail VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE table_history (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    category SMALLINT NOT NULL,
    idea VARCHAR(255) NOT NULL,
    fk_history INT,

    CONSTRAINT fk_user_history
        FOREIGN KEY (fk_history)
        REFERENCES table_user (id)
);