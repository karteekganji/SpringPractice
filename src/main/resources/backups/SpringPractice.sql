PGDMP     8    %            	    v            PracticeSpringBoot    9.6.10     10.5 (Ubuntu 10.5-1.pgdg16.04+1) H    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
       public       postgres    false    3    192            �           0    0    author_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.author_id_seq OWNED BY public.author.id;
            public       postgres    false    191            �            1259    974678    books    TABLE     w  CREATE TABLE public.books (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    author character varying(255),
    description character varying(255),
    is_active boolean,
    pages integer,
    title character varying(255) NOT NULL,
    category_id bigint,
    language_id bigint,
    publisher_id bigint
);
    DROP TABLE public.books;
       public         postgres    false    3            �            1259    974676    books_id_seq    SEQUENCE     u   CREATE SEQUENCE public.books_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.books_id_seq;
       public       postgres    false    3    200            �           0    0    books_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.books_id_seq OWNED BY public.books.id;
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
       public       postgres    false    186    3            �           0    0    category_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.category_id_seq OWNED BY public.category.id;
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
       public       postgres    false    188    3            �           0    0    city_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.city_id_seq OWNED BY public.city.id;
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
            public       postgres    false    195            �            1259    974572 	   publisher    TABLE     �   CREATE TABLE public.publisher (
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
            public       postgres    false    193            '           2604    974547    app_user id    DEFAULT     j   ALTER TABLE ONLY public.app_user ALTER COLUMN id SET DEFAULT nextval('public.app_user_id_seq'::regclass);
 :   ALTER TABLE public.app_user ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    190    189    190            (           2604    974558 	   author id    DEFAULT     f   ALTER TABLE ONLY public.author ALTER COLUMN id SET DEFAULT nextval('public.author_id_seq'::regclass);
 8   ALTER TABLE public.author ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    192    191    192            ,           2604    974681    books id    DEFAULT     d   ALTER TABLE ONLY public.books ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);
 7   ALTER TABLE public.books ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    200    199    200            %           2604    965950    category id    DEFAULT     j   ALTER TABLE ONLY public.category ALTER COLUMN id SET DEFAULT nextval('public.category_id_seq'::regclass);
 :   ALTER TABLE public.category ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    185    186    186            &           2604    966213    city id    DEFAULT     b   ALTER TABLE ONLY public.city ALTER COLUMN id SET DEFAULT nextval('public.city_id_seq'::regclass);
 6   ALTER TABLE public.city ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    188    187    188            +           2604    974660    language id    DEFAULT     j   ALTER TABLE ONLY public.language ALTER COLUMN id SET DEFAULT nextval('public.language_id_seq'::regclass);
 :   ALTER TABLE public.language ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    198    198            *           2604    974618 
   library id    DEFAULT     h   ALTER TABLE ONLY public.library ALTER COLUMN id SET DEFAULT nextval('public.library_id_seq'::regclass);
 9   ALTER TABLE public.library ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    195    196    196            )           2604    974575    publisher id    DEFAULT     l   ALTER TABLE ONLY public.publisher ALTER COLUMN id SET DEFAULT nextval('public.publisher_id_seq'::regclass);
 ;   ALTER TABLE public.publisher ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    194    193    194            �          0    974544    app_user 
   TABLE DATA               �   COPY public.app_user (id, created_at, updated_at, auth, city, email, gender, is_active, mobile_number, name, password, role) FROM stdin;
    public       postgres    false    190   �O       �          0    974555    author 
   TABLE DATA               I   COPY public.author (id, created_at, updated_at, app_user_id) FROM stdin;
    public       postgres    false    192   fY       �          0    974678    books 
   TABLE DATA               �   COPY public.books (id, created_at, updated_at, author, description, is_active, pages, title, category_id, language_id, publisher_id) FROM stdin;
    public       postgres    false    200   Z       �          0    965947    category 
   TABLE DATA               Q   COPY public.category (id, created_at, updated_at, description, name) FROM stdin;
    public       postgres    false    186   #Z       �          0    966210    city 
   TABLE DATA               P   COPY public.city (id, created_at, updated_at, city_code, city_name) FROM stdin;
    public       postgres    false    188   �[       �          0    974657    language 
   TABLE DATA               O   COPY public.language (id, created_at, updated_at, is_active, name) FROM stdin;
    public       postgres    false    198   v\       �          0    974615    library 
   TABLE DATA               `   COPY public.library (id, created_at, updated_at, address, is_active, name, city_id) FROM stdin;
    public       postgres    false    196   I]       �          0    974572 	   publisher 
   TABLE DATA               R   COPY public.publisher (id, created_at, updated_at, description, name) FROM stdin;
    public       postgres    false    194   �a       �           0    0    app_user_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.app_user_id_seq', 30, true);
            public       postgres    false    189            �           0    0    author_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.author_id_seq', 13, true);
            public       postgres    false    191            �           0    0    books_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.books_id_seq', 1, false);
            public       postgres    false    199            �           0    0    category_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.category_id_seq', 9, true);
            public       postgres    false    185            �           0    0    city_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.city_id_seq', 10, true);
            public       postgres    false    187            �           0    0    language_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.language_id_seq', 11, true);
            public       postgres    false    197            �           0    0    library_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.library_id_seq', 30, true);
            public       postgres    false    195            �           0    0    publisher_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.publisher_id_seq', 10, true);
            public       postgres    false    193            2           2606    974552    app_user app_user_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT app_user_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.app_user DROP CONSTRAINT app_user_pkey;
       public         postgres    false    190            8           2606    974560    author author_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.author DROP CONSTRAINT author_pkey;
       public         postgres    false    192            B           2606    974686    books books_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.books DROP CONSTRAINT books_pkey;
       public         postgres    false    200            .           2606    965955    category category_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public         postgres    false    186            0           2606    966218    city city_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.city DROP CONSTRAINT city_pkey;
       public         postgres    false    188            >           2606    974662    language language_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.language
    ADD CONSTRAINT language_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.language DROP CONSTRAINT language_pkey;
       public         postgres    false    198            <           2606    974623    library library_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.library
    ADD CONSTRAINT library_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.library DROP CONSTRAINT library_pkey;
       public         postgres    false    196            :           2606    974580    publisher publisher_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.publisher
    ADD CONSTRAINT publisher_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.publisher DROP CONSTRAINT publisher_pkey;
       public         postgres    false    194            4           2606    974562 $   app_user uk1j9d9a06i600gd43uu3km82jw 
   CONSTRAINT     `   ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT uk1j9d9a06i600gd43uu3km82jw UNIQUE (email);
 N   ALTER TABLE ONLY public.app_user DROP CONSTRAINT uk1j9d9a06i600gd43uu3km82jw;
       public         postgres    false    190            @           2606    974664 %   language uk_g8hr207ijpxlwu10pewyo65gv 
   CONSTRAINT     `   ALTER TABLE ONLY public.language
    ADD CONSTRAINT uk_g8hr207ijpxlwu10pewyo65gv UNIQUE (name);
 O   ALTER TABLE ONLY public.language DROP CONSTRAINT uk_g8hr207ijpxlwu10pewyo65gv;
       public         postgres    false    198            6           2606    974564 $   app_user ukg9deopqu0qe7p3cp88apqd9j2 
   CONSTRAINT     h   ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT ukg9deopqu0qe7p3cp88apqd9j2 UNIQUE (mobile_number);
 N   ALTER TABLE ONLY public.app_user DROP CONSTRAINT ukg9deopqu0qe7p3cp88apqd9j2;
       public         postgres    false    190            G           2606    974697 !   books fk1eujqvebj0cej9mcivv49grwi    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk1eujqvebj0cej9mcivv49grwi FOREIGN KEY (publisher_id) REFERENCES public.publisher(id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fk1eujqvebj0cej9mcivv49grwi;
       public       postgres    false    194    2106    200            D           2606    974624 #   library fk6vg7f2xm4dcpd384hmkv2evjm    FK CONSTRAINT     �   ALTER TABLE ONLY public.library
    ADD CONSTRAINT fk6vg7f2xm4dcpd384hmkv2evjm FOREIGN KEY (city_id) REFERENCES public.city(id);
 M   ALTER TABLE ONLY public.library DROP CONSTRAINT fk6vg7f2xm4dcpd384hmkv2evjm;
       public       postgres    false    188    196    2096            F           2606    974692 !   books fk7gm0q8hiuoyrgncs48ul0pp15    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk7gm0q8hiuoyrgncs48ul0pp15 FOREIGN KEY (language_id) REFERENCES public.language(id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fk7gm0q8hiuoyrgncs48ul0pp15;
       public       postgres    false    198    2110    200            E           2606    974687 !   books fk8el3ddb59ciucupyc17vu7835    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk8el3ddb59ciucupyc17vu7835 FOREIGN KEY (category_id) REFERENCES public.category(id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fk8el3ddb59ciucupyc17vu7835;
       public       postgres    false    186    200    2094            C           2606    974565 "   author fk8joppj10i2v7forker7fkjdxg    FK CONSTRAINT     �   ALTER TABLE ONLY public.author
    ADD CONSTRAINT fk8joppj10i2v7forker7fkjdxg FOREIGN KEY (app_user_id) REFERENCES public.app_user(id);
 L   ALTER TABLE ONLY public.author DROP CONSTRAINT fk8joppj10i2v7forker7fkjdxg;
       public       postgres    false    2098    192    190            �   �	  x�u�I�����ԯx��^��sG�TD@D�;�o����?�fje�:9]F|�\{�}G��±�0�?�7���Q(C�p���TD���+H6��8������u�y� "-B��X@�,����O���c?��ݽR,�.�s�T��uq��^�ė�#�����q7u�Q�
1u����R���V_h���WLU8ߐ����I����p� �!�봓�ĕ3�m�@)�B�$��h���$m����۔��R��iz��4v��	� �C���h�"2�U�T�A�0��I�eq$w3{x<Q��>k���A!�@�Ѯ�Q��]�����s�%X��><�>+َ?&KA� �����^�=�U~˟7$A�n�B�@�,�R4GqH��}><�͙��09Y�����&�6����=t�����ty���L��pk�9^BG����_j}����7ԅ:�a��6g�aX�E©����\+�j�^0j>au���\sM�.�[�����(�Ͷ�Vjc&��y23P6��y�]g�d�E�8� af9 p�&Hy�SӾ�#�>���r�"�&�-��m�n�eNv?���ߴX�I����4��0�(A����/Ćt6\	i�at�΁��$�
p�b���	;�E�Ռ�շkt�=��h4�j:o��KAܔ���`\�
c#��s��A����W\�����cx�1K>0 qdʝƮ��$�'�|0�������ĭ�N]�t��1ײ��V��(b�cD'Z��� 
F����^��A9���cH��NQHޏ��=��8�m�:��H�r�(��v�T��;q���)����>'Tp�l?<�cP8�%ۇ����9J�)�`i���Q4I"�#�m��1��L�r_���1JOv��W�>����@e���ƙ������p��4��f's�y��o$��TQ��89�u<x#�W���io���!9f���6���|%u4�k_Ӿ�ڟC�s��o��w���<#C<�EZ%���,��!��u�'�Y���f=�]���T�m4 ��f�Yo�ذ�,��s]�;^�@��
O����]�:[�ʛ�O&�l  �p�������k�n~~[ko��`sӯ=�MF���i�ĥi���f�]����Ƅ~��;�#�y�_[g��ԡL}�r���� ����U��� X+�r�ʲ���g|�8jIiI���2��9}�2�J���c�|�»|� ��L�*�k?+�MA��,���i5���ʏ�74i���W��zQ_�Ij��R�d�8e�_Zp�T�/����k�`eǠl��ʿ�ۤ�_�	|�pf�e���_xao����~�P`�R�VNy&6cm�.Z�Z��������N1g2�`�[����Öj�0c�����Xep�,�P�jH�O����~�c�����wo�.��,�I��[(��*�i����M��3�Ik4�Y���u��|ǹ�򢀅/�Q8� �����u�W7����ZV�N9���O���H?9������,dT�ܻ{��`�"KyfT%h�G���v�U���i��G�<�gA�8F-E:}�OܲR��l�V��tS15QѨN:{[l��s�4fKz�6�kb�?�@��A��V�c�o��z�G�r�K#��q��C�o
�?����K�
�_G�{H=�fṴ,BZ��V�~ ��ͦ��'4|��o����iM�%�#��& ��GbH�wCտ^�aW�־k6��`���Y�fMhrڶ���p�e�0�:S�v�^��8���B�wEX�^��
n��w/��C���X%�Zu�&��G�l	��$8���}�n�ס0�&���q�����y���o��#�>�㡘���=�ލ����a��<�qx��z�ܔ��~�z\��y���w�d��b'��:D��19�V��3x0,�"�Ó�����	6X��8C�?�*�+���
�X���a���V^1yуn�Ob���J�����޻Ҡ;��
��2��������&�g~�H��sZf�\\���|aѧS���W&f�s%;yTY�_�R���a,Q>SO�r�&-W6mj�-���YF�C��&��p��ď>h3�pǗw20$I�2{-Ym��/�@����/�Dw�&j�&V��l�N��*�)�\9J���_�M,��X�Rl�]�m���U1�c�T}�y\�ba��k����t3h�{:x�w�P��Ӆ�LYtyU�����ܶ/G�����6WE�C�3�,C�ˋ:��v��8��jk�mVg� (��8����g����fk���@Xo�*�Ha�Ƣ4>�_zK�NC�,�a���\2��a�'�&��D�s�!#;�]�6���b��w>���|���w��W$	�5�ئ����^��	s���`.��,�8aT��=k��|S��Z�w��չ��g�xd��(׹9Q� Fy��9�����������ۗ�      �   �   x�u��� �7�����!���:�.�S|W3F��:�A?��3��ns��2Y�6>KGY����@�Y�{O��ZU����u�ӑ2\j�sԤØ�C�sB5֩��N�e:R�{����ڼu{��f�����պi{o�� |�2}      �      x������ � �      �   i  x�u�9n�0 c����ə�l�N7��C$����WƦbF�Et���8=��}�����ޟ�q�����Ś���DE�H{ɒ֚&)��ʉ^ɍ�5r���Z4�u95KI�-AS{ ��"%NNn�1s~�"��\��}^��>���=�=&+���<A��#�����<L]�ז5b*l�0^���]mX�|��p��|����u<����PKh�D��O"�d�g�c:K�ws����D9�:h���X)\-�B�	��Z��iqrσs"�jjEG�m�1b$�Uf���"�v��H'����lv�W�nC�1�XJ�e�7v6~�xO�W��}�m�H����s���No�-��!���`      �   �   x�u�I�0E��)�@Q���K+:(QҢ �R��^8������m�U��A�n��l{4��s�`,�^C��z4�w���{l�L�^�Z^le�0��tg���a�hB޲�_i�9�yJk�<!���ޞK��?GZ��x\)������A�f��k��<����Ч���~�ϰ��}�\+��B�G�:{\~����e�A      �   �   x�u��� Eg���DJH�u�c���]�%�)���!�Y��1����V�+��{�R5JQ�,��:�
N�y��h'���u�Gv��6,p���-��.޸iE*Ba��>n�f����4�Y쟾�MQ�w���!�4�� ��D:��#{l!��"���f���{��iI�ae�ͺ�,)�[d��i�3�j ��L��      �   O  x�u�9z�8�c�s��'��-�,�`#�}#p��ӝ�L+�	ԫz������_�ۯ��������~,o_��X_��m�a�8E>��[���K�0MȎ/�u9f|}��1c�A�E�H�F�7d��.��6Z�x������v;b���5vy+�%�q��M�Ã�e�5��q�:�	l�G\�=����	�w൝l�ٶ���1c�8�qE�0�q�Pq�QC�[qQ���P].��	�q�����x
2�J���(ٵD�ئ�l 8�����'CgPٲ�����:@%1�`����<f|e�G��ԝԮ��yh���H��s3'�����r���������ͿzK�*��EA��F��s���9Kc�/���vY^��G.�U��l�G[K(EV����hhA���q��1^���㜲@�� Y�k��pR��Ϝ$$ ~ߏ/�,/���h��[Ĉ�R�����c����aӔ�f�@֓��z� ��B@1��B}�A9��D�����R��!�c�:{s<��F"M��Urˬ܀�]�'?�����SIT�	I�6)PAN�}�e�q���l�ݼ����ҫ?r��Ў���$1Zj���7��86D���	�y2��q�2V0e��M�c���Yg\Ȕ����N��Q��Cj���%�CH[��ݤ/��5_��׍��ގ�2u$BU�-��B����w�����A���j�ɗ�v�'՚���+
���+�f-s�biq���'_�n4���xg"b��J���XE�X?m�.�a��u9��r����NG��e�1PX떛
4s�'6�){�/�u9NźWk�@�Z�\�Ti��8�����2��ǭ��ry��5t��h�6VT����Fw���XY
��Ǒ['�=iV�Z�g�xߌ�h+x����P��o����aឋ��-ː���E�b��������#t�����FC}��4~l�wK��)c��2Ӣqkk9n��y2���Þd�<2��-)F�|���౶�o�'z��qJFk�+���1����m�.i]O�<�k���rPp�D&
���J����V�|��}�^��z���      �   �  x�u��r� �5<E_ )u'�8��J\��4n3�p� !@ $����^l�������*�7yv��߲��*�[e�׫ۤ��N�PG'���֎�keUq/���o����j9s�t�C�f�;�Y����e,��EQ<���r~����T8I�L�!XJ���x��U�o������Mҩ�	הb)T�3Z�)��`Ԓn�����8�ľ���g�0=	�190�c�,�o�g������s� ׉|���1���_K�I��Ս����ˢx+��b~�-���Κ>ֳ�������j�m�у���^O;��k��I�F!<�J)k�8T�����x��y_��p�N�y���	���-�D�1�Yq�g4�#j�V�8�lw0ϖX��3������!<8��灌V2�aP��:�_��%��n�L     