CREATE TABLE tasks(
    id serial PRIMARY KEY,
    name varchar(255),
    completed BOOLEAN,
    CONSTRAINT fk_user_id FOREIGN KEY (owner_id) REFERENCES users (id),
    parent_id INT,
    owner_id INT,
    CONSTRAINT fk_tasks_parent FOREIGN KEY (owner_id) REFERENCES users (id),
    CONSTRAINT fk_tasks_owner FOREIGN KEY (parent_id) REFERENCES tasks (id),

)