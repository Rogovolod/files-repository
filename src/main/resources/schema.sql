create table if not exists photoz (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    file_name VARCHAR(255),
    content_type VARCHAR(255),
    photo BINARY LARGE OBJECT
);