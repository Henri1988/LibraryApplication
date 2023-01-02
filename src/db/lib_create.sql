-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-01-02 19:25:09.847

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
    borrowed_date date  NOT NULL,
    return_date date  NOT NULL,
    CONSTRAINT borrow_pk PRIMARY KEY (id)
);

-- Table: borrow_return
CREATE TABLE borrow_return (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    book_id int  NOT NULL,
    returned_date date  NOT NULL,
    borrow_id int  NOT NULL,
    CONSTRAINT borrow_return_pk PRIMARY KEY (id)
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

-- Table: user_session
CREATE TABLE user_session (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    expires_at date  NOT NULL,
    CONSTRAINT user_session_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Table_11_user (table: user_session)
ALTER TABLE user_session ADD CONSTRAINT Table_11_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

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

-- Reference: return_borrow_book (table: borrow_return)
ALTER TABLE borrow_return ADD CONSTRAINT return_borrow_book
    FOREIGN KEY (book_id)
    REFERENCES book (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: return_borrow_borrow (table: borrow_return)
ALTER TABLE borrow_return ADD CONSTRAINT return_borrow_borrow
    FOREIGN KEY (borrow_id)
    REFERENCES borrow (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: return_borrow_user (table: borrow_return)
ALTER TABLE borrow_return ADD CONSTRAINT return_borrow_user
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

