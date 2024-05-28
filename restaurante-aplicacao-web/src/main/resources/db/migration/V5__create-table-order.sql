CREATE TABLE IF NOT EXISTS ordered(

    id SERIAL PRIMARY KEY,
    created_at timestamp(6) not null,
    finished_at timestamp(6),
    status varchar(20) not null
)
