PGDMP              	            v            PracticeSpringBoot    9.6.10     10.5 (Ubuntu 10.5-1.pgdg16.04+1) ?    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
                       false    1            �            1259    965914    app_user    TABLE     �  CREATE TABLE public.app_user (
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
    password character varying(255)
);
    DROP TABLE public.app_user;
       public         postgres    false    3            �            1259    965912    app_user_id_seq    SEQUENCE     x   CREATE SEQUENCE public.app_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.app_user_id_seq;
       public       postgres    false    186    3            �           0    0    app_user_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.app_user_id_seq OWNED BY public.app_user.id;
            public       postgres    false    185            �            1259    965925    author    TABLE       CREATE TABLE public.author (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    description character varying(255),
    first_name character varying(255),
    last_name character varying(255)
);
    DROP TABLE public.author;
       public         postgres    false    3            �            1259    965923    author_id_seq    SEQUENCE     v   CREATE SEQUENCE public.author_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.author_id_seq;
       public       postgres    false    188    3            �           0    0    author_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.author_id_seq OWNED BY public.author.id;
            public       postgres    false    187            �            1259    966182    books    TABLE     �  CREATE TABLE public.books (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    author character varying(255),
    description character varying(255),
    is_active character varying(255),
    pages integer,
    publisher character varying(255),
    title character varying(255) NOT NULL,
    category_id bigint,
    language_id bigint
);
    DROP TABLE public.books;
       public         postgres    false    3            �            1259    966180    books_id_seq    SEQUENCE     u   CREATE SEQUENCE public.books_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.books_id_seq;
       public       postgres    false    194    3            �           0    0    books_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.books_id_seq OWNED BY public.books.id;
            public       postgres    false    193            �            1259    965947    category    TABLE     �   CREATE TABLE public.category (
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
       public       postgres    false    3    190            �           0    0    category_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.category_id_seq OWNED BY public.category.id;
            public       postgres    false    189            �            1259    966210    city    TABLE     �   CREATE TABLE public.city (
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
       public       postgres    false    3    196            �           0    0    city_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.city_id_seq OWNED BY public.city.id;
            public       postgres    false    195            �            1259    966135    language    TABLE     �   CREATE TABLE public.language (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    is_deleted boolean,
    name character varying(255)
);
    DROP TABLE public.language;
       public         postgres    false    3            �            1259    966133    language_id_seq    SEQUENCE     x   CREATE SEQUENCE public.language_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.language_id_seq;
       public       postgres    false    192    3            �           0    0    language_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.language_id_seq OWNED BY public.language.id;
            public       postgres    false    191            �            1259    966226    library    TABLE        CREATE TABLE public.library (
    id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    address character varying(255),
    is_active boolean,
    name character varying(255),
    city_id bigint
);
    DROP TABLE public.library;
       public         postgres    false    3            �            1259    966224    library_id_seq    SEQUENCE     w   CREATE SEQUENCE public.library_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.library_id_seq;
       public       postgres    false    198    3            �           0    0    library_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.library_id_seq OWNED BY public.library.id;
            public       postgres    false    197                       2604    965917    app_user id    DEFAULT     j   ALTER TABLE ONLY public.app_user ALTER COLUMN id SET DEFAULT nextval('public.app_user_id_seq'::regclass);
 :   ALTER TABLE public.app_user ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    185    186    186                        2604    965928 	   author id    DEFAULT     f   ALTER TABLE ONLY public.author ALTER COLUMN id SET DEFAULT nextval('public.author_id_seq'::regclass);
 8   ALTER TABLE public.author ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    187    188    188            #           2604    966185    books id    DEFAULT     d   ALTER TABLE ONLY public.books ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);
 7   ALTER TABLE public.books ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    193    194    194            !           2604    965950    category id    DEFAULT     j   ALTER TABLE ONLY public.category ALTER COLUMN id SET DEFAULT nextval('public.category_id_seq'::regclass);
 :   ALTER TABLE public.category ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    189    190    190            $           2604    966213    city id    DEFAULT     b   ALTER TABLE ONLY public.city ALTER COLUMN id SET DEFAULT nextval('public.city_id_seq'::regclass);
 6   ALTER TABLE public.city ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    195    196    196            "           2604    966138    language id    DEFAULT     j   ALTER TABLE ONLY public.language ALTER COLUMN id SET DEFAULT nextval('public.language_id_seq'::regclass);
 :   ALTER TABLE public.language ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    191    192    192            %           2604    966229 
   library id    DEFAULT     h   ALTER TABLE ONLY public.library ALTER COLUMN id SET DEFAULT nextval('public.library_id_seq'::regclass);
 9   ALTER TABLE public.library ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    198    198            �          0    965914    app_user 
   TABLE DATA               �   COPY public.app_user (id, created_at, updated_at, auth, city, email, gender, is_active, mobile_number, name, password) FROM stdin;
    public       postgres    false    186   YE       �          0    965925    author 
   TABLE DATA               `   COPY public.author (id, created_at, updated_at, description, first_name, last_name) FROM stdin;
    public       postgres    false    188   �S       �          0    966182    books 
   TABLE DATA               �   COPY public.books (id, created_at, updated_at, author, description, is_active, pages, publisher, title, category_id, language_id) FROM stdin;
    public       postgres    false    194   �S       �          0    965947    category 
   TABLE DATA               Q   COPY public.category (id, created_at, updated_at, description, name) FROM stdin;
    public       postgres    false    190   	g       �          0    966210    city 
   TABLE DATA               P   COPY public.city (id, created_at, updated_at, city_code, city_name) FROM stdin;
    public       postgres    false    196   �h       �          0    966135    language 
   TABLE DATA               P   COPY public.language (id, created_at, updated_at, is_deleted, name) FROM stdin;
    public       postgres    false    192   �h       �          0    966226    library 
   TABLE DATA               `   COPY public.library (id, created_at, updated_at, address, is_active, name, city_id) FROM stdin;
    public       postgres    false    198   pi       �           0    0    app_user_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.app_user_id_seq', 104, true);
            public       postgres    false    185            �           0    0    author_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.author_id_seq', 1, false);
            public       postgres    false    187            �           0    0    books_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.books_id_seq', 100, true);
            public       postgres    false    193            �           0    0    category_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.category_id_seq', 9, true);
            public       postgres    false    189            �           0    0    city_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.city_id_seq', 1, false);
            public       postgres    false    195            �           0    0    language_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.language_id_seq', 11, true);
            public       postgres    false    191            �           0    0    library_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.library_id_seq', 1, false);
            public       postgres    false    197            '           2606    965922    app_user app_user_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT app_user_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.app_user DROP CONSTRAINT app_user_pkey;
       public         postgres    false    186            -           2606    965933    author author_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.author DROP CONSTRAINT author_pkey;
       public         postgres    false    188            5           2606    966190    books books_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.books DROP CONSTRAINT books_pkey;
       public         postgres    false    194            /           2606    965955    category category_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public         postgres    false    190            7           2606    966218    city city_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.city DROP CONSTRAINT city_pkey;
       public         postgres    false    196            1           2606    966140    language language_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.language
    ADD CONSTRAINT language_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.language DROP CONSTRAINT language_pkey;
       public         postgres    false    192            9           2606    966234    library library_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.library
    ADD CONSTRAINT library_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.library DROP CONSTRAINT library_pkey;
       public         postgres    false    198            )           2606    965976 $   app_user uk1j9d9a06i600gd43uu3km82jw 
   CONSTRAINT     `   ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT uk1j9d9a06i600gd43uu3km82jw UNIQUE (email);
 N   ALTER TABLE ONLY public.app_user DROP CONSTRAINT uk1j9d9a06i600gd43uu3km82jw;
       public         postgres    false    186            3           2606    966142 %   language uk_g8hr207ijpxlwu10pewyo65gv 
   CONSTRAINT     `   ALTER TABLE ONLY public.language
    ADD CONSTRAINT uk_g8hr207ijpxlwu10pewyo65gv UNIQUE (name);
 O   ALTER TABLE ONLY public.language DROP CONSTRAINT uk_g8hr207ijpxlwu10pewyo65gv;
       public         postgres    false    192            +           2606    965978 $   app_user ukg9deopqu0qe7p3cp88apqd9j2 
   CONSTRAINT     h   ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT ukg9deopqu0qe7p3cp88apqd9j2 UNIQUE (mobile_number);
 N   ALTER TABLE ONLY public.app_user DROP CONSTRAINT ukg9deopqu0qe7p3cp88apqd9j2;
       public         postgres    false    186            <           2606    966235 #   library fk6vg7f2xm4dcpd384hmkv2evjm    FK CONSTRAINT     �   ALTER TABLE ONLY public.library
    ADD CONSTRAINT fk6vg7f2xm4dcpd384hmkv2evjm FOREIGN KEY (city_id) REFERENCES public.city(id);
 M   ALTER TABLE ONLY public.library DROP CONSTRAINT fk6vg7f2xm4dcpd384hmkv2evjm;
       public       postgres    false    196    2103    198            ;           2606    966196 !   books fk7gm0q8hiuoyrgncs48ul0pp15    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk7gm0q8hiuoyrgncs48ul0pp15 FOREIGN KEY (language_id) REFERENCES public.language(id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fk7gm0q8hiuoyrgncs48ul0pp15;
       public       postgres    false    192    2097    194            :           2606    966191 !   books fk8el3ddb59ciucupyc17vu7835    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk8el3ddb59ciucupyc17vu7835 FOREIGN KEY (category_id) REFERENCES public.category(id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fk8el3ddb59ciucupyc17vu7835;
       public       postgres    false    194    2095    190            �   `  x�uZْ嶑}��?`A�$��)�4#�V��ǲC~�
p'����I�UwU�JD�SF��N���1	&��?��OA�=K����by���D���������__�������EW���Ls=���'���//���$`A�x�"N�k�ƌ�Y�7M���ş_����/�}����O��Tۈ^�E�e�X�����T�m;]T�Ǉ�����������o��Vi6w�"Q2&�.eݏ�L�zΩ�x�o;\���?�1����qlkٿ��!W�
�PĹ�]�l�t�� ?Zx��9�ǵS��*�Ă	y�f[�����ڎ2���^������Z�h��	��IS[ח�m�k2�<�{�uʌ��:`��*��,d۲<�ĥ�O�8~����1ү�}&�Vժ�:)C%�0�����N��e�:���j���~z��#9�ܸ�^�mP�q��Q��X�ݐ�:�	R�)�f��}?��Ï�_���)l��zm��2QLF
�vk5W�lw��y2����uVwv�&�^��U�!��ٖ5#M;n�L=�#<����r�\����00�xL��v�bo���O����m���v�7S�+r��S&��"�Ɩ��1��2<w2�s}۟��U�~�q �BE\����2��uUFC����*����������B�*O�������F���LWr�s]V�X$=�)��Z�z�f]�+�j�$"�I���<���m��Г:�L�����u�"�W"q�����'�k���T��Q�	S��/���&���1h�������k�����	l��U���}q���L��ۥ����c?��DU�g�k��]�֚��}P�#[�����ʦ�N�<U����n�d�ٕh�D"�r�٭=��&ƶz?h��$��4�տ�����?�"cQ��t�X�p�& �����I�֕�4��Gq��<~����y��8����I ���fƅ7�L}�x��?A�����F�^�ax
H_�_U� ���Ք��"O�y�"�`�r�m��1@�I�^saH��z�+=���!%�f�P/$.�$���k[�;R\s~���]�bO�c��"����``�B(Ed����^M9���O��使Mqm�Z�_��Ą  �]6��󾂿�JO�?@�9�})���@�<�@�������-A=�])���K�����\�5{�z	���`	#����&Y�kՄy#�P |ؿ^������T�<��fn���:7�1�{Fi�m�o ��k�6�Ƈg"dr#o@�f��ڶs:��P8+�/���:����:�D"�Q@��7�	���&�K�}��{�g^4�n��_��E&X���\�����T`���������՘��^C�(HB(�c�j7Af���T`�'�w�g<��(�c��"V�f���.9���.*<�C��a�Z�m~��)6\�*)� Y�Hq��\�B����N�q쯕��y����Fh ����n������
�'(�>��q�}}��`�&"L�����p>OE�<�����q�8�RC1�D^,�!�Р]��%����S��h8��?����6�z�D
)�7�(�MJ�|�ڝ
���@���L��R��
�Щ[7��gj��
<k�n�T=_�-s��'>ƒ@��t?tp����M�*� 2T�>�pP�Wy��p�`� ��J��C��;�p�a(�؟�t[��G�7aQ,�8"�0��%n�˴��'�(]z�߫�vm��Äo� Js��y6� @=�?�g{b���-����rC���%�n˹#C=�t�@�ӱ�w����r��{�p&��*V��}itK�3-{G=`ʼv����������N�Υ3W�;�s{-9�<����>li�e��՜8� ����$V�Cѐq�����w���F"�b({a�3�$D*@ Ky�~"�q�.����OX��-��;O@�G��� ��r(�v"�����A^�Y������ �tWe%j��⺊F�^��ȏK�u����II���)Pې�kn����oOMc)Ͻ�ؖ�z�2Å6�.l� n��9O��}l,�Ѐ������v4sc��@���oĤ$�v��!]j��1�>�*����,��r�\�B�����0�KY����\4��'��џ�Q���ߟބ�d0;fSٳ f];(��;�0	�䛓{���',�<���*���t�d�N��S���¾����2�Y�g@���2���/W^�&��
wPԄy>v&��9k�C�/2Y�q,9����g�s�h��'k��Βq���h�Q�c� �AD�>�Ǖ�K�����a����u8S�	�d"���!����A�dkh��O�+�����Z�T�c@q�e��:۵��2yy�G������t��-3�& �	|_,I�k9G@�tl7�xZ}�y؟�v�z��xbBn��HB�e��F��n�>Н�m�u[��jfl--b)� �%�a�*���w�D�xZQy���ķJ��0�g����to\Oʪ�uA=c9�̒����۸��S���(\	�|�k[}K�Qϝ�	H��_7�|�:����*`��Ϟݘ69��iIu����|��x ��s��¶|"��7����e�5���b[�G[r�R趿p=�z�lQ��{o+��yW�D�\Wf���@��_̯ �n{����q�� �{s�I5��j�-��0x⇮��o����1ǉ-h��<2rNu�jbW횑J�8�T}؟pam���;��J��0	H���RM��f��C�QE���?�q.\��P� Fj�.��N����JO�<x̫�0��ğ���K�[�k�����ɕ�����-̻�jʾ�Q7ax����q���v���.���t����w}������ �@q�,Ͳmd��l8�ʹ�.ޏ�qG��(�����+{��fZ�l��~���;WOB~3%�����1E���B�i���z��
��kg^w�,Oe"�c���@i��dU��9����#���Ry��*�N�Mc �+(��#�7}���g{+�n/gm�ڝ���"�(��f�ǃ4]QT�*~�G���Զ�n�����׈1��
�a��X���mH�G0���$v��%w�v�e�����V�q߻l��8܀��x<���ջ���,.����'	p��7�*w�Ty���+�$u�Ϋ���BA�h	#�aMS�ږu1R�;ٓT�F�������4Qt?�E��8���^eT�P#<�7��ﺅ[�Y`S�Q��6�}u������ƣUn��D��ٍ��qL��Iq���0�]Y��z��(o?���ir1���FYU��ԑ�>�3���t۟�WULg1��r��ނA�m�(��~������p��'�������+�'`I,���yN}�K��rKY�A$_�>f�G�i+l7c{�PJHj� ��?����eJ0���-]μn����^E���Z̍m`���)��1#�,��Ƕ����2.O9߆�T��%��nf��d2���y�I���ó����a���� ���0"c��<'}f�m�q0�#�t�l0�4�F/�
��ڨ/{���r/�>.���w��lF
����>T_���0ol��_lv�8�_ɳ8�����.K7�]��=迿���?&y��      �      x������ � �      �      x�}ZI�$;n]3O�����!3{��I;m89�3�yz�##�k�]*�p���{`\����?������?�|���������_���5>���(�E���"7VI֍���?��_�����eh�R�����������ݍjRE�Y�V�]�m�xK��z���/��_hYm�d�*�/��qr��qb��H�����yT6�w�ΌlB2�_�?�Ҵq�-��]���v|��~j��ZA��J�+]�fie̖ݐv��\~�P,E�ָ���<9�~%؅�fV4�!b�Bƍa1"إUn�^�_�wp��JC��5��(O�~�ۍPCG��G��J�c�1=�'�������@sM�d��Ł���qe~�۽��EDk�&�H-Ո��t�1m���U���7�P�]��&�+$���}|�Ϲ]���FV�1Y�f����ԲR�E���]>�hV�ֲF&t�(������?��aT��u���v�IN*��}�T�P8CC�.�]��q�sr�ٗ� ,M�
ڶ�d�m����]� �=���*�����0h��$y���$������-eG&JCj�%�����D�fI-���rG�z�*�I����~~�����ggB�tWDZT���R8�}�9��튊.Sҵ�s�����	����T� ��������U���&�u��y{�@�.�y���B��c ����������H�M�&V��^2�X<8��O������K$R
5>O�y��;do	-�����]_x�3�i�H$�/o�puDQ�;���H!����1�����nO��E"B5���\�l�Qh��셅Wn??��.Ԍ�-��`�@��}�*{�X M�"�5ӑyOe��!�I���/���O���@Y�	=��Gy����Q�������Ȳ���$�D�z�1�������.+ACt
 �Q8���sng��Ƒabɴ,>�XG���)̈́[�y!�*&��0l���8�?>�P�>��n�V���!s֛0�`/Ħj����٭C�W��;Rk��U���<B!8���)c�9��Ί���}�k `�]� ��s@���$�4-C�^>>�Pξ!ů���&�2��A��������3}��M죭�m���_�ξ��v��
�|�}0�[Q8�iD�K�뻆~��+�^m�מ�#���'��LV�ŠjZg1����:$�������y�ԭL�چ��������'q>�ل	�C�	M�Y�L�jH�����}��ژt337%t��<������;��^Q��f�f[r���י�M���7TK�J��@��@j��'-q|���z�����G�t���ܔf�vF�Wj��0���Ќh�o�'� �2�y �曣sQ �n�,|P�_e���#4'�EJK���(�΋�YB����6a�Xٺ�A�$)��/x�|ݑ����7ʀa^>�� t�s\̻����@�'�gJ��i�	!��M�)�dk���\ ���z\��C��k�4�b� ��}Y��\Ѷ/����B��%�W�=)������}��� w��<ik񗗹o}R-��Kx�\��\Q��u�Y(O&}�o��º@���c�#�n냏M%���rUR�^�/�}�a0�g_$�P�p�'�v=.�����40%��9�X��+�`M���|BjI�&��:�����q=Ơ�!���o�c�8n[�k��J{^�2� B_��vCnƼXP: ����<��	�����(j��R�68��KṬ0C���Ț��Aj E���=n���$�`Ｔ�P64K����v�z�9O |R�r%Gה4EuJ�x�	b��VE�n5_�d����]NP��@lD��ny���W��'�b�*�c
l��$���z{�9�69�g�6Z��@����T]e��=�"��.hm���d��>iO�)j��!%3��j�v]��%�
Y��}#�V�Y1�Q���.ώ>��o��˲
�w �����[�K\$ �f¢~�OĔ�tGT	H�
�<)�Cj�kǋV#VJ��8�����\V�]�����vY,�-ҳ����_���8?�#`�;�L*�8�,<nZi �:��|�5�����Y�� �"�O�y;���C��k�خ��1�na�bV�����o�'PO�UB�ֳ�Bgybk{"�	ܜ��]봲��5-�RX�$�E���=������s�A#�-���
:n��������(*�BZ0�,�כ��K2�{�+`O�7��4dۅ
��ɭ� �n7����9�� ��a��5��F՛��e*	1=}��u��$�Cy�ۿ����B2�sڮ( �j�S��;��lU���]x��1}>N�{��A��\l��Ҡ;IY�̬��K4�}Ϥ#�Ʈj}��1}~#�n'flL#�X4�%N�5���7ly�V��W*m*"=
H8��c��}�[`�Ez�t�����t�bjf���hl��$�� >SZ��~�����X.�s��� ���R�ȩ�Բcz%�b�%�/�PN��}|�OP�礇�>�ʛC�ٲ�E�҄њGap�,3
�~�O�w�A�(�Q���V���e�gMۜ�:`�x�mrd��Qx�:C�o�wGol -��Ў��c���v�ŭ��P�i��V��P�� �_�&�u�v��=E����>ᶻ.��Ю�;�����r�$儝���C;G���&����p?ơ�fN(�	5VK�f��Y�-�����Z�Z#\�j�˖��|����m�'i��ue��� ��7������6pj�W�WTVBFv�؞s��]�{R�j���L��+�v3���^�}�М�F��|G�����N�'��$�H�j�� ��R2��&q3Α�����( �j�����dYp�>�oHՒ���lG�d0��y�9��2ii@[��R����iꄤ��������?g��S4�A�E)u�lK hM�N�Um��5SXe��r�$>���8O��w<z�5����Pj�t���]�R��� }o��5�
4�o���q2�n�k��,˼���H��w�c��$n���l�/���o[��] B��|�>�Hs;A��Π5��Ԍ!C�ʡZ���JYp2��, -s$8�P��e8�<F��	�����3%c�9�U�1�ê��6(�b_����r]� �Ԍ���{�϶��'��H��Q�W��s�4.�"UĲ�◸�����*�zŐ�n%�s~�㺝������@~-)������IR�Fꬫ���[3��"%ZZȓ�<���b�Y�uE��cĥ�~�f��g��S���3�N(9�..��@_�t;��}Y71rtr�Ċ[����D�cм���5�H;�i��D�q±N(�m�)+�"�G�C9*yÔI!f��̲&����T9:
\�6���_'�}ʾ��x:�,���y%�7��4J�a��$М��i��K*��:�з�E�n7m�\
��o��q�ܔc�ۜ�@��x�� �'�"E;�wx�'��}�-`������2�u�Y[鸛��k2�tP��ɮk���(_'`sB1w{��� -�U:4#P= χ�v�T.o�FQ��G|̵�'��:����o��[~>7��I�0RX�fӊ%�����jTe��w�(�-���������9�X��LJ�uv��v����Xk�K��y�p��NO�N���d���ɀ��d�Ӹ����JW���x:���n����T��M�'����D����W���c�6V�*m�|�x����9>_/���;j�P�F,�����1������@V�Ui�^�FS�/.I�i�va���	�@�K��;o'ۦ����n7��Jԋ�7����0�Ӌߌ��| a�lyfd��
�>	�d��v���x�������m�xB%�-�������(4�h]=�I��OVb�}#�ЀH�[�c7�w�����j�:B5��@�x�F J����	���,v�[��y̧n�l|FP)^&����K�*u3�A�@N�d   "<�j�[���ο������G����|�D@C��̭��;N cψm=�}>�Q�~Bxw{.��8e������\��(%�X�޿-����(P���
��,�'ȿ��d0���}�0U��mgn�&A
7N���U�74I�kD�b��/��O�������#@8��4�rW�`~:�p<.�W�> L�AG`�����H2<�ͺ3���n��s�fI~"4;� Z�����4��e�}{��	����v?�صQj !NHkT����#ҫe��/�.��t
�U�:�;��_>}��8y�������p0�;N@� Y:.��k��f�V��)AYYQ�5�T'��q�&��� S
*-3I��%��Q�]�rXk�v�)f�}"`�����9���������`�ޗ��xsJL��\s�x�fm ��bː��
y��9��ɛ�n.�V�� ���yY/�łU�+@�{'d��ܣ������n'���ށzт o֌������궋hfz����
UF *�g�����d��8ْ�vSE� }"����YO,g��m���j�������³F�@��'�;����q�"7t("���nɉ.��A7i%�2�a�"C7� Qf"��4��<��I��$�� �q�W1���iYJk�z�u�B�u'��)�XP$PA�	���|ڏ>�|��\Oԙ<��9���we�ho�Y��Lc2�2��3�˟cz������)�JùU���;s�̱��q\A�	W��`;O��]��_���      �   i  x�u�9n�0 c����ə�l�N7��C$����WƦbF�Et���8=��}�����ޟ�q�����Ś���DE�H{ɒ֚&)��ʉ^ɍ�5r���Z4�u95KI�-AS{ ��"%NNn�1s~�"��\��}^��>���=�=&+���<A��#�����<L]�ז5b*l�0^���]mX�|��p��|����u<����PKh�D��O"�d�g�c:K�ws����D9�:h���X)\-�B�	��Z��iqrσs"�jjEG�m�1b$�Uf���"�v��H'����lv�W�nC�1�XJ�e�7v6~�xO�W��}�m�H����s���No�-��!���`      �      x������ � �      �   �   x�u��� E��W�4�(஋>�M�e7jA��&P���5�=97w�N�����:P�3ٷ�n�B� ��q�n����`8O�0�n���p�rKn����h�[r�O�e�)�6��j���n����	�[r1ᝪ�e��y�cV@f�d���=Ƽ ��,��'?�kf�,)��O����C������0fK5ó��u��      �      x������ � �     