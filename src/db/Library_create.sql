-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-12-24 17:09:11.328

-- tables
-- Table: book
CREATE TABLE book (
    id serial  NOT NULL,
    title varchar(255)  NOT NULL,
    author varchar(255)  NOT NULL,
    release_year int  NOT NULL,
    quantity int  NOT NULL,
    location varchar(255)  NOT NULL,
    CONSTRAINT book_pk PRIMARY KEY (id)
);

-- Table: borrow
CREATE TABLE borrow (
    id serial  NOT NULL,
    member_id int  NOT NULL,
    worker_id int  NOT NULL,
    book_id int  NOT NULL,
    borrowed_date date  NULL,
    returned_date date  NULL,
    return_date date  NULL,
    CONSTRAINT borrow_pk PRIMARY KEY (id)
);

-- Table: member
CREATE TABLE member (
    id serial  NOT NULL,
    user_name varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    email varchar(255)  NOT NULL,
    first_name varchar(100)  NOT NULL,
    last_name varchar(100)  NOT NULL,
    address varchar(255)  NULL,
    phone_number varchar(255)  NULL,
    CONSTRAINT member_pk PRIMARY KEY (id)
);

-- Table: worker
CREATE TABLE worker (
    id serial  NOT NULL,
    user_name varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    email varchar(255)  NOT NULL,
    first_name varchar(255)  NOT NULL,
    last_name varchar(255)  NOT NULL,
    address varchar(255)  NOT NULL,
    phone_number varchar(255)  NOT NULL,
    CONSTRAINT worker_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: borrow_book (table: borrow)
ALTER TABLE borrow ADD CONSTRAINT borrow_book
    FOREIGN KEY (book_id)
    REFERENCES book (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: borrow_member (table: borrow)
ALTER TABLE borrow ADD CONSTRAINT borrow_member
    FOREIGN KEY (member_id)
    REFERENCES member (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: borrow_worker (table: borrow)
ALTER TABLE borrow ADD CONSTRAINT borrow_worker
    FOREIGN KEY (worker_id)
    REFERENCES worker (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

