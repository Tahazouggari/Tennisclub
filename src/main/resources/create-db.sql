drop table if exists tennis.PUBLIC.todo;

create table if not exists tennis.PUBLIC.todo
(
    id_todo     BIGINT          not null,
    description VARCHAR(200)    not null,
    primary key (id_todo)
)

