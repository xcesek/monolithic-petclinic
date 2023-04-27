CREATE TABLE person
(
    id      BIGINT IDENTITY,
    name    VARCHAR(255),
    role    VARCHAR(255),
    team_id BIGINT,
    PRIMARY KEY (ID)
);
CREATE TABLE task
(
    id                 BIGINT IDENTITY,
    completion_comment VARCHAR(255),
    completion_date    TIMESTAMP,
    due_date           TIMESTAMP,
    instructions       VARCHAR(255),
    name               VARCHAR(255),
    status             VARCHAR(255),
    assignee_id        BIGINT,
    PRIMARY KEY (ID)
);
CREATE TABLE team
(
    id            BIGINT IDENTITY,
    name          VARCHAR(255),
    supervisor_id BIGINT,
    PRIMARY KEY (ID)
);
ALTER TABLE person
    ADD CONSTRAINT FK1bs3d6msvtsti63ylrdxn785 FOREIGN KEY (team_id) REFERENCES team;
ALTER TABLE task
    ADD CONSTRAINT FKq91s5fiqw852c60l8s71qa9t FOREIGN KEY (assignee_id) REFERENCES person;
ALTER TABLE team
    ADD CONSTRAINT FK3nhmpradtc9x0jbwvrrqfibi4 FOREIGN KEY (supervisor_id) REFERENCES person;