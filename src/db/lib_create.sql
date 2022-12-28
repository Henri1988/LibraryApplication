-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-12-28 11:38:12.884

-- tables
-- Table: book
CREATE TABLE book (
    id serial  NOT NULL,
    title varchar(255)  NOT NULL,
    author varchar(255)  NOT NULL,
    release_time date  NOT NULL,
    genre varchar(255)  NOT NULL,
    lending_period int  NOT NULL,
    location varchar(255)  NOT NULL,
    quantity int  NOT NULL,
    CONSTRAINT book_pk PRIMARY KEY (id)
);

-- Table: borrow
CREATE TABLE borrow (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    book_id int  NOT NULL,
    borrowed_date date  NULL,
    return_date date  NULL,
    returned_date date  NULL,
    CONSTRAINT borrow_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact (
    id serial  NOT NULL,
    first_name varchar(255)  NOT NULL,
    last_name varchar(255)  NOT NULL,
    email varchar(255)  NOT NULL,
    address varchar(255)  NOT NULL,
    mobile_number varchar(255)  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    user_name varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_role
CREATE TABLE user_role (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: borrow_book (table: borrow)
ALTER TABLE borrow ADD CONSTRAINT borrow_book
    FOREIGN KEY (book_id)
    REFERENCES book (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: borrow_user (table: borrow)
ALTER TABLE borrow ADD CONSTRAINT borrow_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: contact_user (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

