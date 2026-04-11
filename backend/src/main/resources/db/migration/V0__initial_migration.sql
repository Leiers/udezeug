CREATE TABLE public.course (
    id uuid NOT NULL,
    description character varying(255),
    name character varying(255),
    visible boolean NOT NULL
);

CREATE TABLE public.course_tags (
    course_id uuid NOT NULL,
    tags character varying(255)
);

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.course_tags
    ADD CONSTRAINT fk63ixc2ni7oipjtimftl4q5o01 FOREIGN KEY (course_id) REFERENCES public.course(id);

