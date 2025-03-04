CREATE TABLE author (
    id VARCHAR(10) PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);

CREATE TABLE book (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100),
    page_count INT,
    author_id VARCHAR(10),
    FOREIGN KEY (author_id) REFERENCES author(id)
);
