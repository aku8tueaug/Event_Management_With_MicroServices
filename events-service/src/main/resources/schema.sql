CREATE TABLE public.events (
    id integer NOT NULL,
    end_date date,
    name character varying(255) NOT NULL,
    start_date date,
    event_organiser integer NOT NULL,
    event_venue integer NOT NULL
);

ALTER TABLE public.events OWNER TO pluralsight;

CREATE SEQUENCE public.events_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.events_id_seq OWNER TO pluralsight;

ALTER SEQUENCE public.events_id_seq OWNED BY public.events.id;

CREATE TABLE public.organizers (
    id integer NOT NULL,
    description character varying(255),
    name character varying(255) NOT NULL
);

ALTER TABLE public.organizers OWNER TO pluralsight;

CREATE SEQUENCE public.organizers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.organizers_id_seq OWNER TO pluralsight;

ALTER SEQUENCE public.organizers_id_seq OWNED BY public.organizers.id;

CREATE TABLE public.products (
    id integer NOT NULL,
    description character varying(255),
    product_event integer NOT NULL,
    name character varying(255) NOT NULL,
    price numeric(38,2) NOT NULL
);

ALTER TABLE public.products OWNER TO pluralsight;

CREATE SEQUENCE public.products_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.products_id_seq OWNER TO pluralsight;

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;

CREATE TABLE public.venues (
    id integer NOT NULL,
    city character varying(255),
    country character varying(255),
    name character varying(255) NOT NULL,
    street character varying(255)
);

ALTER TABLE public.venues OWNER TO pluralsight;

CREATE SEQUENCE public.venues_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.venues_id_seq OWNER TO pluralsight;

ALTER SEQUENCE public.venues_id_seq OWNED BY public.venues.id;

ALTER TABLE ONLY public.events ALTER COLUMN id SET DEFAULT nextval('public.events_id_seq'::regclass);

ALTER TABLE ONLY public.organizers ALTER COLUMN id SET DEFAULT nextval('public.organizers_id_seq'::regclass);

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);

ALTER TABLE ONLY public.venues ALTER COLUMN id SET DEFAULT nextval('public.venues_id_seq'::regclass);

ALTER TABLE ONLY public.events
    ADD CONSTRAINT events_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.organizers
    ADD CONSTRAINT organizers_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.venues
    ADD CONSTRAINT venues_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.events
    ADD CONSTRAINT fk_events_organizer FOREIGN KEY (event_organiser) REFERENCES organizers(id);
--    ADD CONSTRAINT fkmied7el0kcl27ul1mn6384hki FOREIGN KEY (organizer_id) REFERENCES public.organizers(id);
--
ALTER TABLE ONLY public.events
    ADD CONSTRAINT fk_events_venue FOREIGN KEY (event_venue) REFERENCES venues(id);
--    ADD CONSTRAINT fkqdxygdernwwt74hdvix9u5nr3 FOREIGN KEY (venue_id) REFERENCES public.venues(id);
--ADD CONSTRAINT fk_events_organizer FOREIGN KEY (organizer_id) REFERENCES organizers(id);
--ADD CONSTRAINT fk_events_venue FOREIGN KEY (venue_id) REFERENCES venues(id);

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fk_product_event FOREIGN KEY (product_event) REFERENCES events(id);