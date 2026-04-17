CREATE TABLE public.course_badges (
    course_id uuid NOT NULL,
    badge_name character varying(255) NOT NULL,
    CONSTRAINT fk_course_id FOREIGN KEY (course_id) REFERENCES course(id)
);