CREATE TABLE notes (
    id serial PRIMARY KEY,
    content varchar(255),
    current_task_id INT,
    created_by_task_id INT,
    CONSTRAINT fk_notes_current_task FOREIGN KEY (current_task_id) REFERENCES tasks (id),
    CONSTRAINT fk_notes_created_by_task_id FOREIGN KEY (created_by_task_id) REFERENCES tasks (id)
)