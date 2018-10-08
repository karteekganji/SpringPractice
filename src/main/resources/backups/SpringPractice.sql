PGDMP     /    .            	    v            PracticeSpringBoot    9.6.10     10.5 (Ubuntu 10.5-1.pgdg16.04+1) O    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    965911    PracticeSpringBoot    DATABASE     z   CREATE DATABASE "PracticeSpringBoot" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_IN' LC_CTYPE = 'en_IN';
 $   DROP DATABASE "PracticeSpringBoot";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12425    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    974544    app_user    TABLE     �  CREATE TABLE public.app_user (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    auth character varying(255),
    city character varying(255),
    email character varying(255),
    gender character varying(255),
    is_active boolean,
    mobile_number character varying(255),
    name character varying(255) NOT NULL,
    password character varying(255),
    role character varying(255) NOT NULL
);
    DROP TABLE public.app_user;
       public         postgres    false    3            �            1259    974542    app_user_id_seq    SEQUENCE     x   CREATE SEQUENCE public.app_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.app_user_id_seq;
       public       postgres    false    3    190            �           0    0    app_user_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.app_user_id_seq OWNED BY public.app_user.id;
            public       postgres    false    189            �            1259    974555    author    TABLE     �   CREATE TABLE public.author (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    app_user_id bigint
);
    DROP TABLE public.author;
       public         postgres    false    3            �            1259    974553    author_id_seq    SEQUENCE     v   CREATE SEQUENCE public.author_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.author_id_seq;
       public       postgres    false    192    3            �           0    0    author_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.author_id_seq OWNED BY public.author.id;
            public       postgres    false    191            �            1259    976317    books    TABLE     �  CREATE TABLE public.books (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    author character varying(255),
    copies integer,
    description character varying(255),
    is_active boolean,
    pages integer,
    title character varying(255) NOT NULL,
    category_id bigint,
    language_id bigint,
    publisher_id bigint
);
    DROP TABLE public.books;
       public         postgres    false    3            �            1259    976315    books_id_seq    SEQUENCE     u   CREATE SEQUENCE public.books_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.books_id_seq;
       public       postgres    false    200    3            �           0    0    books_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.books_id_seq OWNED BY public.books.id;
            public       postgres    false    199            �            1259    965947    category    TABLE     �   CREATE TABLE public.category (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    description character varying(255),
    name character varying(255)
);
    DROP TABLE public.category;
       public         postgres    false    3            �            1259    965945    category_id_seq    SEQUENCE     x   CREATE SEQUENCE public.category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.category_id_seq;
       public       postgres    false    3    186            �           0    0    category_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.category_id_seq OWNED BY public.category.id;
            public       postgres    false    185            �            1259    966210    city    TABLE     �   CREATE TABLE public.city (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    city_code character varying(255),
    city_name character varying(255)
);
    DROP TABLE public.city;
       public         postgres    false    3            �            1259    966208    city_id_seq    SEQUENCE     t   CREATE SEQUENCE public.city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.city_id_seq;
       public       postgres    false    3    188            �           0    0    city_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.city_id_seq OWNED BY public.city.id;
            public       postgres    false    187            �            1259    974657    language    TABLE     �   CREATE TABLE public.language (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    is_active boolean,
    name character varying(255)
);
    DROP TABLE public.language;
       public         postgres    false    3            �            1259    974655    language_id_seq    SEQUENCE     x   CREATE SEQUENCE public.language_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.language_id_seq;
       public       postgres    false    198    3            �           0    0    language_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.language_id_seq OWNED BY public.language.id;
            public       postgres    false    197            �            1259    974615    library    TABLE        CREATE TABLE public.library (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    address character varying(255),
    is_active boolean,
    name character varying(255),
    city_id bigint
);
    DROP TABLE public.library;
       public         postgres    false    3            �            1259    974613    library_id_seq    SEQUENCE     w   CREATE SEQUENCE public.library_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.library_id_seq;
       public       postgres    false    3    196            �           0    0    library_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.library_id_seq OWNED BY public.library.id;
            public       postgres    false    195            �            1259    976343    library_info    TABLE     �   CREATE TABLE public.library_info (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    book_id bigint,
    copies integer,
    library_id bigint
);
     DROP TABLE public.library_info;
       public         postgres    false    3            �            1259    976341    library_info_id_seq    SEQUENCE     |   CREATE SEQUENCE public.library_info_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.library_info_id_seq;
       public       postgres    false    202    3            �           0    0    library_info_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.library_info_id_seq OWNED BY public.library_info.id;
            public       postgres    false    201            �            1259    974572 	   publisher    TABLE     �   CREATE TABLE public.publisher (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    description character varying(255),
    name character varying(255)
);
    DROP TABLE public.publisher;
       public         postgres    false    3            �            1259    974570    publisher_id_seq    SEQUENCE     y   CREATE SEQUENCE public.publisher_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.publisher_id_seq;
       public       postgres    false    194    3            �           0    0    publisher_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.publisher_id_seq OWNED BY public.publisher.id;
            public       postgres    false    193            -           2604    974547    app_user id    DEFAULT     j   ALTER TABLE ONLY public.app_user ALTER COLUMN id SET DEFAULT nextval('public.app_user_id_seq'::regclass);
 :   ALTER TABLE public.app_user ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    190    189    190            .           2604    974558 	   author id    DEFAULT     f   ALTER TABLE ONLY public.author ALTER COLUMN id SET DEFAULT nextval('public.author_id_seq'::regclass);
 8   ALTER TABLE public.author ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    192    191    192            2           2604    976320    books id    DEFAULT     d   ALTER TABLE ONLY public.books ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);
 7   ALTER TABLE public.books ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    200    199    200            +           2604    965950    category id    DEFAULT     j   ALTER TABLE ONLY public.category ALTER COLUMN id SET DEFAULT nextval('public.category_id_seq'::regclass);
 :   ALTER TABLE public.category ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    185    186    186            ,           2604    966213    city id    DEFAULT     b   ALTER TABLE ONLY public.city ALTER COLUMN id SET DEFAULT nextval('public.city_id_seq'::regclass);
 6   ALTER TABLE public.city ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    188    187    188            1           2604    974660    language id    DEFAULT     j   ALTER TABLE ONLY public.language ALTER COLUMN id SET DEFAULT nextval('public.language_id_seq'::regclass);
 :   ALTER TABLE public.language ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    198    198            0           2604    974618 
   library id    DEFAULT     h   ALTER TABLE ONLY public.library ALTER COLUMN id SET DEFAULT nextval('public.library_id_seq'::regclass);
 9   ALTER TABLE public.library ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    195    196    196            3           2604    976346    library_info id    DEFAULT     r   ALTER TABLE ONLY public.library_info ALTER COLUMN id SET DEFAULT nextval('public.library_info_id_seq'::regclass);
 >   ALTER TABLE public.library_info ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    201    202    202            /           2604    974575    publisher id    DEFAULT     l   ALTER TABLE ONLY public.publisher ALTER COLUMN id SET DEFAULT nextval('public.publisher_id_seq'::regclass);
 ;   ALTER TABLE public.publisher ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    194    193    194            �          0    974544    app_user 
   TABLE DATA               �   COPY public.app_user (id, created_at, updated_at, auth, city, email, gender, is_active, mobile_number, name, password, role) FROM stdin;
    public       postgres    false    190   �W       �          0    974555    author 
   TABLE DATA               I   COPY public.author (id, created_at, updated_at, app_user_id) FROM stdin;
    public       postgres    false    192   a       �          0    976317    books 
   TABLE DATA               �   COPY public.books (id, created_at, updated_at, author, copies, description, is_active, pages, title, category_id, language_id, publisher_id) FROM stdin;
    public       postgres    false    200   b       �          0    965947    category 
   TABLE DATA               Q   COPY public.category (id, created_at, updated_at, description, name) FROM stdin;
    public       postgres    false    186   �g       �          0    966210    city 
   TABLE DATA               P   COPY public.city (id, created_at, updated_at, city_code, city_name) FROM stdin;
    public       postgres    false    188   Li       �          0    974657    language 
   TABLE DATA               O   COPY public.language (id, created_at, updated_at, is_active, name) FROM stdin;
    public       postgres    false    198   &j       �          0    974615    library 
   TABLE DATA               `   COPY public.library (id, created_at, updated_at, address, is_active, name, city_id) FROM stdin;
    public       postgres    false    196   �j       �          0    976343    library_info 
   TABLE DATA               _   COPY public.library_info (id, created_at, updated_at, book_id, copies, library_id) FROM stdin;
    public       postgres    false    202   Xo       �          0    974572 	   publisher 
   TABLE DATA               R   COPY public.publisher (id, created_at, updated_at, description, name) FROM stdin;
    public       postgres    false    194   �o       �           0    0    app_user_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.app_user_id_seq', 30, true);
            public       postgres    false    189            �           0    0    author_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.author_id_seq', 13, true);
            public       postgres    false    191            �           0    0    books_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.books_id_seq', 30, true);
            public       postgres    false    199            �           0    0    category_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.category_id_seq', 9, true);
            public       postgres    false    185            �           0    0    city_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.city_id_seq', 10, true);
            public       postgres    false    187            �           0    0    language_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.language_id_seq', 11, true);
            public       postgres    false    197            �           0    0    library_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.library_id_seq', 30, true);
            public       postgres    false    195            �           0    0    library_info_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.library_info_id_seq', 9, true);
            public       postgres    false    201            �           0    0    publisher_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.publisher_id_seq', 10, true);
            public       postgres    false    193            9           2606    974552    app_user app_user_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT app_user_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.app_user DROP CONSTRAINT app_user_pkey;
       public         postgres    false    190            ?           2606    974560    author author_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.author DROP CONSTRAINT author_pkey;
       public         postgres    false    192            I           2606    976325    books books_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.books DROP CONSTRAINT books_pkey;
       public         postgres    false    200            5           2606    965955    category category_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public         postgres    false    186            7           2606    966218    city city_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.city DROP CONSTRAINT city_pkey;
       public         postgres    false    188            E           2606    974662    language language_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.language
    ADD CONSTRAINT language_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.language DROP CONSTRAINT language_pkey;
       public         postgres    false    198            K           2606    976348    library_info library_info_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.library_info
    ADD CONSTRAINT library_info_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.library_info DROP CONSTRAINT library_info_pkey;
       public         postgres    false    202            C           2606    974623    library library_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.library
    ADD CONSTRAINT library_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.library DROP CONSTRAINT library_pkey;
       public         postgres    false    196            A           2606    974580    publisher publisher_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.publisher
    ADD CONSTRAINT publisher_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.publisher DROP CONSTRAINT publisher_pkey;
       public         postgres    false    194            ;           2606    974562 $   app_user uk1j9d9a06i600gd43uu3km82jw 
   CONSTRAINT     `   ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT uk1j9d9a06i600gd43uu3km82jw UNIQUE (email);
 N   ALTER TABLE ONLY public.app_user DROP CONSTRAINT uk1j9d9a06i600gd43uu3km82jw;
       public         postgres    false    190            G           2606    974664 %   language uk_g8hr207ijpxlwu10pewyo65gv 
   CONSTRAINT     `   ALTER TABLE ONLY public.language
    ADD CONSTRAINT uk_g8hr207ijpxlwu10pewyo65gv UNIQUE (name);
 O   ALTER TABLE ONLY public.language DROP CONSTRAINT uk_g8hr207ijpxlwu10pewyo65gv;
       public         postgres    false    198            =           2606    974564 $   app_user ukg9deopqu0qe7p3cp88apqd9j2 
   CONSTRAINT     h   ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT ukg9deopqu0qe7p3cp88apqd9j2 UNIQUE (mobile_number);
 N   ALTER TABLE ONLY public.app_user DROP CONSTRAINT ukg9deopqu0qe7p3cp88apqd9j2;
       public         postgres    false    190            P           2606    976336 !   books fk1eujqvebj0cej9mcivv49grwi    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk1eujqvebj0cej9mcivv49grwi FOREIGN KEY (publisher_id) REFERENCES public.publisher(id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fk1eujqvebj0cej9mcivv49grwi;
       public       postgres    false    200    194    2113            M           2606    974624 #   library fk6vg7f2xm4dcpd384hmkv2evjm    FK CONSTRAINT     �   ALTER TABLE ONLY public.library
    ADD CONSTRAINT fk6vg7f2xm4dcpd384hmkv2evjm FOREIGN KEY (city_id) REFERENCES public.city(id);
 M   ALTER TABLE ONLY public.library DROP CONSTRAINT fk6vg7f2xm4dcpd384hmkv2evjm;
       public       postgres    false    196    2103    188            O           2606    976331 !   books fk7gm0q8hiuoyrgncs48ul0pp15    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk7gm0q8hiuoyrgncs48ul0pp15 FOREIGN KEY (language_id) REFERENCES public.language(id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fk7gm0q8hiuoyrgncs48ul0pp15;
       public       postgres    false    200    2117    198            N           2606    976326 !   books fk8el3ddb59ciucupyc17vu7835    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk8el3ddb59ciucupyc17vu7835 FOREIGN KEY (category_id) REFERENCES public.category(id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fk8el3ddb59ciucupyc17vu7835;
       public       postgres    false    200    186    2101            L           2606    974565 "   author fk8joppj10i2v7forker7fkjdxg    FK CONSTRAINT     �   ALTER TABLE ONLY public.author
    ADD CONSTRAINT fk8joppj10i2v7forker7fkjdxg FOREIGN KEY (app_user_id) REFERENCES public.app_user(id);
 L   ALTER TABLE ONLY public.author DROP CONSTRAINT fk8joppj10i2v7forker7fkjdxg;
       public       postgres    false    2105    190    192            �   �	  x�u�I������_Q��r��=�5jB+ }����ԛ����0�c��k��$F������?	� ���o;	;A1U�tŦ2�['��WU��q7O1E�KX�� �  �c��4���I��O�6S�6���(LA����6r�&_��h����W�&4�,+��#L0��v�A!�xH~;���*aCW�ui�T� �h�X�v�x��;�7�����\P���q������֪�w�99���?�.Jَ0S�N?h$�o�3�y���*����`q�ƹ[$_�ߤ'3�q��4��M�e��ٜ��HI���,���o�j������}{���Ԁ�WY��X<��{�?�� ��`Q_�1��Z��pu�:��!A��,Gs�},�,y2Wʱ\�g���D���|�������і�d��j���6�M�>�Y$`P~�s�3O��p��G0s<��eH���X7/搭�;�9��Ю�~4���u����Io{������av5�b;��7M��JN�(q�gbc{2g�-���������I��,����	;y�U��W�Kx�=��2x��xZ�e眼*�:�n�m�+�V��F/�"���u�0(�.B��ag`YHl̜�.����RG�7Ŋ?��Y��Ԏm�j|��ײ�;���A"R����?�!�����<킢�$5�R�@@�X���>�k��3M�9���l2���ĵ��w�7�!\�*��au��4�y�YhH8�@9���7�S��c��x�=������=�ݗ2���2]�at����*��sX,� UD":X=�>��+g��V�rc �p<Z���GN�zS?��$)r+���'q�?@���Sڽ�j����k1>��g��-dN�l�}0�KW1��؟KF/s��o�3﬉�y��h���e8� !K��n��OV=����Oz&��zIk���Ҡ8��a��%���$a�e�lM��'+�8������zeVW~<�w!	)��E��0NO^�t���2_z�dC��~�v4"��=�纙z.ݓ�as!��?#�ɋ��Bk�}��:K�����e!���<Y�ͽi_�IH4�I�Y6��1�ThG-h-��V�b0{�\6](�K�X���謃߸��.QFQ�E��$7���oX��ӽz"��a��M\����\�
�k>E��b��=�;NQ���:Ww��p]�:8Tر8����_򭓻_51�� ;�2�3�/�{g����v#ph�����T���r]<w�T/ַ�ն��RƦ���ך3��PG5CA��?��-����P�h	�gi0�Vec0���[u������v����w�[�n����m�Ǳ��������I�J4J��s��~���<G�/KЀf!A0�SV�?Y�+�^@��U�U�h�2�	ʏO�a�W)2s���ͽ]|�ۈ�����*��Z#��v��TU�b�໏:~ k� @�s�ߝ�DOܢTٛl9Q����j��a��:_uC��
Nk�&����/�����7�s���o�x�hW=���O͉�p3�����j��9ḏJ���M"�~��>�l�S	ò��*~��v=�/�t|[}B�ϊ�F����ZZ]�q�[��I��S�fm_v�W�ߔ��k��]}p�Q�-\�F<>��m��U�	�NK]�hZ�ү�C�"��Qf7C�E�m~/2/OQ7{ﻂ��I_�Z�4b��U�*�X�0�-Q;Eg0�������S��J9�p�<>>[0��������eC��Sܕ��ܻ�?���Y��TJ�w�����q���^�^4�£%�����Tw\��Q�p�j%X4��@�-����(Oֲ���NF�b!� K�?�J�˃��
�H���aw��Z��uփv-��]�N��=��ʹ�s���2.z�K�?7ǠW�>�q7WQ:	KA��̟�"��Ԭ hr�¼K��W/L��Rv<�r��ܰ�F���P�B�����&�.\RW���ZF�M����s��D�.hR� ��N�!��IX��#�L�8�BTy����l�V�$m_G*>�F���.RΚb����܍���������/��E�ܻ�(& ��sԧ^�E��&{������nuqKz��.R}�h��x润,��*^��NL����"Pц����<�A��@�e��E�~h;OR������l��I�����\N;.K��/o���
���/�kN m�c�����l�c_"7�7�4g��¦���W��3E�S�:J�H�����k]o�\�ˇt�/h� B���7�ER�\�p��.�}N~Ṡ��=C�G��q)��H̹��𺳆��W����0ǚ���.��'=+��[�F��̑�{)̂M��qx��V4�R_�@�A����IS8���0��[�/;K'?��G��!��dfQ8�7D���8-n�%�F���:ElY[m��n�qtq?���޽7S'�q.?��7��Ǐ �/��      �   �   x�u��� �7�����!���:�.�S|W3F��:�A?��3��ns��2Y�6>KGY����@�Y�{O��ZU����u�ӑ2\j�sԤØ�C�sB5֩��N�e:R�{����ڼu{��f�����պi{o�� |�2}      �   �  x�}W]Ϋ�|�[�l`�I 9k�/`l��_l���6��f$�ג�EWWW;�nx��?�ǟ�����{��O�^��-΍̮v��C%-��zK�.3_���H��u��}�i��v��ٽ�˪�G��l�!�mA2�y�R�TD����,A*�T����Z9v	�^��g��ڿo�]-�Ɔ���L���%�oU��J���|;l4Z���=>�U�6�#�<���ɎJ� �6�c�R�5��g�������K-�^�������XiB��9MD��R��̸`;^��?����6ݲ�<p��?�,����!_<kt�����d��y�q"�s:���Nywdؤ�����?�3*7���%Y�e��,����Qj�Mϡ��X�w�99��e��f��Gf�vҡ]m�K�V�\�O3�D80΂x����3	t}�{^��nĜ`����܂\0�JT�bANT��J�`$Qr�÷�F����n��W����<RC�iL�`�K^xH�!�J�F���r��}v��T�Ә���v}o�VM�3Q�Wf�d7�ͼT��
�ݬ�]ۺ��v���,M�G���=1>�7d||:�v\��U�5��*���;�~��asp|���/b��f߬y���_��pUI�'�L����(U6h�Ǧ��š���to(/r���6�����g N�r�TSoKXӾ�t�̘xX�gE�A�^���0�M�yvmݍh���T8��J-�a7�cc��F2DX�q��Y����*�O��?�u��7���2A�M`\��T>2�j"�H����FL�A��5t��`��:VƛXix�̢��p�fj�	�:�V��� _c����q��Y���:V��;�K92>Cs�G�E�E���(�� D�D�8�IX��e�t��=�ce�n�ܕb�it���-�(�l��)��5y��S���g�u;�mvױ2~����G08�������a�!�&��.N5�<!$�:/C����7gtz\w��1��� �T΀�v=2Æk7k�a��P���X9�r-�ts����4��nj��ȳT��"�[���c��I�]
(�R����:O7���h���ݮ!%�����Ċ(�t�.u^Q����4Q��*�f��T��w���<	H�ݚ��r���l�sn{�~w�$'L{���n��I����Mԟ{��=��v����t�l�J.R����s�m����N��u�����'
N��L���-s�R�Ȱ0�y�8�$9/�Э�x��	o�˪�H������z��_Ƞ�J�
>�f��2P��q3��c��:ՔǾ;4��Zk��:Q^����}�b	2}�6H�qq6!��2LB{;u���#K5�o���z��5L�1�r����)�s���y�Ծ)A�4�����pZ}Bm��~�c�!��!���`1��bґ�LMtd��
�LT[T�l��P�?������
��      �   i  x�u�9n�0 c����ə�l�N7��C$����WƦbF�Et���8=��}�����ޟ�q�����Ś���DE�H{ɒ֚&)��ʉ^ɍ�5r���Z4�u95KI�-AS{ ��"%NNn�1s~�"��\��}^��>���=�=&+���<A��#�����<L]�ז5b*l�0^���]mX�|��p��|����u<����PKh�D��O"�d�g�c:K�ws����D9�:h���X)\-�B�	��Z��iqrσs"�jjEG�m�1b$�Uf���"�v��H'����lv�W�nC�1�XJ�e�7v6~�xO�W��}�m�H����s���No�-��!���`      �   �   x�u�I�0E��)�@Q���K+:(QҢ �R��^8������m�U��A�n��l{4��s�`,�^C��z4�w���{l�L�^�Z^le�0��tg���a�hB޲�_i�9�yJk�<!���ޞK��?GZ��x\)������A�f��k��<����Ч���~�ϰ��}�\+��B�G�:{\~����e�A      �   �   x�u��� Eg���DJH�u�c���]�%�)���!�Y��1����V�+��{�R5JQ�,��:�
N�y��h'���u�Gv��6,p���-��.޸iE*Ba��>n�f����4�Y쟾�MQ�w���!�4�� ��D:��#{l!��"���f���{��iI�ae�ͺ�,)�[d��i�3�j ��L��      �   O  x�u�9z�8�c�s��'��-�,�`#�}#p��ӝ�L+�	ԫz������_�ۯ��������~,o_��X_��m�a�8E>��[���K�0MȎ/�u9f|}��1c�A�E�H�F�7d��.��6Z�x������v;b���5vy+�%�q��M�Ã�e�5��q�:�	l�G\�=����	�w൝l�ٶ���1c�8�qE�0�q�Pq�QC�[qQ���P].��	�q�����x
2�J���(ٵD�ئ�l 8�����'CgPٲ�����:@%1�`����<f|e�G��ԝԮ��yh���H��s3'�����r���������ͿzK�*��EA��F��s���9Kc�/���vY^��G.�U��l�G[K(EV����hhA���q��1^���㜲@�� Y�k��pR��Ϝ$$ ~ߏ/�,/���h��[Ĉ�R�����c����aӔ�f�@֓��z� ��B@1��B}�A9��D�����R��!�c�:{s<��F"M��Urˬ܀�]�'?�����SIT�	I�6)PAN�}�e�q���l�ݼ����ҫ?r��Ў���$1Zj���7��86D���	�y2��q�2V0e��M�c���Yg\Ȕ����N��Q��Cj���%�CH[��ݤ/��5_��׍��ގ�2u$BU�-��B����w�����A���j�ɗ�v�'՚���+
���+�f-s�biq���'_�n4���xg"b��J���XE�X?m�.�a��u9��r����NG��e�1PX떛
4s�'6�){�/�u9NźWk�@�Z�\�Ti��8�����2��ǭ��ry��5t��h�6VT����Fw���XY
��Ǒ['�=iV�Z�g�xߌ�h+x����P��o����aឋ��-ː���E�b��������#t�����FC}��4~l�wK��)c��2Ӣqkk9n��y2���Þd�<2��-)F�|���౶�o�'z��qJFk�+���1����m�.i]O�<�k���rPp�D&
���J����V�|��}�^��z���      �   {   x�u���0ϸ
���B�u|�@ʢ�f4��M��`:(v���y�����܏Az�+j�K���w�ﻏkv�{|�~��-�2z)H2�x��S`����k�]̽�kv���⿛[v�pdP�      �   �  x�u��r� �5<E_ )u'�8��J\��4n3�p� !@ $����^l�������*�7yv��߲��*�[e�׫ۤ��N�PG'���֎�keUq/���o����j9s�t�C�f�;�Y����e,��EQ<���r~����T8I�L�!XJ���x��U�o������Mҩ�	הb)T�3Z�)��`Ԓn�����8�ľ���g�0=	�190�c�,�o�g������s� ׉|���1���_K�I��Ս����ˢx+��b~�-���Κ>ֳ�������j�m�у���^O;��k��I�F!<�J)k�8T�����x��y_��p�N�y���	���-�D�1�Yq�g4�#j�V�8�lw0ϖX��3������!<8��灌V2�aP��:�_��%��n�L     