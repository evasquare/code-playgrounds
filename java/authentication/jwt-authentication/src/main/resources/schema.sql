CREATE TABLE IF NOT EXISTS user_entity (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(400) UNIQUE NOT NULL,
    hashed_password VARCHAR(400) NOT NULL,
    user_role VARCHAR(400) NOT NULL,
    PRIMARY KEY (id)
);

-- INSERT INTO user_entity (username, hashed_password, user_role) 
-- VALUES 
-- ('iam-user', '$2a$12$OBnerD3ZrnkqY/ofkaxune1jnpUscFhTGCcuVA9x5lgAGAtr6Bss2', 'ROLE_USER');